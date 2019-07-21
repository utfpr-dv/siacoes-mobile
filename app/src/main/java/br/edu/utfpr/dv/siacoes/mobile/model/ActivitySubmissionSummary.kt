package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class ActivitySubmissionSummary : Serializable {

    var idActivityGroup: Int = 0
    var group: String? = ""
    var total: Double = 0.toDouble()
    var minimum: Int = 0
    var maximum: Int = 0
    var situation: String? = ""
    var sequence: Int = 0

}