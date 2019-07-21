package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
class Proposal : Serializable {

    var idProposal: Int = 0
    var title: String = ""
    var subarea: String = ""
    var student: User? = null
    var supervisor: User? = null
    var cosupervisor: User? = null
    var appraisers: List<ProposalAppraiser>? = null
    var semester: Int = 0
    var year: Int = 0
    var submissionDate: Date? = null
    var department: Department? = null
    var invalidated: Boolean = false
    var supervisorFeedback: ProposalAppraiser.ProposalFeedback = ProposalAppraiser.ProposalFeedback.NONE
    var supervisorFeedbackDate: Date? = null
    var supervisorComments: String = ""
    var file: ByteArray? = null

}