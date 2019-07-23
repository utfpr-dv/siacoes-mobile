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

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://coensapp.dv.utfpr.edu.br/siacoes/service/")
            .client(client)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

    fun loginService(): LoginService = retrofit.create(LoginService::class.java)

    fun applicationService() : ApplicationService = retrofit.create(ApplicationService::class.java)

    fun sigacService() : SigacService = retrofit.create(SigacService::class.java)

    fun sigesService() : SigesService = retrofit.create(SigesService::class.java)

    fun sigetService() : SigetService = retrofit.create(SigetService::class.java)

    fun userService(): UserService = retrofit.create(UserService::class.java)

    fun activityGroupService(): ActivityGroupService = retrofit.create(ActivityGroupService::class.java)

    fun activityService(): ActivityService = retrofit.create(ActivityService::class.java)

    fun activitySubmissionService(): ActivitySubmissionService = retrofit.create(ActivitySubmissionService::class.java)

    fun companyService(): CompanyService = retrofit.create(CompanyService::class.java)

    fun internshipService(): InternshipService = retrofit.create(InternshipService::class.java)

    fun juryService() : JuryService = retrofit.create(JuryService::class.java)

    fun internshipJuryService() : InternshipJuryService = retrofit.create(InternshipJuryService::class.java)

    fun attendanceService() : AttendanceService = retrofit.create(AttendanceService::class.java)

    fun proposalService() : ProposalService = retrofit.create(ProposalService::class.java)

    fun projectService() : ProjectService = retrofit.create(ProjectService::class.java)

    fun thesisService() : ThesisService = retrofit.create(ThesisService::class.java)

    fun finalDocument() : FinalDocumentService = retrofit.create(FinalDocumentService::class.java)

}