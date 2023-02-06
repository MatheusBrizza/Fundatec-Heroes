package br.com.fundatec.myapplication.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import br.com.fundatec.myapplication.R
import br.com.fundatec.myapplication.character.view.NewCharacterActivity
import br.com.fundatec.myapplication.databinding.ActivityHomeBinding
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        configTab()
        configHomeButton()
    }
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
    */

    private fun configTab() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        binding.vpHome.adapter = adapter
        binding.tlHome.setupWithViewPager(binding.vpHome)
    }

    private fun configHomeButton() {
        binding.btnHome.setOnClickListener {
            val intent = Intent(this@HomeActivity, NewCharacterActivity::class.java)
            startActivity(intent)
        }




    }
}

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Tab ${position.inc()}"
    }

    override fun getItem(position: Int): Fragment {
        return CharacterFragment.newInstance(position.inc().toString())
    }

}