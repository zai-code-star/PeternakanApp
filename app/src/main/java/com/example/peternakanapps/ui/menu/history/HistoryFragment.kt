package com.example.peternakanapps.ui.menu.history

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Shader
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.peternakanapps.R
import com.google.android.material.button.MaterialButton

class HistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        val chartContainer = view.findViewById<View>(R.id.chartContainer) as ViewGroup
        chartContainer.addView(CircularChartView(requireContext()))

        val cardPengeluaran = view.findViewById<ImageButton>(R.id.cardpengeluaran)
        cardPengeluaran.setOnClickListener {
            showCustomDialog()
        }
        val cardPemasukan = view.findViewById<ImageButton>(R.id.cardpemasukan)
        cardPemasukan.setOnClickListener {
            showCustomDialog2()
        }
        return view
    }

    private fun showCustomDialog2() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_pemasukan, null)

        val alertDialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()

        // Mendapatkan referensi ke buttonbatal langsung dari dialogView
        val imageView21 = dialogView.findViewById<ImageButton>(R.id.imageView21)
        imageView21.setOnClickListener {
            alertDialog.dismiss()
        }
    }

    private fun showCustomDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_pengeluaran, null)

        val alertDialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()

        // Mendapatkan referensi ke buttonbatal langsung dari dialogView
        val imageView21 = dialogView.findViewById<ImageButton>(R.id.imageView21)
        imageView21.setOnClickListener {
            alertDialog.dismiss()
        }
    }

    inner class CircularChartView(context: Context) : View(context) {

        private val paint70: Paint = Paint()
        private val paint30: Paint = Paint()

        private var dataPercentage70 = 0.8f // 70%
        private var dataPercentage30 = 0.2f // 30%

        init {
            paint70.isAntiAlias = true
            paint70.style = Paint.Style.FILL
            paint70.color = Color.parseColor("#32B4FD") // Warna 70%

            paint30.isAntiAlias = true
            paint30.style = Paint.Style.FILL
            paint30.color = Color.parseColor("#FFBB00") // Warna 30%
        }

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            val centerX = width / 2f
            val centerY = height / 2f
            val radius = (Math.min(width, height) / 2 * 0.8).toFloat()

            // Menggambar bagian 70%
            val startAngle70 = -90f
            val sweepAngle70 = dataPercentage70 * 360
            canvas.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius,
                startAngle70, sweepAngle70, true, paint70)

            // Menggambar bagian 30%
            val startAngle30 = startAngle70 + sweepAngle70
            val sweepAngle30 = dataPercentage30 * 360
            canvas.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius,
                startAngle30, sweepAngle30, true, paint30)
        }
    }
}