package com.example.peternakanapps.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.peternakanapps.R
import android.content.Intent
import android.os.Handler
import com.example.peternakanapps.ui.menu.MainActivity
import com.example.peternakanapps.ui.register.Register

class Load : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

        // Handler untuk menunda perpindahan ke RegisterActivity selama 3 detik
        Handler().postDelayed({
            // Intent untuk memulai RegisterActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Menutup activity saat ini agar tidak kembali ke activity sebelumnya
        }, 3000) // 3000 milidetik = 3 detik
    }
}
