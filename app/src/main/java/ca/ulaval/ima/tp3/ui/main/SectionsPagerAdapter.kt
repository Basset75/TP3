package ca.ulaval.ima.tp3.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ca.ulaval.ima.tp3.MesAnnoncesFragment
import ca.ulaval.ima.tp3.R
import ca.ulaval.ima.tp3.VendreFragment
import ca.ulaval.ima.tp3.ui.MarquesFragment
import ca.ulaval.ima.tp3.ui.OffresFragment


private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
//class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
//    FragmentPagerAdapter(fm) {
//
//    override fun getItem(position: Int): Fragment {
//        // getItem is called to instantiate the fragment for the given page.
//        // Return a PlaceholderFragment.
//        return PlaceholderFragment.newInstance(position + 1)
//    }
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        return context.resources.getString(TAB_TITLES[position])
//    }
//
//    override fun getCount(): Int {
//        // Show 2 total pages.
//        return 2
//    }
//}


class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments = listOf(
        MarquesFragment(), // Page 1 : Liste des marques (Offres)
        VendreFragment(), // Page 2 : Formulaire pour vendre
        MesAnnoncesFragment() // Page 3 : Liste des annonces personnelles
    )

    private val fragmentTitles = listOf("Offres", "Vendre", "Mes Annonces")

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitles[position]
    }
}