package ca.ulaval.ima.tp3.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.ulaval.ima.tp3.ModelesAdapter
import ca.ulaval.ima.tp3.R

class ModelesFragment : Fragment() {

    private var marque: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            marque = it.getString(ARG_MARQUE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_modeles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Vérification si la marque est bien reçue
        Log.d("ModelesFragment", "Marque reçue: $marque")

        if (marque == null) {
            Log.e("ModelesFragment", "Erreur: marque est null")
            return
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewModeles)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val modeles = getModelesForMarque(marque!!)
        Log.d("DEBUG", "Nombre de modèles récupérés : ${modeles.size}")

        recyclerView.adapter = ModelesAdapter(modeles) { selectedModele ->
            Log.d("DEBUG", "🛑 Redirection vers OffresModeleFragment avec modèle : $selectedModele") // Ajout pour tester
            val fragment = OffresModeleFragment.newInstance(marque!!, selectedModele)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .remove(this)
                .addToBackStack(null)
                .commit()
        }
    }

    private fun getModelesForMarque(marque: String): List<String> {
        return when (marque) {
            "Toyota" -> listOf("Corolla", "RAV4")
            "Honda" -> listOf("Civic", "Accord", "CR-V")
            "BMW" -> listOf("X5", "Serie 3")
            "Mercedes" -> listOf("Classe A", "Classe C")
            "Ford" -> listOf("Focus", "F-150")
            else -> emptyList()
        }
    }

    companion object {
        private const val ARG_MARQUE = "marque"

        fun newInstance(marque: String) =
            ModelesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_MARQUE, marque)
                }
            }
    }
}


