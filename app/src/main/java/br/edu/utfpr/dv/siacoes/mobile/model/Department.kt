package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class Department : Serializable {

    var idDepartment: Int = 0
    var campus: Campus? = null
    var name: String = ""

    override fun toString(): String {
        return name
    }

}