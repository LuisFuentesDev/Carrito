package com.example.carrito

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import coil.load
import com.example.carrito.databinding.FragmentDetalleBinding
import com.example.carrito.databinding.FragmentZapatillasBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "nombre"
private const val ARG_PARAM2 = "precio"
private const val ARG_PARAM3 = "url"

/**
 * A simple [Fragment] subclass.
 * Use the [DetalleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetalleFragment : Fragment() {
    private lateinit var binding: FragmentDetalleBinding
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(inflater, container, false)
        initListener()
        return binding.root
    }

    private fun initListener() {
        binding.textViewNombre.text = param1
        binding.textViewPrecio.text = "$$param2"
        binding.imageZapatilla.load(param3)

        botonComprar()
        botonVolver()
    }

    private fun botonComprar() {
        binding.buttonComprar.setOnClickListener {
            Toast.makeText(requireContext(), "Añadido al carro", Toast.LENGTH_SHORT).show()
        }
    }

    private fun botonVolver() {
        binding.buttonVolver.setOnClickListener {
            val navController = Navigation.findNavController(requireView())
            navController.navigate(R.id.action_detalleFragment_to_zapatillasFragment)
        }
        }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetalleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetalleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}