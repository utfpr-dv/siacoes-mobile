package br.edu.utfpr.dv.siacoes.mobile.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.adapter.EditActivitySubmissionAdapter
import br.edu.utfpr.dv.siacoes.mobile.model.ActivitySubmission
import com.google.android.material.tabs.TabLayout

class EditActivitySubmissionActivity : BaseActivity("Atividade Submetida",true, true, true, R.menu.fragment_activity_submission_list_bottom_menu) {

    private var activitySubmission : ActivitySubmission? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_activity_submission)
        val a = intent.getSerializableExtra("activitySubmission") as ActivitySubmission
        activitySubmission = a

        val sectionsPagerAdapter = EditActivitySubmissionAdapter(a,this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        findViewById<TabLayout>(R.id.tabs).setupWithViewPager(viewPager)
    }

    override fun onBackPressed() {
        setResult(RESULT_CANCELED, null)
        finish()
    }

    override fun onBottomMenuItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> {
                Toast.makeText(this, "Falha ao buscar as notas", Toast.LENGTH_LONG).show()
            }
        }

        return true
    }

}