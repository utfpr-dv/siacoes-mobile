package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class SigetConfig : Serializable {

    var department: Department? = null
    var minimumScore: Double = 0.toDouble()
    var registerProposal: Boolean = false
    var showGradesToStudent: Boolean = false
    //var supervisorFilter: SupervisorFilter? = null
    //var cosupervisorFilter: SupervisorFilter? = null
    var supervisorIndication: Int = 0
    var maxTutoredStage1: Int = 0
    var maxTutoredStage2: Int = 0
    var requestFinalDocumentStage1: Boolean = false
    var repositoryLink: String? = null
    var supervisorJuryRequest: Boolean = false
    var supervisorAgreement: Boolean = false
    var supervisorJuryAgreement: Boolean = false
    var validateAttendances: Boolean = false
    //var attendanceFrequency: AttendanceFrequency? = null
    var maxFileSize: Int = 0
    var minimumJuryMembers: Int = 0
    var minimumJurySubstitutes: Int = 0
    var juryTimeStage1: Int = 0
    var juryTimeStage2: Int = 0
    var supervisorAssignsGrades: Boolean = false

}