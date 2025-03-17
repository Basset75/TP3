package ca.ulaval.ima.tp3



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ca.ulaval.ima.tp3.Offre
import ca.ulaval.ima.tp3.R

class OffrePersoAdapter(
    private val offres: List<Offre>,
    private val onClick: (Offre) -> Unit
) : RecyclerView.Adapter<OffrePersoAdapter.OffrePersoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffrePersoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_offre_perso, parent, false)
        return OffrePersoViewHolder(view)
    }

    override fun onBindViewHolder(holder: OffrePersoViewHolder, position: Int) {
        holder.bind(offres[position], onClick)
    }

    override fun getItemCount(): Int = offres.size // Affiche 3 annonces personnelles

    class OffrePersoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textMarque: TextView = itemView.findViewById(R.id.textMarque)
        private val textModele: TextView = itemView.findViewById(R.id.textModele)
        private val textPrix: TextView = itemView.findViewById(R.id.textPrix)

        fun bind(offre: Offre, onClick: (Offre) -> Unit) {
            textMarque.text = offre.marque
            textModele.text = offre.modele
            textPrix.text = "Prix : ${offre.prix} $"

            itemView.setOnClickListener {
                onClick(offre)
            }
        }
    }
}
