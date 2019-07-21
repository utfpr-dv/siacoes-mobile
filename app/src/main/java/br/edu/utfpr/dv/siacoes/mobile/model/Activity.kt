package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class Activity : Serializable {

    var idActivity: Int = 0
    var group: ActivityGroup? = null
    var unit: ActivityUnit? = null
    var department: Department? = null
    var description: String = ""
    var score: Double = 0.toDouble()
    var maximumInSemester: Double = 0.toDouble()
    var active: Boolean = false

    override fun toString(): String {
        return description
    }

}