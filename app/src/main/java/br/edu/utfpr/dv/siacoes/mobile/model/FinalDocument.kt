package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import java.util.*


@JsonIgnoreProperties(ignoreUnknown = true)
class FinalDocument : Serializable {

    enum class DocumentFeedback (val value : Int) {
        NONE(0),
        APPROVED(1),
        DISAPPROVED(2);

        override fun toString(): String {
            return when(this) {
                APPROVED -> "Aprovado"
                DISAPPROVED -> "Reprovado"
                else -> "Nenhum"
            }
        }
    }

    var idFinalDocument: Int = 0
    var project: Project? = null
    var thesis: Thesis? = null
    var title: String? = null
    var submissionDate: Date? = null
    var file: ByteArray? = null
    var _private: Boolean = false
    var companyInfo: Boolean = false
    var patent: Boolean = false
    var supervisorFeedbackDate: Date? = null
    var supervisorFeedback: DocumentFeedback = DocumentFeedback.NONE
    var comments: String = ""
    var nativeAbstract: String = ""
    var englishAbstract: String = ""
    var semester: Int = 0
    var year: Int = 0

}