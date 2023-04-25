package com.techdev.tracker_kotlin.data

import com.google.firebase.auth.FirebaseAuth
import com.techdev.tracker_kotlin.domain.LoginRepository
import com.techdev.tracker_kotlin.domain.model.LoggedInUser
import com.techdev.tracker_kotlin.domain.model.Result
import com.techdev.tracker_kotlin.utils.AppConstants.NO_VALUE
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

class LoginRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : LoginRepository {

    override var user = LoggedInUser(
        userId = auth.currentUser?.uid ?: NO_VALUE,
        displayName = auth.currentUser?.displayName ?: NO_VALUE,
        email = auth.currentUser?.email ?: NO_VALUE
    )
    override val isLoggedIn: Boolean = auth.currentUser != null

    override fun logout() {
        auth.signOut()
    }

    override suspend fun login(username: String, password: String): Result<LoggedInUser> {
        return try {
            val result = auth.signInWithEmailAndPassword(username, password)
                .await()
            val user = result.user!!
            Result.Success(
                LoggedInUser(
                    user.uid,
                    user.displayName ?: NO_VALUE,
                    user.email ?: NO_VALUE
                )
            )
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
