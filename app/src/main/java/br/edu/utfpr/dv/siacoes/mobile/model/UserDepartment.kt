package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class UserDepartment : Serializable {

    var idUserDepartment: Int = 0
    var user: User? = null
    var department: Department? = null
    var profile: User.UserProfile? = null
    var sigacManager: Boolean = false
    var sigesManager: Boolean = false
    var sigetManager: Boolean = false
    var departmentManager: Boolean = false
    var registerSemester: Int = 0
    var registerYear: Int = 0

}