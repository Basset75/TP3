package ca.ulaval.ima.tp3


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ca.ulaval.ima.tp3.R


class ModelesAdapter(
    private val modeles: List<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<ModelesAdapter.ModeleViewHolder>() {

    inner class ModeleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val modeleTextView: TextView = view.findViewById(R.id.textViewModele)

        init {
            Log.d("DEBUG", "ViewHolder créé pour position $absoluteAdapterPosition") // ✅ Ajout du log

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModeleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_modele, parent, false)
        return ModeleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModeleViewHolder, position: Int) {
        val modele = modeles[position]
        holder.modeleTextView.text = modele
        Log.d("DEBUG", "onBindViewHolder position: $position, modèle: $modele")

        // Assigne le listener ici, au bon moment
        holder.modeleTextView.setOnClickListener {
            Log.d("DEBUG", "🔥 Clic détecté sur le TextView : $modele")
            onItemClick(modele)
        }
    }
    override fun getItemCount() = modeles.size
}



//class ModelesAdapter(
//    private val modeles: List<String>,
//    private val marque: String,
//    private val onItemClick: (String) -> Unit
//) : RecyclerView.Adapter<ModelesAdapter.ModeleViewHolder>() {
//
//    inner class ModeleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val textView: TextView = view.findViewById(R.id.textModele)
//
//        init {
//            view.setOnClickListener {
//                val position = bindingAdapterPosition
//                if (position != RecyclerView.NO_POSITION) {
//                    onItemClick(modeles[position])
//                }
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModeleViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_modele, parent, false)
//        return ModeleViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ModeleViewHolder, position: Int) {
//        holder.textView.text = modeles[position]
//    }
//
//    override fun getItemCount() = modeles.size
//}
