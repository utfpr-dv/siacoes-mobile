package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class ActivityUnit : Serializable {

    var idActivityUnit: Int = 0
    var description: String = ""
    var fillAmount: Boolean = false
    var amountDescription: String = ""

    override fun toString(): String {
        return description
    }

}