package ca.ulaval.ima.tp3.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ca.ulaval.ima.tp3.Offre
import ca.ulaval.ima.tp3.R


class DescriptionOffreFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val marque = it.getString("marque")
            val modele = it.getString("modele")
            val annee = it.getInt("annee")
            val prix = it.getDouble("prix")
            val vendeur = it.getString("vendeur")
            val emailVendeur = it.getString("emailVendeur")
            val propriete = it.getString("propriete")

            Log.d("DescriptionOffreFragment", "Offre sélectionnée : $marque $modele, $annee, $prix €")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description_offre, container, false)
    }

    companion object {
        fun newInstance(offre: Offre) =
            DescriptionOffreFragment().apply {
                arguments = Bundle().apply {
                    putString("marque", offre.marque)
                    putString("modele", offre.modele)
                    putInt("annee", offre.année)
                    putDouble("prix", offre.prix)
                    putString("vendeur", offre.vendeur)
                    putString("emailVendeur", offre.emailVendeur)
                    putString("propriete", offre.propriété)
                }
            }
    }
}