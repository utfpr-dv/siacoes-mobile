package br.edu.utfpr.dv.siacoes.mobile

import br.edu.utfpr.dv.siacoes.mobile.client.ApplicationClient
import br.edu.utfpr.dv.siacoes.mobile.client.SigacClient
import br.edu.utfpr.dv.siacoes.mobile.client.SigesClient
import br.edu.utfpr.dv.siacoes.mobile.client.SigetClient
import br.edu.utfpr.dv.siacoes.mobile.model.*
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer

class Session {

    companion object {
        var userInfo : UserInfo? = null
        var profile : User.UserProfile? = null
        var userDepartment : UserDepartment? = null
        var appConfig : AppConfig? = null
        var sigacConfig : SigacConfig? = null
        var sigesConfig : SigesConfig? = null
        var sigetConfig : SigetConfig? = null
    }

    fun setAccessToken(token : String) {
        RetrofitInitializer.requestToken = token
    }

    fun getUserInfo() : UserInfo? {
        return userInfo
    }

    fun setUserInfo(info : UserInfo) {
        userInfo = info

        ApplicationClient().config({
            appConfig = it
        }, {
            //Toast.makeText(this, "Falha ao buscar as notas", Toast.LENGTH_LONG).show()
        })
    }

    fun getProfile() : User.UserProfile? {
        return profile
    }

    fun setProfile(p : User.UserProfile) {
        profile = p
    }

    fun getUserDepartment() : UserDepartment? {
        return userDepartment
    }

    fun setUserDepartment(department: UserDepartment) {
        userDepartment = department

        SigacClient().config(this.getIdDepartment(), {
            sigacConfig = it
        }, {
            //Toast.makeText(this, "Falha ao buscar as notas", Toast.LENGTH_LONG).show()
        })

        SigesClient().config(this.getIdDepartment(), {
            sigesConfig = it
        }, {
            //Toast.makeText(this, "Falha ao buscar as notas", Toast.LENGTH_LONG).show()
        })

        SigetClient().config(this.getIdDepartment(), {
            sigetConfig = it
        }, {
            //Toast.makeText(this, "Falha ao buscar as notas", Toast.LENGTH_LONG).show()
        })
    }

    fun getIdDepartment() : Int {
        return this.getUserDepartment()?.department?.idDepartment!!
    }

    fun getDepartmentName() : String {
        return this.getUserDepartment()?.department?.name!!
    }

    fun getCampusName() : String {
        return this.getUserDepartment()?.department?.campus?.name!!
    }

    fun getProfileName() : String {
        return this.getProfile().toString()
    }

    fun getAppConfig() : AppConfig? {
        return appConfig
    }

    fun getSigacConfig() : SigacConfig? {
        return sigacConfig
    }

    fun getSigesConfig() : SigesConfig? {
        return sigesConfig
    }

    fun getSigetConfig() : SigetConfig? {
        return sigetConfig
    }

}