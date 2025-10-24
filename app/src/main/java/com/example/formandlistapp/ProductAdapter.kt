package com.example.formandlistapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.formandlistapp.databinding.ItemProductoBinding
import java.io.IOException

class ProductAdapter(
    private val products: List<Product>,
    private val onClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
        holder.itemView.setOnClickListener { onClick(product) }
    }

    override fun getItemCount(): Int = products.size

    class ProductViewHolder(
        private val binding: ItemProductoBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.productName.text = product.name
            binding.productPrice.text = String.format("$%.2f", product.price)

            // Cargar imagen con Glide desde assets
            try {
                Glide.with(context)
                    .load("file:///android_asset/${product.imageFileName}")
                    .placeholder(R.drawable.ic_launcher_foreground) // mientras carga
                    .error(R.drawable.ic_launcher_foreground) // si hay error
                    .centerCrop()
                    .into(binding.productImage)
            } catch (e: Exception) {
                e.printStackTrace()
                binding.productImage.setImageResource(R.drawable.ic_launcher_foreground)
            }
        }
    }
}