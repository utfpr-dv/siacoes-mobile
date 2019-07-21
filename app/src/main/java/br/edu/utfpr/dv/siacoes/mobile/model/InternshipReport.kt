package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import java.util.*


@JsonIgnoreProperties(ignoreUnknown = true)
class InternshipReport : Serializable {

    enum class ReportType (val value : Int) {
        STUDENT(0),
        SUPERVISOR(1),
        COMPANY(2);

        override fun toString(): String {
            when(this) {
                SUPERVISOR -> return "Orientador"
                COMPANY -> return "Supervisor"
                else -> return "Acadêmico"
            }
        }
    }

    var idInternshipReport: Int = 0
    var internship: Internship? = null
    var type: ReportType = ReportType.STUDENT
    var report: ByteArray? = null
    var date: Date? = null

}