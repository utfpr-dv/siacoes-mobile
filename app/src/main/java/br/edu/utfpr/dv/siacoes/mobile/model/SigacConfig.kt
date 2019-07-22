package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class SigacConfig : Serializable {

    var department: Department? = null
    var minimumScore: Double = 0.toDouble()
    var maxFileSize: Int = 0

}