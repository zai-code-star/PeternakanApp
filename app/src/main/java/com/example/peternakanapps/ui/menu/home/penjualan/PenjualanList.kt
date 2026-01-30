package com.example.peternakanapps.ui.menu.home.penjualan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.peternakanapps.R

class PenjualanList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penjualan_list)

        val buttonPlus = findViewById<ImageButton>(R.id.buttonplus)
        buttonPlus.setOnClickListener {
            // Panggil fungsi untuk memulai aktivitas AddPenjualan
            startAddPenjualanActivity()
        }
    }
    private fun startAddPenjualanActivity() {
        val intent = Intent(this, AddPenjualan::class.java)
        startActivity(intent)
    }
}