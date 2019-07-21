package br.edu.utfpr.dv.siacoes.mobile.service

import br.edu.utfpr.dv.siacoes.mobile.model.User
import br.edu.utfpr.dv.siacoes.mobile.model.UserDepartment
import br.edu.utfpr.dv.siacoes.mobile.model.UserInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {

    @GET("user/profile")
    fun profile() : Call<UserInfo>

    @POST("user/profile/update")
    fun updateProfile(@Body userInfo: UserInfo) : Call<String>

    @GET("user/list/profiles")
    fun listProfiles() : Call<List<User.UserProfile>>

    @GET("user/list/departments/{profile}")
    fun listDepartments(@Path("profile") profile: Int) : Call<List<UserDepartment>>

    @GET("user/list/companysupervisors")
    fun listCompanySupervisors() : Call<List<User>>

    @GET("user/list/companysupervisors/{idcompany}")
    fun listCompanySupervisors(@Path("idcompany") idCompany: Int) : Call<List<User>>

    @GET("user/list/supervisors/{iddepartment}/{module}")
    fun listSupervisors(@Path("iddepartment") idDepartment: Int, @Path("module") module: Int) : Call<List<User>>

}