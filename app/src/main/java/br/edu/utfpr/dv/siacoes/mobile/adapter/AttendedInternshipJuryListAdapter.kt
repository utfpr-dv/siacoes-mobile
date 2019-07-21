package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.model.InternshipJury
import br.edu.utfpr.dv.siacoes.mobile.util.DateUtils

class AttendedInternshipJuryListAdapter(private val items: MutableList<InternshipJury>, private val context: Context) : RecyclerView.Adapter<AttendedInternshipJuryListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.let {
            it.bindView(items[position])
            /*it.itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    onItemClickListener(items[position], position)
                }
            })*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.attended_jury_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item : InternshipJury) {
            itemView.findViewById<TextView>(R.id.item_student).text = "Acadêmico: " + item.internship?.student?.name
            itemView.findViewById<TextView>(R.id.item_date).text = "Data/Hora: " + DateUtils().formatDateTime(item.date)
        }

    }

}