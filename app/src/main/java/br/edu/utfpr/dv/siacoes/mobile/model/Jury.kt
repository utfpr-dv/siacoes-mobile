package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
class Jury : Serializable {

    enum class JuryResult (val value : Int) {
        NONE(0),
        APPROVED(1),
        APPROVEDWITHRESERVATIONS(2),
        DISAPPROVED(3);

        override fun toString(): String {
            return when(this) {
                APPROVED -> "Aprovado"
                APPROVEDWITHRESERVATIONS -> "Aprovado com Ressalvas"
                DISAPPROVED -> "Reprovado"
                else -> "Nenhum"
            }
        }
    }

    var idJury: Int = 0
    var date: Date? = null
    var local: String = ""
    var project: Project? = null
    var thesis: Thesis? = null
    var appraisers: List<JuryAppraiser>? = null
    var comments: String = ""
    @JsonFormat(pattern="HH:mm:ss")
    var startTime: Date? = null
    @JsonFormat(pattern="HH:mm:ss")
    var endTime: Date? = null
    var minimumScore: Double = 0.toDouble()
    var supervisorAbsenceReason: String = ""
    var supervisorAssignsGrades: Boolean = false
    var student: User? = null
    var stage: Int = 0

}