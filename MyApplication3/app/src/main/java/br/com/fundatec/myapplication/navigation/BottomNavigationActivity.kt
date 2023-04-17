package br.com.fundatec.myapplication.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.fundatec.myapplication.R
import br.com.fundatec.myapplication.databinding.ActivityBottomNavigationBinding

class BottomNavigationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* binding.navigation.setOnItemSelectedListener {
             onNavigationSelected(it)
             true
         }*/

        binding.navigation.selectedItemId = R.id.navigation_home

    }

    /* private fun onNavigationSelected(item: MenuItem) {
         when (item.itemId) {
             R.id.navigation_home -> {
                 openFragment(HomeFragment.newInstance())
             }
             else -> {
                 openFragment(NotificationFragment.newInstance())
             }
         }
     }*/

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}