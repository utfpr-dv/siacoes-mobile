package br.edu.utfpr.dv.siacoes.mobile.activity

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.adapter.SigetAdapter
import com.google.android.material.tabs.TabLayout

class SigetActivity : BaseActivity("TCC",false, true, false, null) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_siget)

        val sectionsPagerAdapter = SigetAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        findViewById<TabLayout>(R.id.tabs).setupWithViewPager(viewPager)
    }

}