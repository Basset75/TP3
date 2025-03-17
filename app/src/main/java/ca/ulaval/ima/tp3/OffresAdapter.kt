import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ca.ulaval.ima.tp3.Offre
import ca.ulaval.ima.tp3.R

//package ca.ulaval.ima.tp3
//
//
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import ca.ulaval.ima.tp3.R
//import ca.ulaval.ima.tp3.Offre
//import com.squareup.picasso.Picasso
//
//
//
//
//
////
//class OffresAdapter(
//    private val offres: List<Offre>,
//    private val onItemClick: (Offre) -> Unit
//) : RecyclerView.Adapter<OffresAdapter.OffreViewHolder>() {
//
//    class OffreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val marqueModele: TextView = view.findViewById(R.id.textMarqueModele)
//        val prix: TextView = view.findViewById(R.id.textPrix)
//        val annee: TextView = view.findViewById(R.id.textAnnee)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffreViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_offre, parent, false)
//        return OffreViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: OffreViewHolder, position: Int) {
//        val offre = offres[position]
//        holder.marqueModele.text = "${offre.marque} ${offre.modele}"
//        holder.prix.text = "${offre.prix} €"
//        holder.annee.text = "Année: ${offre.année}"
//
//        holder.itemView.setOnClickListener { onItemClick(offre) }
//    }
//
//    override fun getItemCount() = offres.size
//}

class OffresAdapter(
    private val offres: List<Offre>,
    private val onItemClick: (Offre) -> Unit
) : RecyclerView.Adapter<OffresAdapter.OffreViewHolder>() {

    inner class OffreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val marqueModele: TextView = view.findViewById(R.id.textMarqueModele)
        val prix: TextView = view.findViewById(R.id.textPrix)
        val annee: TextView = view.findViewById(R.id.textAnnee)

        init {
            view.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(offres[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_offre, parent, false)
        return OffreViewHolder(view)
    }

    override fun onBindViewHolder(holder: OffreViewHolder, position: Int) {
        val offre = offres[position]
        holder.marqueModele.text = "${offre.marque} ${offre.modele}"
        holder.prix.text = "${offre.prix} €"
        holder.annee.text = "Année: ${offre.année}"
    }

    override fun getItemCount() = offres.size
}
