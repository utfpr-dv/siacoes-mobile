package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class Internship : Serializable {

    enum class InternshipStatus (val value : Int) {
        CURRENT(0),
        FINISHED(1);

        override fun toString(): String {
            return when(this) {
                CURRENT -> "Em Andamento"
                FINISHED -> "Finalizado"
                else -> ""
            }
        }
    }

    enum class InternshipType (val value : Int) {
        NONREQUIRED(0),
        REQUIRED(1);

        override fun toString(): String {
            return when(this) {
                REQUIRED -> "Obrigatório"
                else -> "Não Obrigatório"
            }
        }
    }

    var idInternship: Int = 0
    var department: Department? = null
    var company: Company? = null
    var companySupervisor: User? = null
    var supervisor: User? = null
    var student: User? = null
    var type: InternshipType = InternshipType.NONREQUIRED
    var comments: String? = null
    var startDate: Date? = null
    var endDate: Date? = null
    var reportTitle: String = ""
    var totalHours: Int = 0
    var internshipPlan: ByteArray? = null
    var finalReport: ByteArray? = null
    var reports: List<InternshipReport>? = null
    var status: InternshipStatus = InternshipStatus.CURRENT

}