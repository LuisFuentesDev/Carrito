package com.example.carrito

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.carrito.databinding.ItemLayoutBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var inventarioZapatilla = mutableListOf<Zapatilla>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = inventarioZapatilla[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return inventarioZapatilla.size
    }

    fun setData(shoes: List<Zapatilla>) {
        this.inventarioZapatilla = shoes.toMutableList()
    }

    class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(inventario: Zapatilla) {
            binding.textViewNombre.text = inventario.nombre
            binding.textViewPrecio.text = inventario.precio.toString()
            binding.imageViewZapatilla.load(inventario.url)
            val bundle = Bundle()
            bundle.putString("nombre", inventario.nombre)
            bundle.putString("precio", inventario.precio.toString())
            bundle.putString("url", inventario.url)
            binding.cardView.setOnClickListener {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_zapatillasFragment_to_detalleFragment, bundle)
            }

        }
    }
}