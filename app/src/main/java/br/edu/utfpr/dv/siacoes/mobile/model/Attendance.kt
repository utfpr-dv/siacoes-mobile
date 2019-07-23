package br.edu.utfpr.dv.siacoes.mobile.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
class Attendance : Serializable {

    var idAttendance: Int = 0
    var proposal: Proposal? = null
    var supervisor: User? = null
    var student: User? = null
    var date: Date? = null
    @JsonFormat(pattern="HH:mm:ss")
    var startTime: Date? = null
    @JsonFormat(pattern="HH:mm:ss")
    var endTime: Date? = null
    var comments: String = ""
    var nextMeeting: String = ""
    var stage: Int = 0

}