package br.edu.utfpr.dv.siacoes.mobile.util

import java.text.SimpleDateFormat
import java.util.*

class DateUtils {

    fun formatDate(date : Date?) : String {
        if(date == null) {
            return ""
        } else {
            return SimpleDateFormat("dd/MM/yyyy").format(date)
        }
    }

}