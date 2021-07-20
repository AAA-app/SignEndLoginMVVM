package com.aaa.signendloginmvvm.ui.auth
import android.util.Log
import androidx.lifecycle.ViewModel
import com.aaa.signendloginmvvm.data.repositories.UserRepository

class AuthViewModel: ViewModel() {
    private  val TAG = "AuthViewModel"

    var email: String? = null
    var password: String? = null

     var authListener: AuthListener? = null

     fun onLoginButtonClick() {
         Log.e(TAG, "onLoginButtonClick: ******************click**********************" )
         authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }
        //success
         val loginResponse = UserRepository().userLogin(email!!, password!!)
         authListener?.onSuccess(loginResponse)


    }
}