package br.edu.utfpr.dv.siacoes.mobile.activity

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.adapter.EditFinalDocumentAdapter
import br.edu.utfpr.dv.siacoes.mobile.model.FinalDocument
import com.google.android.material.tabs.TabLayout

class EditFinalDocumentActivity : BaseActivity("Versão Final de TCC",true, true, false, null) {

    private var finalDocument : FinalDocument? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_final_document)
        val a = intent.getSerializableExtra("finalDocument") as FinalDocument
        finalDocument = a

        val sectionsPagerAdapter = EditFinalDocumentAdapter(a, this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        findViewById<TabLayout>(R.id.tabs).setupWithViewPager(viewPager)
    }

    override fun onBackPressed() {
        setResult(RESULT_CANCELED, null)
        finish()
    }

}