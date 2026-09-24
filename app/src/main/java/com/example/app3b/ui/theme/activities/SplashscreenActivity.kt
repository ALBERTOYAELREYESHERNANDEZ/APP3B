package com.example.app3b.ui.theme.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.app3b.MainActivity
import com.example.app3b.R
import com.google.firebase.auth.FirebaseAuth

class SplashscreenActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        auth = FirebaseAuth.getInstance()

        // Temporizador de 2 segundos antes de redirigir
        Handler(Looper.getMainLooper()).postDelayed({
            checkUserSession()
        }, 2000)
    }

    private fun checkUserSession() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            // Usuario autenticado -> ir a MainActivity
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            // Sin sesión -> ir a LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()
    }
}