package com.example.app3b.ui.theme.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app3b.R
import com.example.app3b.model.Usuario

class UsuariosAdapter(private val listaUsuarios: List<Usuario>) :
    RecyclerView.Adapter<UsuariosAdapter.UsuarioViewHolder>() {

    class UsuarioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        val tvCorreo: TextView = view.findViewById(R.id.tvCorreo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.id.item_usuario, parent, false) // Asegúrate de usar el layout correcto
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = listaUsuarios[position]
        holder.tvNombre.text = usuario.nombre
        holder.tvCorreo.text = usuario.correo
    }

    override fun getItemCount(): Int = listaUsuarios.size
}