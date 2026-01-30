package com.example.peternakanapps.ui.menu.home.pakan

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import com.example.peternakanapps.R
import com.google.android.material.button.MaterialButton
import java.util.Calendar

class AddPakan : AppCompatActivity() {

    private lateinit var editTextHarga: EditText
    private lateinit var editTagKategori: EditText
    private lateinit var edittextjenis: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pakan)

        editTextHarga = findViewById(R.id.editTextHargaa)

        val buttonTanggalKeluar = findViewById<ImageButton>(R.id.imageButton2)
        val tanggalView = findViewById<EditText>(R.id.edittexttangal)
        val buttonTagKategori = findViewById<ImageButton>(R.id.buttonTagKategori)
        val buttonTagJneis = findViewById<ImageButton>(R.id.tagdownjenis)
        editTagKategori = findViewById(R.id.editTagKat)
        edittextjenis = findViewById(R.id.edittextjenis)


        // Menambahkan OnClickListener ke tombol pilihan warna
        buttonTagKategori.setOnClickListener {
            showKategoriSelectionDialog()
        }
        // Menambahkan OnClickListener ke tombol pilihan warna
        buttonTagJneis.setOnClickListener {
            showJenisSelectionDialog()
        }
        // Menambahkan OnClickListener ke tombol tanggal keluar
        buttonTanggalKeluar.setOnClickListener {
            showDatePickerDialog(tanggalView)
        }

        val buttonHapus = findViewById<MaterialButton>(R.id.buttonhapus)
        buttonHapus.setOnClickListener {
            showCustomDialog()
        }
        // Menambahkan TextWatcher ke EditText harga
        editTextHarga.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Tidak digunakan dalam contoh ini
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Tidak digunakan dalam contoh ini
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Mengatur koma setiap tiga digit
                editTextHarga.removeTextChangedListener(this)
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
                editTextHarga.setText(formatted.toString())
                editTextHarga.setSelection(editTextHarga.text.length)
                editTextHarga.addTextChangedListener(this)
            }
        })

    }

    private fun showJenisSelectionDialog() {
        val colors = arrayOf("Rumput Gajah", "Rumput Setaria ", "Rumput Benggala ", "Rumput Odot ", "Rumput Guatemala ", " Rumput Tebu ","DEDAK","JERAMI")

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Pilih Jenis Pakan")
        builder.setItems(colors) { _, which ->
            val selectedColor = colors[which]
            edittextjenis.setText(selectedColor)

        }

        val dialog = builder.create()
        dialog.show()
    }
    private fun showKategoriSelectionDialog() {
        val text = arrayOf("Penggemukan", "Pengembangbiakan")

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Pilih Kategori")
        builder.setItems(text) { _, which ->
            val selectedColor = text[which]
            editTagKategori.setText(selectedColor)
        }

        val dialog = builder.create()
        dialog.show()
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

    private fun showCustomDialog() {
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog_layout, null)

        val alertDialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()

        // Mendapatkan referensi ke buttonbatal langsung dari dialogView
        val buttonBatal = dialogView.findViewById<MaterialButton>(R.id.buttonbatal)
        buttonBatal.setOnClickListener {
            alertDialog.dismiss()
        }
    }
}