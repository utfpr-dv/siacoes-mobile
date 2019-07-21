package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class User : Serializable {

    enum class UserProfile (val value : Int) {
        STUDENT(0),
        PROFESSOR(1),
        ADMINISTRATOR(2),
        MANAGER(3),
        COMPANYSUPERVISOR(4),
        SUPERVISOR(5),
        ADMINISTRATIVE(6);

        override fun toString(): String {
            return when(this) {
                PROFESSOR -> "Professor"
                ADMINISTRATOR -> "Administrador"
                MANAGER -> "Responsável"
                COMPANYSUPERVISOR -> "Supervisor de Estágio"
                SUPERVISOR -> "Orientador"
                ADMINISTRATIVE -> "Técnico Administrativo"
                else -> "Acadêmico"
            }
        }
    }

    var idUser: Int = 0
    var name: String = ""

    override fun toString(): String {
        return name
    }

}