package com.example.peternakanapps.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.peternakanapps.R
import androidx.fragment.app.Fragment
import com.example.peternakanapps.ui.menu.home.HomeFragment
import com.example.peternakanapps.ui.menu.profile.ProfileFragment
import com.example.peternakanapps.ui.menu.history.HistoryFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menampilkan HomeFragment saat Activity pertama kali dibuat
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()

        // Memberikan listener untuk bottom navigation view
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_home -> selectedFragment = HomeFragment()
                R.id.nav_history -> selectedFragment = HistoryFragment()
                R.id.nav_profile -> selectedFragment = ProfileFragment()
            }
            // Replace fragment yang ditampilkan dengan fragment yang dipilih
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment).commit()
            }
            true
        }
    }
}
