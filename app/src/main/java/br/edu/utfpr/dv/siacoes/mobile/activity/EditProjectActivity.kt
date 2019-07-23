package br.edu.utfpr.dv.siacoes.mobile.activity

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.adapter.EditProjectAdapter
import br.edu.utfpr.dv.siacoes.mobile.model.Project
import com.google.android.material.tabs.TabLayout

class EditProjectActivity : BaseActivity("Projecto de TCC 1",true, true, false, null) {

    private var project : Project? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_project)
        val a = intent.getSerializableExtra("project") as Project
        project = a

        val sectionsPagerAdapter = EditProjectAdapter(a, this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        findViewById<TabLayout>(R.id.tabs).setupWithViewPager(viewPager)
    }

    override fun onBackPressed() {
        setResult(RESULT_CANCELED, null)
        finish()
    }

}