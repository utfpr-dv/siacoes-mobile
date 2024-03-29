package br.edu.utfpr.dv.siacoes.mobile.client

import android.os.Build
import br.edu.utfpr.dv.siacoes.mobile.model.Credential
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer
import br.edu.utfpr.dv.siacoes.mobile.util.callback

class LoginClient {

    fun login(credential: Credential, success: (token: String) -> Unit,
              failure: (throwable: Throwable) -> Unit) {
        credential.device = Build.DEVICE + " " + Build.MODEL + " Android " + Build.VERSION.RELEASE
        val call = RetrofitInitializer().loginService().login(credential)
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