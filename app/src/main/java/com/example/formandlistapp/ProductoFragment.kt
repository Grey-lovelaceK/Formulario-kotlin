package com.example.formandlistapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.formandlistapp.databinding.FragmentProductoBinding

class ProductoFragment : Fragment() {

    private var _binding: FragmentProductoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val productList = listOf(
            Product("Laptop Gamer Pro", "Potente laptop para juegos y trabajo", 1499.99, "producto1.jpg"),
            Product("MacBook Air", "Ultraligera y eficiente para el día a día", 999.00, "producto2.jpg"),
            Product("Desktop Workstation", "Máximo rendimiento para diseño y desarrollo", 2199.50, "producto3.jpg"),
            Product("All-in-One PC", "Elegancia y funcionalidad en un solo equipo", 1250.00, "producto4.jpg")
        )


        val productAdapter = ProductAdapter(productList) { product ->
            // Navigate on click, passing the product
            val action = ProductoFragmentDirections.actionProductoFragmentToDetalleProductoFragment(product)
            findNavController().navigate(action)
        }


        binding.productRecyclerView.apply<androidx.recyclerview.widget.RecyclerView> {
            layoutManager = LinearLayoutManager(context)
            adapter = productAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}