package com.techdev.tracker_kotlin.domain

import com.techdev.tracker_kotlin.domain.model.LoggedInUser
import com.techdev.tracker_kotlin.domain.model.Result

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

interface LoginRepository {

    var user: LoggedInUser

    val isLoggedIn: Boolean

    fun logout()

    suspend fun login(username: String, password: String): Result<LoggedInUser>

//    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
//        this.user = loggedInUser
//        // If user credentials will be cached in local storage, it is recommended it be encrypted
//        // @see https://developer.android.com/training/articles/keystore
//    }
}
