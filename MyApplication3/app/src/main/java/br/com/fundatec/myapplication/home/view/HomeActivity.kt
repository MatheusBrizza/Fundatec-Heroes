package br.com.fundatec.myapplication.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import br.com.fundatec.myapplication.character.data.HeroVillain
import br.com.fundatec.myapplication.character.view.NewCharacterActivity
import br.com.fundatec.myapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configTab()
        configHomeButton()
    }

    private fun configTab() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        binding.vpHome.adapter = adapter
        binding.tlHome.setupWithViewPager(binding.vpHome)
    }

    private fun configHomeButton() {
        binding.btnHome.setOnClickListener {
            startActivity(Intent(this@HomeActivity, NewCharacterActivity::class.java))
        }
    }
}

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return when (position) {
            0 -> "Heroi"
            1 -> "Vilao"
            else -> {
                null
            }
        }
    }

    override fun getItem(position: Int): Fragment {
        Log.e("CharacterDataSource", "posição: " + "${position}")
        val characterType = when (position) {
            0 -> HeroVillain.HERO
            else -> HeroVillain.VILLAIN
        }

        return CharacterFragment.newInstance(characterType)
    }

}