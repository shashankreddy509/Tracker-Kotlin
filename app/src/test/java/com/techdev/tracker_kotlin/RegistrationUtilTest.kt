package com.techdev.tracker_kotlin

import com.google.common.truth.Truth.assertThat
import com.techdev.tracker_kotlin.ui.auth.RegistrationUtil
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun emptyEmailAndPassword() {
        val result =
            RegistrationUtil.validateRegistrationInput(
                "",
                ""
            )
        assertThat(result).isFalse()
    }

    @Test
    fun emptyPassword() {
        val result =
            RegistrationUtil.validateRegistrationInput(
                "shashankreddy509@gmail.com",
                ""
            )
        assertThat(result).isFalse()
    }

    @Test
    fun emptyEmail() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123456"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun validEmailAndPasswordLessThanSixChars() {
        val result = RegistrationUtil.validateRegistrationInput(
            "shashankreddy509@gmail.com",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun inValidEmailId() {
        val result = RegistrationUtil.validateRegistrationInput(
            "asdasd",
            "123456"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun validEmailAndPassword() {
        val result = RegistrationUtil.validateRegistrationInput(
            "shashankreddy509@gmail.com",
            "123456"
        )
        assertThat(result).isTrue()
    }
}
