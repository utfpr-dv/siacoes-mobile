package br.edu.utfpr.dv.siacoes.mobile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.model.Attendance
import br.edu.utfpr.dv.siacoes.mobile.util.DateUtils

class AttendanceListAdapter(private val items: MutableList<Attendance>, private val context: Context, private var onItemClickListener: (attendance: Attendance, index: Int) -> Unit?) : RecyclerView.Adapter<AttendanceListAdapter.ViewHolder>() {

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
        val view = LayoutInflater.from(context).inflate(R.layout.attendance_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item : Attendance) {
            itemView.findViewById<TextView>(R.id.item_date).text = "Data: " + DateUtils().formatDate(item.date)
            itemView.findViewById<TextView>(R.id.item_stage).text = "TCC " + item.stage.toString()
            itemView.findViewById<TextView>(R.id.item_start).text = "Horário Inicial: " + DateUtils().formatTime(item.startTime)
            itemView.findViewById<TextView>(R.id.item_end).text = "Horário Final: " + DateUtils().formatTime(item.endTime)
        }

    }

}