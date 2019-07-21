package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class Campus : Serializable {

    var idCampus: Int = 0
    var name: String = ""

    override fun toString(): String {
        return name
    }

}