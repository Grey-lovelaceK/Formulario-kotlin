package com.example.formandlistapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.formandlistapp.databinding.FragmentDatosBinding

class DatosFragment : Fragment() {

    private var _binding: FragmentDatosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDatosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Limpiamos el contenedor por si ya había tarjetas
        binding.userCardsContainer.removeAllViews()

        // Recorremos cada usuario y creamos su tarjeta
        for (user in DataRepository.users) {
            val cardView = layoutInflater.inflate(R.layout.item_user, binding.userCardsContainer, false)

            val nameTextView = cardView.findViewById<TextView>(R.id.text_name)
            val emailTextView = cardView.findViewById<TextView>(R.id.text_email)
            val phoneTextView = cardView.findViewById<TextView>(R.id.text_phone)
            val ageTextView = cardView.findViewById<TextView>(R.id.text_age)
            val addressTextView = cardView.findViewById<TextView>(R.id.text_address)

            nameTextView.text = user.nombre
            emailTextView.text = user.correo
            phoneTextView.text = user.telefono
            ageTextView.text = user.edad
            addressTextView.text = user.direccion


            binding.userCardsContainer.addView(cardView)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
