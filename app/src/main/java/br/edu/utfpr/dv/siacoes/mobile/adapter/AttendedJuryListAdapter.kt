package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.model.Jury
import br.edu.utfpr.dv.siacoes.mobile.util.DateUtils

class AttendedJuryListAdapter(private val items: MutableList<Jury>, private val context: Context) : RecyclerView.Adapter<AttendedJuryListAdapter.ViewHolder>() {

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

        fun bindView(item : Jury) {
            itemView.findViewById<TextView>(R.id.item_student).text = "Acadêmico: " + item.student?.name
            itemView.findViewById<TextView>(R.id.item_date).text = "Data/Hora: " + DateUtils().formatDateTime(item.date)
            itemView.findViewById<TextView>(R.id.item_stage).text = "TCC " + item.stage.toString()
        }

    }

}