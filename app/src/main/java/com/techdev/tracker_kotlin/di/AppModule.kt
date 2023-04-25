package com.techdev.tracker_kotlin.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.techdev.tracker_kotlin.domain.LoginRepository
import com.techdev.tracker_kotlin.data.LoginRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideFirebaseAuth() = Firebase.auth

    @Provides
    fun providesLoginRepository(
        auth: FirebaseAuth
    ): LoginRepository =
        LoginRepositoryImpl(auth)
}
