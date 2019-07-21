package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.model.Internship
import br.edu.utfpr.dv.siacoes.mobile.util.DateUtils

class InternshipListAdapter(private val items: MutableList<Internship>, private val context: Context, private var onItemClickListener: (internship: Internship, index: Int) -> Unit?) : RecyclerView.Adapter<InternshipListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.let {
            it.bindView(items[position])
            it.itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    onItemClickListener(items[position], position)
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.internship_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item : Internship) {
            itemView.findViewById<TextView>(R.id.item_company).text = "Empresa: " + item.company?.name
            itemView.findViewById<TextView>(R.id.item_type).text = "Tipo: " + item.type.toString()
            itemView.findViewById<TextView>(R.id.item_start_date).text = "Data de Início: " + DateUtils().formatDate(item.startDate)
            itemView.findViewById<TextView>(R.id.item_status).text = "Situação: " + item.status.toString()
            itemView.findViewById<TextView>(R.id.item_total_hours).text = "Qtde. Horas: " + item.totalHours.toString()
        }

    }

}