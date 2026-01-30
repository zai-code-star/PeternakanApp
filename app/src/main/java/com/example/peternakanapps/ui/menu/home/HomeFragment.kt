package com.example.peternakanapps.ui.menu.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityOptionsCompat
import com.example.peternakanapps.R
import com.example.peternakanapps.ui.menu.home.barang.BarangList
import com.example.peternakanapps.ui.menu.home.hewan.HewanList
import com.example.peternakanapps.ui.menu.home.pakan.PakanList
import com.example.peternakanapps.ui.menu.home.penjualan.PenjualanList

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Mendapatkan referensi ke CardView
        val cardViewHewan = view.findViewById<CardView>(R.id.cardviewhewan)
        val cardviewpakan = view.findViewById<CardView>(R.id.cardviewpakan)
        val cardviewpenjualan = view.findViewById<CardView>(R.id.cardviewpenjualan)
        val cardviewbarang = view.findViewById<CardView>(R.id.cardviewbarang)

        // Menambahkan OnClickListener ke CardView
        cardViewHewan.setOnClickListener {
            // Intent untuk memulai ListHewanActivity
            val intent = Intent(requireContext(), HewanList::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                requireContext(),
                R.anim.slide_in_right, // animasi masuk dari kanan
                R.anim.slide_out_left // animasi keluar ke kiri
            )
            startActivity(intent, options.toBundle())
        }
        // Menambahkan OnClickListener ke CardView
        cardviewpakan.setOnClickListener {
            // Intent untuk memulai ListHewanActivity
            val intent = Intent(requireContext(), PakanList::class.java)
            startActivity(intent)
        }
        // Menambahkan OnClickListener ke CardView
        cardviewpenjualan.setOnClickListener {
            // Intent untuk memulai ListPenjualanActivity
            val intent = Intent(requireContext(), PenjualanList::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                requireContext(),
                R.anim.slide_in_right, // animasi masuk dari kanan
                R.anim.slide_out_left // animasi keluar ke kiri
            )
            startActivity(intent, options.toBundle())
        }
        // Menambahkan OnClickListener ke CardView
        cardviewbarang.setOnClickListener {
            val intent = Intent(requireContext(), BarangList::class.java)
            startActivity(intent)
        }
        return view
    }
}
