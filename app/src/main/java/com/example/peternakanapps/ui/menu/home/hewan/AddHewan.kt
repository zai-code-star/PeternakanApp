package com.example.peternakanapps.ui.menu.home.hewan

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.peternakanapps.R
import com.google.android.material.button.MaterialButton
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class AddHewan : AppCompatActivity() {

    private lateinit var edittextTag: EditText
    private lateinit var edittagjenis: EditText
    private lateinit var editTagKategori: EditText
    private lateinit var imageButtonCross: ImageButton
    private lateinit var editTextHarga: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_hewan)

        val buttonTanggalKeluar = findViewById<ImageButton>(R.id.buttontanggal1)
        val tanggalView = findViewById<EditText>(R.id.tanggalview)
        val buttonTagDown = findViewById<ImageButton>(R.id.tagdown)
        val buttonTagKategori = findViewById<ImageButton>(R.id.tagkategori)
        val buttonTagjenis = findViewById<ImageButton>(R.id.buttonTagJnis)
        editTagKategori = findViewById(R.id.edittextkategori)
        edittextTag = findViewById(R.id.edittextTag)
        edittagjenis = findViewById(R.id.edittagjenis)
        imageButtonCross = findViewById(R.id.imageButtoncross)
        editTextHarga = findViewById(R.id.editTextHarga)

        // Menambahkan OnClickListener ke tombol tanggal keluar
        buttonTanggalKeluar.setOnClickListener {
            showDatePickerDialog(tanggalView)
        }

        // Menambahkan OnClickListener ke tombol pilihan warna
        buttonTagDown.setOnClickListener {
            showColorSelectionDialog()
        }
        // Menambahkan OnClickListener ke tombol pilihan warna
        buttonTagKategori.setOnClickListener {
            showColorSelectionDialogKategori()
        }
        // Menambahkan OnClickListener ke tombol pilihan warna
        buttonTagjenis.setOnClickListener {
            showColorSelectionDialogJenis()
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

    private fun showColorSelectionDialog() {
        val colors = arrayOf("Kuning", "Hijau", "Merah", "Putih")

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Pilih Warna")
        builder.setItems(colors) { _, which ->
            val selectedColor = colors[which]
            edittextTag.setText(selectedColor)
            // Mengubah warna dan bentuk ImageButton berdasarkan warna yang dipilih
            updateCrossImageButton(selectedColor)
        }

        val dialog = builder.create()
        dialog.show()
    }
 private fun showColorSelectionDialogKategori() {
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
    private fun showColorSelectionDialogJenis() {
        val text = arrayOf("Kambing Madura", "Kambing Saanen","Kambing Kacang","Kambing boer","Kambing Etawa","Tanpa spesies" )

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Pilih Jenis Kambing")
        builder.setItems(text) { _, which ->
            val selectedColor = text[which]
            edittagjenis.setText(selectedColor)
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun updateCrossImageButton(selectedColor: String) {
        val drawable = GradientDrawable()
        // Mengatur bentuk oval
        drawable.shape = GradientDrawable.OVAL
        // Mengatur warna berdasarkan warna yang dipilih
        drawable.setColor(getColorFromString(selectedColor))
        imageButtonCross.background = drawable
    }

    private fun getColorFromString(colorString: String): Int {
        return when (colorString.toLowerCase(Locale.getDefault())) {
            "kuning" -> Color.YELLOW
            "hijau" -> Color.GREEN
            "merah" -> Color.RED
            "putih" -> Color.WHITE
            else -> Color.BLACK // Default color
        }
    }
}