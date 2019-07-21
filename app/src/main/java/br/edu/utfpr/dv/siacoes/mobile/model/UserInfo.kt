package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class UserInfo : Serializable {

    var name: String = ""
    var login: String = ""
    var email: String = ""
    var phone: String = ""
    var institution: String = ""
    var research: String = ""
    var area: String = ""
    var lattes: String = ""
    var studentCode: String = ""
    var registerSemester: Int = 0
    var registerYear: Int = 0
    var photo: ByteArray? = null
    var external: Boolean = false
    var active: Boolean = false

}