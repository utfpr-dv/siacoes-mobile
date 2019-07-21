package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class Company : Serializable {

    var idCompany: Int = 0
    //var city: City? = null
    var name: String = ""
    var cnpj: String = ""
    var phone: String = ""
    var email: String = ""
    var agreement: String = ""

    override fun toString(): String {
        return name
    }

}