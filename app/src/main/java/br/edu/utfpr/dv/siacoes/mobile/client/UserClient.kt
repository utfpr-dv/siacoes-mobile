package br.edu.utfpr.dv.siacoes.mobile.client

import br.edu.utfpr.dv.siacoes.mobile.model.User
import br.edu.utfpr.dv.siacoes.mobile.model.UserDepartment
import br.edu.utfpr.dv.siacoes.mobile.model.UserInfo
import br.edu.utfpr.dv.siacoes.mobile.service.RetrofitInitializer
import br.edu.utfpr.dv.siacoes.mobile.util.callback

class UserClient {

    fun profile(success: (userInfo: UserInfo) -> Unit,
                failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().userService().profile()
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

    fun updateProfile(userInfo: UserInfo, success: (ret: String) -> Unit,
                failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().userService().updateProfile(userInfo)
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

    fun listProfiles(success: (profiles: List<User.UserProfile>) -> Unit,
                      failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().userService().listProfiles()
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

    fun listDepartments(profile: Int, success: (List<UserDepartment>) -> Unit,
                      failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().userService().listDepartments(profile)
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

    fun listCompanySupervisors(success: (List<User>) -> Unit,
                        failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().userService().listCompanySupervisors()
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

    fun listCompanySupervisors(idCompany: Int, success: (List<User>) -> Unit,
                               failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().userService().listCompanySupervisors(idCompany)
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

    fun listSupervisors(idDepartment: Int, module: Int, success: (List<User>) -> Unit,
                               failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().userService().listSupervisors(idDepartment, module)
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