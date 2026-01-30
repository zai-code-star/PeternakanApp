package com.example.peternakanapps.ui.menu.home.barang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import com.example.peternakanapps.R
import com.google.android.material.button.MaterialButton

class BarangList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barang_list)

        // Mengambil referensi tombol plus
        val buttonPlus = findViewById<ImageButton>(R.id.buttonplus)
        val buttonHapus = findViewById<ImageButton>(R.id.buttonlihatstok)

        // Menambahkan fungsi onClickListener ke tombol plus
        buttonPlus.setOnClickListener {
            // Memulai aktivitas "Tambah Barang"
            val intent = Intent(this, AddBarang::class.java)
            startActivity(intent)
        }
            buttonHapus.setOnClickListener {
                showCustomDialog()
            }
        }

    private fun showCustomDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_stok_barang, null)

        val alertDialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()

        // Mendapatkan referensi ke buttonbatal langsung dari dialogView
        val imageView21 = dialogView.findViewById<ImageButton>(R.id.silang)
        imageView21.setOnClickListener {
            alertDialog.dismiss()
        }
    }
}