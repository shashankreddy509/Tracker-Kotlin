package com.techdev.tracker_kotlin.ui.auth

import androidx.core.util.PatternsCompat

object RegistrationUtil {

    /**
     * The input is valid if username and password is not empty
     * password length is greater than 6 chars
     */
    fun validateRegistrationInput(
        userName: String,
        password: String
    ): Boolean {
        if(!PatternsCompat.EMAIL_ADDRESS.matcher(userName).matches()) return false
        if (password.length < 6) return false
        return userName.isNotEmpty() && password.isNotEmpty()
    }
}
