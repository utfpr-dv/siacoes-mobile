package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import br.edu.utfpr.dv.siacoes.mobile.model.AppConfig.AppTheme



@JsonIgnoreProperties(ignoreUnknown = true)
class AppConfig : Serializable {

    enum class AppTheme (val value : Int) {
        DEFAULT(0),
        FACEBOOK(1),
        FLAT(2),
        LIGHT(3),
        METRO(4),
        PINK(5);

        override fun toString(): String {
            return when(this) {
                FACEBOOK -> "Facebook"
                FLAT -> "Flat"
                LIGHT -> "Light"
                METRO -> "Metro"
                PINK -> "Pink"
                else -> "Default"
            }
        }
    }

    var theme: AppTheme = AppTheme.DEFAULT
    var host: String = ""
    var sigacEnabled: Boolean = false
    var sigesEnabled: Boolean = false
    var sigetEnabled: Boolean = false
    var mobileEnabled: Boolean = false

}