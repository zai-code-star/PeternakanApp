package com.example.peternakanapps.ui.register

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.peternakanapps.R
import java.util.Calendar


class Register : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val buttonTanggalKeluar = findViewById<ImageView>(R.id.imageView7)
        val tanggalView = findViewById<EditText>(R.id.editTextTTL2)

        // Menambahkan OnClickListener ke tombol tanggal keluar
        buttonTanggalKeluar.setOnClickListener {
            showDatePickerDialog(tanggalView)
        }
    }

    private fun showDatePickerDialog(tanggalView: EditText) {
        // Mendapatkan tanggal saat ini untuk menetapkan tanggal awal di KalenderDialog
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Membuat DatePickerDialog dan menetapkan listener untuk menangani pemilihan tanggal
        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                // Menangani pemilihan tanggal di sini
                val selectedDate = "$selectedDay-${selectedMonth + 1}-$selectedYear"
                // Memperbarui teks di EditText tanggalView dengan tanggal yang dipilih
                tanggalView.setText(selectedDate)
            },
            year,
            month,
            day
        )

        // Menampilkan KalenderDialog
        datePickerDialog.show()
    }


    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_down, R.anim.slide_down)
    }

}
