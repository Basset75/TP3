package ca.ulaval.ima.tp3

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import ca.ulaval.ima.tp3.ui.main.SectionsPagerAdapter
import ca.ulaval.ima.tp3.databinding.ActivityTabbedBinding
import ca.ulaval.ima.tp3.ui.MarquesFragment

import com.google.android.material.tabs.TabLayoutMediator

//class tabbedActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityTabbedBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityTabbedBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
//        val viewPager: ViewPager = binding.viewPager
//        viewPager.adapter = sectionsPagerAdapter
//        val tabs: TabLayout = binding.tabs
//        tabs.setupWithViewPager(viewPager)
//        val fab: FloatingActionButton = binding.fab
//
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null)
//                .setAnchorView(R.id.fab).show()
//        }
//    }
//}

//class tabbedActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityTabbedBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityTabbedBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
//        binding.viewPager.adapter = sectionsPagerAdapter
//
//        // Associe le ViewPager au TabLayout
//        binding.tabs.setupWithViewPager(binding.viewPager)
//
//        // Ajouter les titres manuellement
//        binding.tabs.getTabAt(0)?.text = "Offres"
//        binding.tabs.getTabAt(1)?.text = "Vendre"
//        binding.tabs.getTabAt(2)?.text = "Mes Annonces"
//    }
//}



class tabbedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabbedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabbedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter

        // Associe le ViewPager au TabLayout
        binding.tabs.setupWithViewPager(binding.viewPager)

        // Définition des titres des onglets après l'initialisation du ViewPager
        binding.tabs.getTabAt(0)?.text = "Offres"
        binding.tabs.getTabAt(1)?.text = "Vendre"
        binding.tabs.getTabAt(2)?.text = "Mes Annonces"
    }
}
