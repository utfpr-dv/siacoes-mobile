package br.edu.utfpr.dv.siacoes.mobile.activity

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.adapter.EditInternshipAdapter
import br.edu.utfpr.dv.siacoes.mobile.model.Internship
import com.google.android.material.tabs.TabLayout

class EditInternshipActivity : BaseActivity("Registro de Estágio",true, true, false, null) {

    private var internship : Internship? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_internship)
        val a = intent.getSerializableExtra("internship") as Internship
        internship = a

        val sectionsPagerAdapter = EditInternshipAdapter(a,this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        findViewById<TabLayout>(R.id.tabs).setupWithViewPager(viewPager)
    }

    override fun onBackPressed() {
        setResult(RESULT_CANCELED, null)
        finish()
    }

}
