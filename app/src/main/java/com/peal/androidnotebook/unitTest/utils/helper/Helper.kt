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


    fun validatePassword(input: String) = when {
        input.isBlank() -> {
            "Password is required field"
        }

        input.length < 6 -> {
            "Password must be at least 6 characters"
        }

        input.length > 15 -> {
            "Password must be at most 15 characters"
        }

        else -> {
            "Valid"
        }
    }


    fun reverseString(input: String?): String {
        if (input == null) {
            throw IllegalArgumentException("Input string cannot be null")
        }
        val charArray = input.toCharArray()  // Convert the string to a CharArray for mutability
        var i = 0
        var j = charArray.size - 1

        while (i < j) {
            val temp = charArray[i]
            charArray[i] = charArray[j]
            charArray[j] = temp
            i++
            j--
        }

        return String(charArray)
    }

}