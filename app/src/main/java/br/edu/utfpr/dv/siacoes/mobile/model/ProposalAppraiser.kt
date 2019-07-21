package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import br.edu.utfpr.dv.siacoes.mobile.model.ProposalAppraiser.ProposalFeedback



@JsonIgnoreProperties(ignoreUnknown = true)
class ProposalAppraiser : Serializable {

    enum class ProposalFeedback (val value : Int) {
        NONE(0),
        APPROVED(1),
        APPROVEDWITHRESERVATIONS(2),
        DISAPPROVED(3);

        override fun toString(): String {
            return when(this) {
                APPROVED -> "Aprovada"
                APPROVEDWITHRESERVATIONS -> "Aprovada com Ressalvas"
                DISAPPROVED -> "Reprovada"
                else -> "Nenhum"
            }
        }
    }

    var idProposalAppraiser: Int = 0
    var proposal: Proposal? = null
    var appraiser: User? = null
    var feedback: ProposalFeedback? = null
    var comments: String = ""
    var allowEditing: Boolean = false
    var supervisorIndication: Boolean = false

}