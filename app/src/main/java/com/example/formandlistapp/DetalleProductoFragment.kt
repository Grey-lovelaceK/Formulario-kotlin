package com.example.formandlistapp

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.formandlistapp.databinding.FragmentDetalleProductoBinding
import java.io.IOException
import java.io.InputStream

class DetalleProductoFragment : Fragment() {

    private var _binding: FragmentDetalleProductoBinding? = null
    private val binding get() = _binding!!

    // Get the arguments passed from the previous fragment
    private val args: DetalleProductoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalleProductoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the product from the arguments
        val product = args.product

        // Populate the views with the product data
        binding.detailProductName.text = product.name
        binding.detailProductPrice.text = String.format("$%.2f", product.price)
        binding.detailProductDescription.text = product.description

        // Load image from assets
        try {
            val inputStream: InputStream = requireContext().assets.open(product.imageFileName)
            val drawable = Drawable.createFromStream(inputStream, null)
            binding.detailProductImage.setImageDrawable(drawable)
        } catch (e: IOException) {
            e.printStackTrace()
            // Optionally, set a placeholder or error image
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
