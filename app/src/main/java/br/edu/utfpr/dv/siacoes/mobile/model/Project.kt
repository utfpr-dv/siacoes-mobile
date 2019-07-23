package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
class Project : Serializable {

    var idProject: Int = 0
    var proposal: Proposal? = null
    var title: String = ""
    var subarea: String = ""
    var student: User? = null
    var supervisor: User? = null
    var cosupervisor: User? = null
    var semester: Int = 0
    var year: Int = 0
    var submissionDate: Date? = null
    var abstract: String = ""
    var file: ByteArray? = null

}