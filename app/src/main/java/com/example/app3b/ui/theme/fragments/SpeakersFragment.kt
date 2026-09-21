package com.example.app3b.ui.theme.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app3b.R

class SpeakersFragment : Fragment() {

    private lateinit var rvSpeakers: RecyclerView
    private lateinit var rlBase: RelativeLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicialización de vistas
        rvSpeakers = view.findViewById(R.id.rvSpeakers)
        rlBase = view.findViewById(R.id.rlBase)

        // Configuración indispensable para que el RecyclerView muestre sus elementos
        rvSpeakers.layoutManager = LinearLayoutManager(requireContext())

        // Ocultamos la capa de carga una vez que la pantalla está lista
        hideLoading()
    }

    // Métodos para controlar la visibilidad de la capa de carga
    fun showLoading() {
        rlBase.visibility = View.VISIBLE
    }

    fun hideLoading() {
        rlBase.visibility = View.GONE
    }
}