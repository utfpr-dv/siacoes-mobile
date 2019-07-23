package br.edu.utfpr.dv.siacoes.mobile.util

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <T> callback(response: (response: Response<T>?) -> Unit,
                 failure: (throwable: Throwable?) -> Unit): Callback<T> {
    return object : Callback<T> {
        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            if(response?.isSuccessful!!) {
                response(response)
            } else if(response.code() == 401) {
                failure(Throwable("Você não está autorizado a acessar este recurso.", null))
                /*val intent = Intent(null, LoginActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)*/
            } else if(response.code() == 405) {
                failure(Throwable("A versão mobile do sistema não está habilitada.", null))
            } else {
                failure(Throwable("Erro não identificado.", null))
            }
        }

        override fun onFailure(call: Call<T>?, t: Throwable?) {
            failure(t)
        }
    }
}
