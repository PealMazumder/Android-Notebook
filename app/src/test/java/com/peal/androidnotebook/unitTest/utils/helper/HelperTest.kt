package com.peal.androidnotebook.unitTest.utils.helper

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by Peal Mazumder on 27/1/25.
 */
class HelperTest {
    lateinit var helper: Helper

    @Before
    fun setUp() {
        helper = Helper()
    }

    @After
    fun tearDown() {
        println("tearDown")
    }

    @Test
    fun isPalindrome_inputString_1234_expectedFalse() {
        // arrange
        // act
        val result = helper.isPalindrome("1234")
        // assert
        assertEquals(false, result)
    }

    @Test
    fun isPalindrome_inputString_level_expectedTrue() {
        // arrange
        // act
        val result = helper.isPalindrome("level")
        // assert
        assertEquals(true, result)
    }
}