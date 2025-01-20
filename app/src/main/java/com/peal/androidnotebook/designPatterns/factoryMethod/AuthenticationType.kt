package com.peal.androidnotebook.designPatterns.factoryMethod

/**
 * Created by Peal Mazumder on 20/1/25.
 */

sealed class AuthType(val name: String) {
    data object Google : AuthType("Google")
    data object Facebook : AuthType("Facebook")
    data object Microsoft : AuthType("Microsoft")
    data object Apple : AuthType("Apple")
}