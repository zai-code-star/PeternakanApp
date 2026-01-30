package com.example.peternakanapps.ui.menu.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityOptionsCompat
import com.example.peternakanapps.R

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Mendapatkan referensi ke CardView
        val cardEditProfile = view.findViewById<CardView>(R.id.cardedit)

        // Menambahkan OnClickListener ke CardView
        cardEditProfile.setOnClickListener {
            // Intent untuk memulai EditProfileActivity
            val intent = Intent(requireContext(), EditProfile::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                requireActivity(),
                cardEditProfile, // cardEditProfile sebagai shared element
                "transition_edit_profile"
            )
            startActivity(intent, options.toBundle())
        }
        // Mendapatkan referensi ke ImageView
        val imageView20 = view.findViewById<ImageView>(R.id.imageView20)
        // Mendapatkan referensi ke ImageView
        val imageView = view.findViewById<ImageView>(R.id.imageView)

        // Menambahkan OnClickListener ke ImageView
        imageView20.setOnClickListener {
            // Intent untuk memulai LihatProfileActivity saat imageView20 diklik
            val intent = Intent(requireContext(), LihatProfile::class.java)
            startActivity(intent)
        }
        // Menambahkan OnClickListener ke ImageView
        imageView.setOnClickListener {
            // Intent untuk memulai LihatProfileActivity saat imageView20 diklik
            val intent = Intent(requireContext(), LihatProfile::class.java)
            startActivity(intent)
        }

        return view
    }
}