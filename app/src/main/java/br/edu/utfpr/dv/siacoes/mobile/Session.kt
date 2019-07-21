package br.edu.utfpr.dv.siacoes.mobile

import br.edu.utfpr.dv.siacoes.mobile.model.User
import br.edu.utfpr.dv.siacoes.mobile.model.UserDepartment
import br.edu.utfpr.dv.siacoes.mobile.model.UserInfo
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer

class Session {

    companion object {
        var userInfo : UserInfo? = null
        var profile : User.UserProfile? = null
        var userDepartment : UserDepartment? = null
    }

    fun setAccessToken(token : String) {
        RetrofitInitializer.requestToken = token
    }

    fun getUserInfo() : UserInfo? {
        return userInfo
    }

    fun setUserInfo(info : UserInfo) {
        userInfo = info
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
    }

    fun getIdDepartment() : Int {
        return this.getUserDepartment()?.department?.idDepartment!!
    }

    fun getDepartmentName() : String {
        return this.getUserDepartment()?.department?.name!!
    }

    fun getProfileName() : String {
        return this.getProfile().toString()
    }

}