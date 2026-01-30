package com.example.peternakanapps.ui.login

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.InputType
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.peternakanapps.R
import com.example.peternakanapps.ui.register.Register

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val showPasswordButton = findViewById<ImageButton>(R.id.showPasswordButton)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerTextView = findViewById<TextView>(R.id.textdaftar) // TextView untuk "Daftar"

        // Set default icon to eye closed
        showPasswordButton.setImageResource(R.drawable.ic_eye_closed)

        // Add click listener to toggle password visibility
        showPasswordButton.setOnClickListener {
            // Check current input type of password EditText
            if (passwordEditText.inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                // Change input type to password
                passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                // Change button icon to eye closed
                showPasswordButton.setImageResource(R.drawable.ic_eye_closed)
            } else {
                // Change input type to visible password
                passwordEditText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                // Change button icon to eye open
                showPasswordButton.setImageResource(R.drawable.ic_eye_closed)
            }
            // Move cursor to the end of text
            passwordEditText.setSelection(passwordEditText.text.length)
        }

        // Add click listener to login button
        loginButton.setOnClickListener {
            // Retrieve entered ID/Username and password
            val enteredUsername = findViewById<EditText>(R.id.edittextusername).text.toString()
            val enteredPassword = passwordEditText.text.toString()

            // Check if entered credentials are valid
            if ((enteredUsername == "081253" || enteredUsername == "admin") && enteredPassword == "123456") {
                // Credentials are correct, show success message
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                // Set status login pengguna ke true
                setLoggedIn(true)

                val intent = Intent(this, Load::class.java)
                startActivity(intent)
                // Finish current activity
                finish()
            } else {
                // Credentials are incorrect, show error message
                Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show()
            }
        }

        // Add onClickListener to registerTextView (Daftar)
        registerTextView.setOnClickListener {
            // Create intent for RegisterActivity
            val intent = Intent(this, Register::class.java)

            // Terapkan animasi untuk memunculkan RegisterActivity dari bawah
            startActivity(intent)
            overridePendingTransition(R.anim.slide_up, R.anim.slide_down)
        }
    }

    private fun setLoggedIn(isLoggedIn: Boolean) {
        // Simpan status login pengguna ke SharedPreferences
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", isLoggedIn)
        editor.apply()
    }
}
