package ca.ulaval.ima.tp3


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ca.ulaval.ima.tp3.R

class MarquesAdapter(
    private val marques: List<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<MarquesAdapter.MarqueViewHolder>() {

    inner class MarqueViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val marqueTextView: TextView = view.findViewById(R.id.textViewMarque)

        init {
            view.setOnClickListener {
                val marques = marques[adapterPosition]
                Log.d("DEBUG", "Marque cliqué: $marques") // Vérifie si le clic est bien pris en compte
                onItemClick(marques)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarqueViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_marque, parent, false)
        return MarqueViewHolder(view)
    }

    override fun onBindViewHolder(holder: MarqueViewHolder, position: Int) {
        holder.marqueTextView.text = marques[position]
    }

    override fun getItemCount() = marques.size
}
