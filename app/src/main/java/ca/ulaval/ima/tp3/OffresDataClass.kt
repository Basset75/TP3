package ca.ulaval.ima.tp3

data class Offre(
    val marque: String,
    val modele: String,
    val année: Int,
    val kilometrage: Double,
    val transmission: String,
    val prix: Double,
    val vendeur: String,
    val emailVendeur: String,
    val propriété: String,
    //val imageRes: String // URL ou ressource locale
)