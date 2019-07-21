package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.model.ActivitySubmissionSummary
import kotlin.math.roundToInt

class ActivitySubmissionSummaryAdapter(private val listSummary: List<ActivitySubmissionSummary>, private val context: Context) : RecyclerView.Adapter<ActivitySubmissionSummaryAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(listSummary[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_submission_summary_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSummary.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(summary : ActivitySubmissionSummary) {
            itemView.findViewById<TextView>(R.id.summary_item_title).text = "Grupo " + summary.sequence
            itemView.findViewById<TextView>(R.id.summary_item_group).text = summary.group?.replace("Grupo " + summary.sequence + " - ", "")

            val progressBar = itemView.findViewById<ProgressBar>(R.id.progressBar)

            progressBar.max = summary.maximum * 10
            progressBar.progress = (summary.total * 10).roundToInt()

            if(summary.total >= summary.minimum) {
                progressBar.progressTintList = ColorStateList.valueOf(Color.GREEN)
                itemView.findViewById<TextView>(R.id.summary_item_situation).text = summary.situation
            } else {
                progressBar.progressTintList = ColorStateList.valueOf(Color.RED)

                if((summary.maximum - summary.total) >= 2) {
                    itemView.findViewById<TextView>(R.id.summary_item_situation).text = "Faltam " + (summary.maximum - summary.total) + " pontos"
                } else {
                    itemView.findViewById<TextView>(R.id.summary_item_situation).text = "Falta " + (summary.maximum - summary.total) + " ponto"
                }
            }
        }

    }

}