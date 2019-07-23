package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.model.ProposalAppraiser

class ProposalAppraiserListAdapter(private val items: MutableList<ProposalAppraiser>, private val context: Context, private var onItemClickListener: (appraiser: ProposalAppraiser, index: Int) -> Unit?) : RecyclerView.Adapter<ProposalAppraiserListAdapter.ViewHolder>() {

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
        val view = LayoutInflater.from(context).inflate(R.layout.proposal_appraiser_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item : ProposalAppraiser) {
            itemView.findViewById<TextView>(R.id.item_appraiser).text = "Avaliador: " + item.appraiser?.name
            itemView.findViewById<TextView>(R.id.item_feedback).text = "Parecer: " + item.feedback.toString()
        }

    }

}