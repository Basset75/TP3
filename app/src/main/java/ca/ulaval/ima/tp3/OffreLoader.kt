package ca.ulaval.ima.tp3

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

object OffreLoader {
    fun chargerOffres(context: Context): List<Offre> {
        val offres = mutableListOf<Offre>()
        try {
            context.resources.openRawResource(R.raw.listeoffres).use { inputStream ->
                BufferedReader(InputStreamReader(inputStream)).use { reader ->
                    reader.forEachLine { line ->
                        val parts = line.split(",").map { it.trim() }
                        if (parts.size == 9) {
                            try {
                                val offre = Offre(
                                    marque = parts[0],
                                    modele = parts[1],
                                    année = parts[2].toIntOrNull() ?: 0,
                                    kilometrage = parts[3].toDoubleOrNull() ?: 0.0,
                                    transmission = parts[4],
                                    prix = parts[5].toDoubleOrNull() ?: 0.0,
                                    vendeur = parts[6],
                                    emailVendeur = parts[7],
                                    propriété = parts[8]
                                )
                                offres.add(offre)
                            } catch (e: NumberFormatException) {
                                // Log l'erreur si nécessaire
                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            // Log l'erreur pour éviter un crash
        }
        return offres
    }
}
