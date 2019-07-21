package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class ActivityGroup : Serializable {

    var idActivityGroup: Int = 0
    var description: String = ""
    var sequence: Int = 0
    var minimumScore: Int = 0
    var maximumScore: Int = 0

    override fun toString(): String {
        return description
    }

}