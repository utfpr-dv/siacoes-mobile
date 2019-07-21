package br.edu.utfpr.dv.siacoes.mobile.service

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import okhttp3.OkHttpClient

class RetrofitInitializer {

    companion object {
        var requestToken : String = ""
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(ServiceInterceptor())
        .build()

    //var objectMapper = Jackson2ObjectMapperBuilder.json().failOnUnknownProperties(false).build()

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://coensapp.dv.utfpr.edu.br/siacoes/service/")
            .client(client)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

    fun loginService(): LoginService = retrofit.create(LoginService::class.java)

    fun userService(): UserService = retrofit.create(UserService::class.java)

    fun activityGroupService(): ActivityGroupService = retrofit.create(ActivityGroupService::class.java)

    fun activityService(): ActivityService = retrofit.create(ActivityService::class.java)

    fun activitySubmissionService(): ActivitySubmissionService = retrofit.create(ActivitySubmissionService::class.java)

    fun companyService(): CompanyService = retrofit.create(CompanyService::class.java)

    fun internshipService(): InternshipService = retrofit.create(InternshipService::class.java)

}