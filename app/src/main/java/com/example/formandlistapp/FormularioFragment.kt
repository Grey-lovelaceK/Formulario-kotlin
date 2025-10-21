package com.example.formandlistapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FormularioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_formulario, container, false)

        val etNombre = view.findViewById<EditText>(R.id.etNombre)
        val etCorreo = view.findViewById<EditText>(R.id.etCorreo)
        val etTelefono = view.findViewById<EditText>(R.id.etTelefono)
        val etEdad = view.findViewById<EditText>(R.id.etEdad)
        val etDireccion = view.findViewById<EditText>(R.id.etDireccion)
        val btnEnviar = view.findViewById<Button>(R.id.btnEnviar)

        btnEnviar.setOnClickListener {
            val user = User(
                nombre = etNombre.text.toString(),
                correo = etCorreo.text.toString(),
                telefono = etTelefono.text.toString(),
                edad = etEdad.text.toString(),
                direccion = etDireccion.text.toString()
            )
            DataRepository.addUser(user)
            findNavController().navigate(R.id.action_formularioFragment_to_datosFragment)
        }

        return view
    }
}
