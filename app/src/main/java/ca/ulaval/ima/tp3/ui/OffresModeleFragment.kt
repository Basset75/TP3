package ca.ulaval.ima.tp3.ui

import OffresAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.ulaval.ima.tp3.Offre
//import ca.ulaval.ima.tp3.OffresAdapter
import ca.ulaval.ima.tp3.R
import ca.ulaval.ima.tp3.OffreLoader


class OffresModeleFragment : Fragment() {

    private var marque: String? = null
    private var modele: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            marque = it.getString(ARG_MARQUE)
            modele = it.getString(ARG_MODELE)
            println("DEBUG: OffresModeleFragment lancé avec -> Marque: $marque, Modèle: $modele")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_offres_modele, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewOffres)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val offres = getOffresForModele(marque, modele)

        Log.d(TAG, "Affichage des offres : ${offres.size} offres trouvées")

        recyclerView.adapter = OffresAdapter(offres) { selectedOffre ->
            val fragment = DescriptionOffreFragment.newInstance(selectedOffre)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    private fun getOffresForModele(marque: String?, modele: String?): List<Offre> {
        return try {
            val offres = OffreLoader.chargerOffres(requireContext())

            Log.d(TAG, "Nombre total d'offres chargées: ${offres.size}")

            if (marque.isNullOrBlank() || modele.isNullOrBlank()) {
                Log.w(TAG, "Marque ou modèle non spécifié, retour de la liste vide.")
                return emptyList()
            }

            val result = offres.filter { it.marque.equals(marque, ignoreCase = true) && it.modele.equals(modele, ignoreCase = true) }

            Log.d(TAG, "Offres filtrées: ${result.size}")

            result
        } catch (e: Exception) {
            Log.e(TAG, "Erreur lors du chargement des offres: ${e.message}", e)
            emptyList()
        }
    }

    companion object {
        private const val ARG_MARQUE = "marque"
        private const val ARG_MODELE = "modele"
        private const val TAG = "OffresModeleFragment"

        fun newInstance(marque: String, modele: String) =
            OffresModeleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_MARQUE, marque)
                    putString(ARG_MODELE, modele)
                }
            }
    }
}

//package ca.ulaval.ima.tp3.ui
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import ca.ulaval.ima.tp3.Offre
//
//import ca.ulaval.ima.tp3.R
//
//
//class OffresModeleFragment : Fragment() {
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var offresAdapter: OffresAdapter
//    private var modeleSelectionne: String? = null
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val view = inflater.inflate(R.layout.fragment_offres_modele, container, false)
//
//        recyclerView = view.findViewById(R.id.recyclerViewOffres)
//        recyclerView.layoutManager = LinearLayoutManager(context)
//
//        modeleSelectionne = arguments?.getString("modele")
//
//        modeleSelectionne?.let {
//            val offres = OffresData.getOffresByModele(it)
//            offresAdapter = OffresAdapter(offres) { offre ->
//                ouvrirDescriptionOffre(offre)
//            }
//            recyclerView.adapter = offresAdapter
//        }
//
//        return view
//    }
//
//    private fun ouvrirDescriptionOffre(offre: Offre) {
//        val fragment = DescriptionOffreFragment.newInstance(offre)
//        requireActivity().supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, fragment)
//            .addToBackStack(null)
//            .commit()
//    }
//
//    companion object {
//        fun newInstance(marque: String, modele: String): OffresModeleFragment {
//            return OffresModeleFragment().apply {
//                arguments = Bundle().apply {
//                    putString("marque", marque)
//                    putString("modele", modele)
//                }
//            }
//        }
//    }
//}
