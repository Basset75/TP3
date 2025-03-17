package ca.ulaval.ima.tp3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.ulaval.ima.tp3.MarquesAdapter
import ca.ulaval.ima.tp3.R

class MarquesFragment : Fragment() {

    private val marques = listOf("Toyota", "Honda", "BMW", "Mercedes", "Ford")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_marques, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewMarques)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MarquesAdapter(marques) { selectedMarque ->
            val fragment = ModelesFragment.newInstance(selectedMarque)

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)  // ✅ Remplace MarquesFragment
                .remove(this) // 🔥 Supprime l'instance actuelle de MarquesFragment
                .addToBackStack(null) // ✅ Permet de revenir en arrière
                .commit()
        }
    }

}

//class MarquesFragment : Fragment() {
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewMarques)
//        recyclerView.layoutManager = LinearLayoutManager(context)
//
//        val marques = listOf("Toyota", "Honda", "BMW", "Mercedes" , "Ford") // Remplacez par votre liste
//        recyclerView.adapter = MarquesAdapter(marques) { selectedMarque ->
//            val fragment = ModelesFragment.newInstance(selectedMarque)
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, fragment)
//                .addToBackStack(null)
//                .commit()
//        }
//    }
//}
