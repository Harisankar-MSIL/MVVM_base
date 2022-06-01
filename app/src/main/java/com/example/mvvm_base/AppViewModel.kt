package com.example.mvvm_base

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable


class AppViewModel: BaseObservable() {
     val successMessage = "Login successful"
     val errorMessage = "Email or Password is not valid"
        var model = Model("","")

    @Bindable // string variable for
    // toast message
    private var toastMessage: String? = "gghghhg"

    // getter and setter methods
    // for toast message
    fun getToastMessage(): String? {
        return toastMessage
    }

    private fun setToastMessage(toastMessage: String) {
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.toastMessage)
    }

    @Bindable
    fun getUserEmail(): String? {
        return model.userId
    }

    fun setUserEmail(email: String?) {
        email?.let { model.userId =it }
        notifyPropertyChanged(BR.userEmail)
    }

    // getter and setter methods
    // for password variable
    @Bindable
    fun getUserPassword(): String {
        return model.password
    }

    fun setUserPassword(password: String?) {
        password?.let { model.password=it }
        notifyPropertyChanged(BR.userPassword)
    }

    // actions to be performed
    // when user clicks
    // the LOGIN button
    fun onButtonClicked() {
        if (isValid())
            setToastMessage(successMessage)
        else
            setToastMessage(errorMessage)
    }

    // method to keep a check
    // that variable fields must
    // not be kept empty by user
    fun isValid(): Boolean {
        return (!TextUtils.isEmpty(getUserEmail()) && getUserEmail()?.let {
            Patterns.EMAIL_ADDRESS.matcher(it)
                .matches()
        } == true
                && getUserPassword().length > 5)
    }
}