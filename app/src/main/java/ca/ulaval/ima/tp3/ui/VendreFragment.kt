package ca.ulaval.ima.tp3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class VendreFragment : Fragment() {

    private lateinit var editTextMarque: EditText
    private lateinit var editTextModele: EditText
    private lateinit var editTextAnnee: EditText
    private lateinit var editTextKm: EditText
    private lateinit var spinnerTransmission: Spinner
    private lateinit var editTextPrix: EditText
    private lateinit var editTextNom: EditText
    private lateinit var editTextCourriel: EditText
    private lateinit var toggleProprietaire: ToggleButton
    private lateinit var buttonEnregistrer: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_vendre, container, false)

        // Initialisation des champs
        editTextMarque = view.findViewById(R.id.editTextMarque)
        editTextModele = view.findViewById(R.id.editTextModele)
        editTextAnnee = view.findViewById(R.id.editTextAnnee)
        editTextKm = view.findViewById(R.id.editTextKm)
        spinnerTransmission = view.findViewById(R.id.spinner)
        editTextPrix = view.findViewById(R.id.editTextPrix)
        editTextNom = view.findViewById(R.id.editTextNom)
        editTextCourriel = view.findViewById(R.id.editTextCourriel)
        toggleProprietaire = view.findViewById(R.id.toggleButton)
        buttonEnregistrer = view.findViewById(R.id.button)

        // Ajouter un listener au bouton d'enregistrement
        buttonEnregistrer.setOnClickListener {
            enregistrerAnnonce()
        }

        return view
    }

    private fun enregistrerAnnonce() {
        val marque = editTextMarque.text.toString().trim()
        val modele = editTextModele.text.toString().trim()
        val annee = editTextAnnee.text.toString().toIntOrNull()
        val km = editTextKm.text.toString().toDoubleOrNull()
        val transmission = spinnerTransmission.selectedItem.toString()
        val prix = editTextPrix.text.toString().toDoubleOrNull()
        val nom = editTextNom.text.toString().trim()
        val courriel = editTextCourriel.text.toString().trim()
        val propriete = if (toggleProprietaire.isChecked) "Oui" else "Non"

        // Validation des champs
        if (marque.isEmpty() || modele.isEmpty() || nom.isEmpty() || courriel.isEmpty()) {
            Toast.makeText(context, "Tous les champs doivent être remplis", Toast.LENGTH_SHORT).show()
            return
        }

        if (annee == null || annee < 1900 || annee > 2025) {
            Toast.makeText(context, "Veuillez entrer une année valide", Toast.LENGTH_SHORT).show()
            return
        }

        if (km == null || km < 0) {
            Toast.makeText(context, "Veuillez entrer un kilométrage valide", Toast.LENGTH_SHORT).show()
            return
        }

        if (prix == null || prix < 0) {
            Toast.makeText(context, "Veuillez entrer un prix valide", Toast.LENGTH_SHORT).show()
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(courriel).matches()) {
            Toast.makeText(context, "Veuillez entrer un courriel valide", Toast.LENGTH_SHORT).show()
            return
        }

        // Création de l'offre
        val nouvelleOffre = Offre(
            marque = marque,
            modele = modele,
            année = annee,
            kilometrage = km,
            transmission = transmission,
            prix = prix,
            vendeur = nom,
            emailVendeur = courriel,
            propriété = propriete
        )

        // Simulation de sauvegarde (remplacer par une base de données ou API si nécessaire)
        Toast.makeText(context, "Annonce enregistrée avec succès!", Toast.LENGTH_SHORT).show()

        // Réinitialisation du formulaire après enregistrement
        resetForm()
    }

    private fun resetForm() {
        editTextMarque.setText("Toyota")
        editTextModele.setText("RAV4")
        editTextAnnee.setText("2021")
        editTextKm.setText("50000")
        spinnerTransmission.setSelection(0)
        editTextPrix.setText("25000")
        editTextNom.setText("Jean Gagnon")
        editTextCourriel.setText("jeangagnon@text.ca")
        toggleProprietaire.isChecked = false
    }
}
