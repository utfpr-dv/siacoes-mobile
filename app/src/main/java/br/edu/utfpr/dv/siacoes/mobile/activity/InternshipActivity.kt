package br.edu.utfpr.dv.siacoes.mobile.activity

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.Session
import br.edu.utfpr.dv.siacoes.mobile.adapter.InternshipListAdapter
import br.edu.utfpr.dv.siacoes.mobile.client.InternshipClient
import br.edu.utfpr.dv.siacoes.mobile.model.Internship
import com.google.android.material.snackbar.Snackbar

class InternshipActivity : BaseActivity("Estágios",false, false, false, null) {

    private val internshipList: MutableList<Internship> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internship)

        showLoading()

        InternshipClient().list(Session().getIdDepartment(), {
            internshipList.addAll(it)
            loadItems()
        }, {
            Snackbar.make(findViewById(R.id.internship_list_recyclerview), "Não foi possível carregar a lista de estágios.", Snackbar.LENGTH_LONG).show()
            hideLoading()
        })
    }

    private fun loadItems() {
        val recyclerView = findViewById<RecyclerView>(R.id.internship_list_recyclerview)

        recyclerView?.adapter = InternshipListAdapter(internshipList, this) { internship, index ->
            val intent = Intent(this, EditInternshipActivity::class.java)
            intent.putExtra("internship", internship)
            startActivityForResult(intent, index, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView?.layoutManager = layoutManager

        hideLoading()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK) {
            internshipList[requestCode] = data?.getSerializableExtra("internship") as Internship
            loadItems()
        }
    }

}