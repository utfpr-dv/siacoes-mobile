package br.edu.utfpr.dv.siacoes.mobile.activity

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.adapter.EditThesisAdapter
import br.edu.utfpr.dv.siacoes.mobile.model.Thesis
import com.google.android.material.tabs.TabLayout

class EditThesisActivity : BaseActivity("Monografia de TCC 2",true, true, false, null) {

    private var thesis : Thesis? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_thesis)
        val a = intent.getSerializableExtra("thesis") as Thesis
        thesis = a

        val sectionsPagerAdapter = EditThesisAdapter(a, this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        findViewById<TabLayout>(R.id.tabs).setupWithViewPager(viewPager)
    }

    override fun onBackPressed() {
        setResult(RESULT_CANCELED, null)
        finish()
    }

}