package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
class ActivitySubmission : Serializable {

    enum class ActivityFeedback (val value : Int) {
        NONE(0),
        APPROVED(1),
        DISAPPROVED(2);

        override fun toString(): String {
            return when(this) {
                APPROVED -> "Aprovada"
                DISAPPROVED -> "Reprovada"
                else -> "Nenhum"
            }
        }
    }

    var idActivitySubmission: Int = 0
    var student: User? = null
    var feedbackUser: User? = null
    var department: Department? = null
    var activity: Activity? = null
    var semester: Int = 0
    var year: Int = 0
    var submissionDate: Date? = null
    var file: ByteArray? = null
    var amount: Double = 0.toDouble()
    var feedback: ActivityFeedback = ActivityFeedback.NONE
    var feedbackDate: Date? = null
    var validatedAmount: Double = 0.toDouble()
    var comments: String = ""
    var description: String = ""
    var stage: Int = 0
    var feedbackReason: String = ""

    override fun toString(): String {
        return description
    }

}