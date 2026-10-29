package com.example.app3b.model

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app3b.R

data class Usuario(
    var nombre: String = "",
    var correo: String = "",
    var rol: String = "",
    var asistencia: Boolean = true

)