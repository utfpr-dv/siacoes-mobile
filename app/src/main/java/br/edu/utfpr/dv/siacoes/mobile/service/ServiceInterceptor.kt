package br.edu.utfpr.dv.siacoes.mobile.service

import okhttp3.Interceptor
import okhttp3.Response

class ServiceInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        var tries : Int = 0

        do {
            if(request.header("No-Authentication") == null) {
                val token = RetrofitInitializer.requestToken

                if(!token.isNullOrEmpty()) {
                    val finalToken =  "Bearer $token"
                    request = request.newBuilder()
                        .addHeader("Authorization", finalToken)
                        .build()
                }
            }

            val response = chain.proceed(request)

            /*if (response.code() == 401) {
                if(request.header("No-Authentication") == null) {
                    if(tries < 3) {
                        // do login
                        tries++
                    } else {
                        return response
                    }
                } else {
                    return response
                }
            }*/

            return response
        } while (true)
    }

}