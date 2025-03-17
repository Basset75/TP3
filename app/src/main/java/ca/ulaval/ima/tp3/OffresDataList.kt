

import ca.ulaval.ima.tp3.Offre


object OffresData {
    val offres = listOf(
        Offre("Toyota", "Corolla", 2020, 45000.0, "Automatique", 18500.0, "Jean Tremblay", "jean.tremblay@email.com", "Oui"),
        Offre("Toyota", "RAV4", 2021, 30000.0, "Manuelle", 32000.0, "Marie Dubois", "marie.dubois@email.com", "Non"),
        Offre("Honda", "Civic", 2019, 55000.0, "Automatique", 17000.0, "Lucas Lefebvre", "lucas.lefebvre@email.com", "Oui"),
        Offre("Honda", "Accord", 2022, 20000.0, "Automatique", 35000.0, "Isabelle Martin", "isabelle.martin@email.com", "Oui"),
        Offre("Honda", "CR-V", 2020, 60000.0, "Automatique", 29000.0, "David Gagnon", "david.gagnon@email.com", "Non"),
        Offre("BMW", "X5", 2018, 80000.0, "Automatique", 45000.0, "Philippe Lavoie", "philippe.lavoie@email.com", "Oui"),
        Offre("BMW", "Serie 3", 2021, 25000.0, "Manuelle", 40000.0, "Camille Bouchard", "camille.bouchard@email.com", "Oui"),
        Offre("Mercedes", "Classe A", 2020, 35000.0, "Automatique", 38000.0, "Sophie Morin", "sophie.morin@email.com", "Non"),
        Offre("Mercedes", "Classe C", 2019, 70000.0, "Automatique", 42000.0, "Olivier Roy", "olivier.roy@email.com", "Oui"),
        Offre("Ford", "Focus", 2017, 90000.0, "Manuelle", 12000.0, "Nathalie Desjardins", "nathalie.desjardins@email.com", "Non"),
        Offre("Ford", "F-150", 2021, 40000.0, "Automatique", 48000.0, "Michel Simard", "michel.simard@email.com", "Oui"),
    )

    fun getOffresByModele(modele: String): List<Offre> {
        return offres.filter { it.modele == modele }
    }
}
