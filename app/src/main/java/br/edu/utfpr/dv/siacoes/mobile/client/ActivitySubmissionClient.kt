package br.edu.utfpr.dv.siacoes.mobile.client

import br.edu.utfpr.dv.siacoes.mobile.model.ActivitySubmission
import br.edu.utfpr.dv.siacoes.mobile.model.ActivitySubmissionSummary
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer
import br.edu.utfpr.dv.siacoes.mobile.util.callback

class ActivitySubmissionClient {

    fun summary(idDepartment: Int, success: (List<ActivitySubmissionSummary>) -> Unit,
                failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().activitySubmissionService().summary(idDepartment)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

    fun list(idDepartment: Int, feedback : Int, success: (List<ActivitySubmission>) -> Unit,
             failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().activitySubmissionService().list(idDepartment, feedback)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

    fun getTotalScore(items : List<ActivitySubmissionSummary>) : Double {
        var total : Double = 0.toDouble()

        for(item in items) {
            total += item.total
        }

        return total
    }

    fun getSituation(items : List<ActivitySubmissionSummary>, minimumScore : Int) : String {
        for(item in items) {
            if(item.total < item.minimum) {
                return "Pontuação insuficiente no Grupo " + item.sequence
            }
        }

        if(this.getTotalScore(items) >= minimumScore) {
            return "Pontuação atingida"
        } else {
            return "Pontuação insuficiente"
        }
    }

}