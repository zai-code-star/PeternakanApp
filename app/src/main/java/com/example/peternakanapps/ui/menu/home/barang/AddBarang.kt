package com.example.peternakanapps.ui.menu.home.barang

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import com.example.peternakanapps.R
import java.util.Calendar

class AddBarang : AppCompatActivity() {
    private lateinit var edithargabarag: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_barang)

        val buttonTanggalKeluar = findViewById<ImageButton>(R.id.buttontanggalkeluar)
        val tanggalView = findViewById<EditText>(R.id.tanggaledit)
        edithargabarag = findViewById(R.id.edithargabarag)

        // Menambahkan OnClickListener ke tombol tanggal keluar
        buttonTanggalKeluar.setOnClickListener {
            showDatePickerDialog(tanggalView)
        }
        // Menambahkan TextWatcher ke EditText harga
        edithargabarag.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Tidak digunakan dalam contoh ini
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Tidak digunakan dalam contoh ini
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Mengatur koma setiap tiga digit
                edithargabarag.removeTextChangedListener(this)
                val cleanString = s.toString().replace("[^\\d]".toRegex(), "")
                val formatted = StringBuilder()
                var count = 0
                for (i in cleanString.length downTo 1) {
                    formatted.insert(0, cleanString[i - 1])
                    count++
                    if (count % 3 == 0 && i != 1) {
                        formatted.insert(0, ",")
                    }
                }
                edithargabarag.setText(formatted.toString())
                edithargabarag.setSelection(edithargabarag.text.length)
                edithargabarag.addTextChangedListener(this)
            }
        })

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
}