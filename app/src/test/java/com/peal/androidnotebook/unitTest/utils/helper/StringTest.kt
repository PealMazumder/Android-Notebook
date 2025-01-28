package com.peal.androidnotebook.unitTest.utils.helper

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Peal Mazumder on 28/1/25.
 */
class StringTest {
    @Test
    fun testStringReversal_EmptyString_expectedEmptyString() {
        val sut = Helper()
        val result = sut.reverseString("")
        assertEquals("", result)
    }

    @Test
    fun testStringReversal_SingleChar_expectedSingleChar() {
        val sut = Helper()
        val result = sut.reverseString("a")
        assertEquals("a", result)
    }

    @Test
    fun testStringReversal_ValidInput_expectedSameString() {
        val sut = Helper()
        val result = sut.reverseString("abc")
        assertEquals("cba", result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testStringReversal_NullValue_expectedException() {
        val sut = Helper()
        sut.reverseString(null)
    }
}