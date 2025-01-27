package com.peal.androidnotebook.unitTest.utils.helper

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * Created by Peal Mazumder on 27/1/25.
 */
@RunWith(value = Parameterized::class)
class HelperParameterizedTestExample(val input: String, val expectedValue: Boolean) {
    @Test
    fun testIsPalindrome() {
        val helper = Helper()
        val result = helper.isPalindrome(input)
        assertEquals(expectedValue, result)
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is palindrome -> {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)
            )
        }
    }
}