package com.peal.androidnotebook.unitTest.utils.helper

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Peal Mazumder on 28/1/25.
 */

class PasswordTest {
    @Test
    fun validatePassword_blankInput_expectedRequiredField() {
        val sut = Helper()
        val result = sut.validatePassword("    ")
        assertEquals(result, "Password is required field")
    }

    @Test
    fun validatePassword_2CharInput_expectedValidationMsg() {
        val sut = Helper()
        val result = sut.validatePassword("ab")
        assertEquals(result, "Password must be at least 6 characters")
    }

    @Test
    fun validatePassword_16CharInput_expectedValidationMsg() {
        val sut = Helper()
        val result = sut.validatePassword("1234567890123456")
        assertEquals(result, "Password must be at most 15 characters")
    }

    @Test
    fun validatePassword_6CharInput_expectedValidationMsg() {
        val sut = Helper()
        val result = sut.validatePassword("123456")
        assertEquals(result, "Valid")
    }
}