package com.example.peternakanapps.ui.menu.home.hewan


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageButton
import com.example.peternakanapps.R
import com.example.peternakanapps.databinding.ActivityListHewanBinding

class HewanList : AppCompatActivity() {

    private lateinit var binding: ActivityListHewanBinding

    private var isButtonVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListHewanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur onClickListener untuk setiap CardView
        binding.cardview1.setOnClickListener {
            handleCardViewClick()
        }
        binding.cardview2.setOnClickListener {
            handleCardViewClick()
        }
        binding.cardview3.setOnClickListener {
            handleCardViewClick()
        }
        binding.cardview4.setOnClickListener {
            handleCardViewClick()
        }

        // Mengatur onClickListener untuk tombol back
        val backButton = findViewById<ImageButton>(R.id.back)
        backButton.setOnClickListener {
            handleBackButtonClick()
        }
        // Mengatur onClickListener untuk tombol plus
        val plusButton = findViewById<ImageButton>(R.id.buttonplus)
        plusButton.setOnClickListener {
            val intent = Intent(this, AddHewan::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_navigation_menu, menu)
        val bottomNavigationMenuItem = menu?.findItem(R.id.bottomNavigationView)
        bottomNavigationMenuItem?.isVisible = false // Mengatur visibilitas menjadi tidak terlihat
        return true
    }

    override fun onBackPressed() {
        if (isButtonVisible) {
            // Kembali ke kondisi awal
            binding.buttonjual.visibility = View.GONE
            binding.buttonlapor.visibility = View.GONE
            binding.buttonplus.visibility = View.VISIBLE
            isButtonVisible = false
        } else {
            // Kembali ke HomeFragment atau melakukan tindakan kembali default
            super.onBackPressed()
        }
    }

    private fun handleCardViewClick() {
        // Mengatur visibilitas buttonJual dan buttonLapor menjadi visible
        binding.buttonjual.visibility = View.VISIBLE
        binding.buttonlapor.visibility = View.VISIBLE
        // Mengatur visibilitas buttonPlus menjadi gone
        binding.buttonplus.visibility = View.GONE
        isButtonVisible = true
    }

    private fun handleBackButtonClick() {
        onBackPressed() // Memanggil fungsi onBackPressed yang telah kita override sebelumnya
    }
}
