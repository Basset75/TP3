package ca.ulaval.ima.tp3.ui



import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import ca.ulaval.ima.tp3.Offre
import ca.ulaval.ima.tp3.R



class DescriptionOffrePersoFragment : Fragment() {

    private lateinit var textMarque: TextView
    private lateinit var textModele: TextView
    private lateinit var textAnnee: TextView
    private lateinit var textKilometrage: TextView
    private lateinit var textTransmission: TextView
    private lateinit var textPrix: TextView
    private lateinit var textVendeur: TextView
    private lateinit var textEmailVendeur: TextView
    private lateinit var textPropriete: TextView
    private lateinit var buttonContacter: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_offre_description_perso, container, false)

        // Initialisation des vues
        textMarque = view.findViewById(R.id.textMarque)
        textModele = view.findViewById(R.id.textModele)
        textAnnee = view.findViewById(R.id.textAnnee)
        textKilometrage = view.findViewById(R.id.textKilometrage)
        textTransmission = view.findViewById(R.id.textTransmission)
        textPrix = view.findViewById(R.id.textPrix)
        textVendeur = view.findViewById(R.id.textVendeur)
        textEmailVendeur = view.findViewById(R.id.textEmailVendeur)
        textPropriete = view.findViewById(R.id.textPropriete)
        buttonContacter = view.findViewById(R.id.buttonContacter)

        // Récupération des arguments
        arguments?.let {
            val offre = Offre(
                marque = it.getString("marque", ""),
                modele = it.getString("modele", ""),
                année = it.getInt("annee", 0),
                kilometrage = it.getDouble("kilometrage", 0.0),
                transmission = it.getString("transmission", ""),
                prix = it.getDouble("prix", 0.0),
                vendeur = it.getString("vendeur", ""),
                emailVendeur = it.getString("emailVendeur", ""),
                propriété = it.getString("propriete", "")
            )
            afficherOffre(offre)
        }

        return view
    }

    private fun afficherOffre(offre: Offre) {
        textMarque.text = offre.marque
        textModele.text = offre.modele
        textAnnee.text = "Année : ${offre.année}"
        textKilometrage.text = "Kilométrage : ${offre.kilometrage} km"
        textTransmission.text = "Transmission : ${offre.transmission}"
        textPrix.text = "Prix : ${offre.prix} $"
        textVendeur.text = "Vendeur : ${offre.vendeur}"
        textEmailVendeur.text = "Email : ${offre.emailVendeur}"
        textPropriete.text = "Propriétaire : ${offre.propriété}"

        // Action sur le bouton contacter
        buttonContacter.setOnClickListener {
            envoyerEmail(offre.emailVendeur)
        }
    }

    private fun envoyerEmail(email: String) {
        val intent = android.content.Intent(android.content.Intent.ACTION_SEND).apply {
            type = "message/rfc822"
            putExtra(android.content.Intent.EXTRA_EMAIL, arrayOf(email))
            putExtra(android.content.Intent.EXTRA_SUBJECT, "Intérêt pour votre voiture en vente")
        }
        startActivity(android.content.Intent.createChooser(intent, "Envoyer un e-mail"))
    }

    companion object {
        fun newInstance(offre: Offre): DescriptionOffrePersoFragment {
            return DescriptionOffrePersoFragment().apply {
                arguments = Bundle().apply {
                    putString("marque", offre.marque)
                    putString("modele", offre.modele)
                    putInt("annee", offre.année)
                    putDouble("kilometrage", offre.kilometrage)
                    putString("transmission", offre.transmission)
                    putDouble("prix", offre.prix)
                    putString("vendeur", offre.vendeur)
                    putString("emailVendeur", offre.emailVendeur)
                    putString("propriete", offre.propriété)
                }
            }
        }
    }
}
