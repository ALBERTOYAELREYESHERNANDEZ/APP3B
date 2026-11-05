package com.example.app3b.ui.theme.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app3b.R
import com.example.app3b.model.Usuario
import com.example.app3b.ui.adapter.UsuariosAdapter
import com.google.firebase.firestore.FirebaseFirestore

class UsuariosFragment : Fragment() {

    private lateinit var rvUsuarios: RecyclerView
    private val listaUsuarios = mutableListOf<Usuario>()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_usuarios, container, false)

        rvUsuarios = view.findViewById(R.id.rvUsuarios)
        rvUsuarios.layoutManager = LinearLayoutManager(requireContext())

        // Llamar a la función para traer los datos de Firebase
        obtenerTodosLosUsuarios()

        return view
    }

    private fun obtenerTodosLosUsuarios() {
        // Consultar la colección "usuarios" completa
        db.collection("usuarios")
            .get()
            .addOnSuccessListener { result ->
                listaUsuarios.clear()
                for (document in result) {
                    // Convertir cada documento de Firestore a la clase Usuario
                    val usuario = document.toObject(Usuario::class.java)
                    listaUsuarios.add(usuario)
                }

                // Asignar el adaptador al RecyclerView para mostrar la lista en pantalla
                rvUsuarios.adapter = UsuariosAdapter(listaUsuarios)
            }
            .addOnFailureListener { exception ->
                Log.e("FirestoreError", "Error al obtener usuarios: ${exception.message}")
            }
    }
}