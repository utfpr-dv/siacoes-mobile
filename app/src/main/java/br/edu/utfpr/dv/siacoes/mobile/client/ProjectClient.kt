package br.edu.utfpr.dv.siacoes.mobile.client

import br.edu.utfpr.dv.siacoes.mobile.model.Project
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer
import br.edu.utfpr.dv.siacoes.mobile.util.callback

class ProjectClient {

    fun findCurrent(idDepartment: Int, success: (Project) -> Unit,
                    failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().projectService().findCurrent(idDepartment)
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

}