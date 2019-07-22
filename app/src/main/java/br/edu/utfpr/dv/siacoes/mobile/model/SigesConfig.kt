package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class SigesConfig : Serializable {

    var department: Department? = null
    var minimumScore: Double = 0.toDouble()
    var supervisorPonderosity: Double = 0.toDouble()
    var companySupervisorPonderosity: Double = 0.toDouble()
    var showGradesToStudent: Boolean = false
    //var supervisorFilter: SupervisorFilter? = null
    var supervisorFillJuryForm: Boolean = false
    var maxFileSize: Int = 0
    var juryTime: Int = 0

}