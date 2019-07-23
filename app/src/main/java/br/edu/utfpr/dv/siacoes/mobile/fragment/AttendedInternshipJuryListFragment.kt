package br.edu.utfpr.dv.siacoes.mobile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.activity.BaseActivity
import br.edu.utfpr.dv.siacoes.mobile.adapter.AttendedInternshipJuryListAdapter
import br.edu.utfpr.dv.siacoes.mobile.client.InternshipJuryClient
import br.edu.utfpr.dv.siacoes.mobile.model.InternshipJury
import com.google.android.material.snackbar.Snackbar

class AttendedInternshipJuryListFragment : Fragment() {

    private val internshipJuryList: MutableList<InternshipJury> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_attended_jury_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as BaseActivity).showLoading()

        InternshipJuryClient().listByStudent( {
            internshipJuryList.clear()
            internshipJuryList.addAll(it)
            loadItems()
        }, {
            Snackbar.make(view, "Não foi possível carregar a lista de bancas.", Snackbar.LENGTH_LONG).show()
            (activity as BaseActivity).hideLoading()
        })
    }

    private fun loadItems() {
        val recyclerView = activity?.findViewById<RecyclerView>(R.id.attended_jury_list_recyclerview)

        recyclerView?.adapter = AttendedInternshipJuryListAdapter(internshipJuryList, this.context!!)

        val layoutManager = LinearLayoutManager(this.context!!, RecyclerView.VERTICAL, false)
        recyclerView?.layoutManager = layoutManager

        (activity as BaseActivity).hideLoading()
    }

}