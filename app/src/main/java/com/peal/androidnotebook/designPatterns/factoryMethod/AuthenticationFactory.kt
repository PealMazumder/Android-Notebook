package com.peal.androidnotebook.designPatterns.factoryMethod

/**
 * Created by Peal Mazumder on 20/1/25.
 */

object AuthenticationFactory {
    fun getAuthenticationMethod(type: AuthType): AuthenticationMethod {
        return when (type) {
            AuthType.Facebook -> FacebookAuthenticationMethod()
            AuthType.Google -> GoogleAuthenticationMethod()
            AuthType.Microsoft -> MicrosoftAuthenticationMethod()
            AuthType.Apple -> AppleAuthenticationMethod()
        }
    }
}