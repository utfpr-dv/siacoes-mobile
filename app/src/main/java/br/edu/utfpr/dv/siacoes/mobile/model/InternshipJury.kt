package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
class InternshipJury : Serializable {

    var idInternshipJury: Int = 0
    var date: Date? = null
    var local: String = ""
    var internship: Internship? = null
    var appraisers: List<InternshipJuryAppraiser>? = null
    var comments: String = ""
    @JsonFormat(pattern="HH:mm:ss")
    var startTime: Date? = null
    @JsonFormat(pattern="HH:mm:ss")
    var endTime: Date? = null
    var minimumScore: Double = 0.toDouble()
    var supervisorPonderosity: Double = 0.toDouble()
    var companySupervisorPonderosity: Double = 0.toDouble()
    var companySupervisorScore: Double = 0.toDouble()
    var result: Jury.JuryResult = Jury.JuryResult.NONE
    var supervisorAbsenceReason: String = ""
    var supervisorScore: Double = 0.toDouble()
    var supervisorFillJuryForm: Boolean = false

}