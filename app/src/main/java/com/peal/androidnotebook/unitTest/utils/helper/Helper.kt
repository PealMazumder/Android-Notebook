package com.peal.androidnotebook.unitTest.utils.helper

/**
 * Created by Peal Mazumder on 27/1/25.
 */

class Helper {
    fun isPalindrome(input: String): Boolean {
        val length = input.length

        for (i in 0 until length / 2) {
            if (input[i] != input[length - i - 1]) {
                return false
            }
        }
        return true
    }

}