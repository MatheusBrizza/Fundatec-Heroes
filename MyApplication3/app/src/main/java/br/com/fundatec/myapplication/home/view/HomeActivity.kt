package br.com.fundatec.myapplication.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import br.com.fundatec.myapplication.databinding.ActivityHomeBinding
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        configActionBar()
    /*    val image = findViewById<ImageView>(R.id.iv_home)

        //pode usar ou Glide ou Picasso
        Glide
            .with(this)
            .load("url")
            .into(image)

        Picasso
            .get()
            .load("url")
            .into(image)
    */}

    private fun configTab() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
    }

    private fun configActionBar(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        binding.vpHome.adapter = adapter
        binding.tlHome.setupWithViewPager(binding.vpHome)    }
}

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Fragment {
        return CharacterFragment.newInstance(position.inc().toString())
    }

}