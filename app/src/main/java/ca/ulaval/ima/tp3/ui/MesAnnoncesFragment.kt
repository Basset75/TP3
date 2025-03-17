package ca.ulaval.ima.tp3

import OffresAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.ulaval.ima.tp3.ui.DescriptionOffreFragment
import ca.ulaval.ima.tp3.ui.DescriptionOffrePersoFragment


class MesAnnoncesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: OffresAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_mes_annonces, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewMesAnnonces)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Chargement des annonces personnelles (exemple statique, remplacer par une vraie source)
        val mesAnnonces = listOf(
            Offre("Toyota", "Corolla", 2020, 30000.0, "Automatique", 22000.0, "Jean Dupont", "jean.dupont@email.com", "Particulier"),
            Offre("Honda", "Civic", 2018, 45000.0, "Manuelle", 18000.0, "Sophie Tremblay", "sophie.t@email.com", "Particulier"),
            Offre("Ford", "Focus", 2019, 40000.0, "Automatique", 19500.0, "Michel Lefebvre", "michel.l@email.com", "Particulier")
        )


        adapter = OffresAdapter(mesAnnonces) { offre ->
            ouvrirDescription(offre)
        }
        recyclerView.adapter = adapter

        return view
    }

    private fun ouvrirDescription(offre: Offre) {
        val fragment = DescriptionOffrePersoFragment.newInstance(offre)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .remove(this)
            .addToBackStack(null)
            .commit()
    }
}




