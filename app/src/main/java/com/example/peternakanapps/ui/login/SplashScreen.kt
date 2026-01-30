package com.example.peternakanapps.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.example.peternakanapps.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Menunda navigasi ke LoginActivity selama 3 detik
        Handler().postDelayed({
            // Mengecek apakah pengguna sudah login sebelumnya
            if (isUserLoggedIn()) {
                // Jika sudah login, langsung masuk ke LoadActivity
                val intent = Intent(this, Load::class.java)
                startActivity(intent)
                finish() // Menutup SplashScreen agar tidak bisa kembali lagi
            } else {
                // Jika belum login, masuk ke LoginActivity
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish() // Menutup SplashScreen agar tidak bisa kembali lagi
            }
        }, 3000) // 3000 milliseconds = 3 detik
    }

    private fun isUserLoggedIn(): Boolean {
        // Mengambil status login pengguna dari SharedPreferences
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }
}

