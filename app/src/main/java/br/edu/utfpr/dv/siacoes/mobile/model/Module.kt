package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class Module : Serializable {

    enum class SystemModule (val value : Int) {
        GENERAL(0),
        SIGET(1),
        SIGAC(2),
        SIGES(3);

        override fun toString(): String {
            return when(this) {
                SIGET -> "TCC"
                SIGAC -> "Atividades Complementares"
                SIGES -> "Estágios"
                else -> return ""
            }
        }
    }

}