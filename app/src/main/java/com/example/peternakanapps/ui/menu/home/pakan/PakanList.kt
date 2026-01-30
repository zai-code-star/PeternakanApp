package com.example.peternakanapps.ui.menu.home.pakan


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageButton
import com.example.peternakanapps.R
import com.example.peternakanapps.databinding.ActivityPakanListBinding

class PakanList : AppCompatActivity() {

    private lateinit var binding: ActivityPakanListBinding

    private var isButtonVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPakanListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur onClickListener untuk tombol plus
        val plusButton = findViewById<ImageButton>(R.id.buttonplus)
        plusButton.setOnClickListener {
            val intent = Intent(this, AddPakan::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_navigation_menu, menu)
        val bottomNavigationMenuItem = menu?.findItem(R.id.bottomNavigationView)
        bottomNavigationMenuItem?.isVisible = false // Mengatur visibilitas menjadi tidak terlihat
        return true
    }
}
