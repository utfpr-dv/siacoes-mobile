package br.edu.utfpr.dv.siacoes.mobile.activity

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.adapter.EditProposalAdapter
import br.edu.utfpr.dv.siacoes.mobile.model.Proposal
import com.google.android.material.tabs.TabLayout

class EditProposalActivity : BaseActivity("Proposta de TCC 1",true, true, false, null) {

    private var proposal : Proposal? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_proposal)
        val a = intent.getSerializableExtra("proposal") as Proposal
        proposal = a

        val sectionsPagerAdapter = EditProposalAdapter(a, this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        findViewById<TabLayout>(R.id.tabs).setupWithViewPager(viewPager)
    }

    override fun onBackPressed() {
        setResult(RESULT_CANCELED, null)
        finish()
    }

}