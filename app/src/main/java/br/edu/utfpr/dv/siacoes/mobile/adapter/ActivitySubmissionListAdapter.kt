package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.model.ActivitySubmission
import org.w3c.dom.Text

class ActivitySubmissionListAdapter(private val items: MutableList<ActivitySubmission>, private val context: Context, private var onItemClickListener: (activity: ActivitySubmission, index: Int) -> Unit?) : RecyclerView.Adapter<ActivitySubmissionListAdapter.ViewHolder>() {

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
        val view = LayoutInflater.from(context).inflate(R.layout.activity_submission_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item : ActivitySubmission) {
            itemView.findViewById<TextView>(R.id.item_description).text = item.description
            itemView.findViewById<TextView>(R.id.item_group).text = "Grupo: " + item.activity?.group?.sequence.toString()
            itemView.findViewById<TextView>(R.id.item_semester).text = "Semestre: " + item.semester.toString() + "/" + item.year.toString()
        }

    }

}