package com.peal.androidnotebook.designPatterns.factoryMethod

/**
 * Created by Peal Mazumder on 20/1/25.
 */

class MicrosoftAuthenticationMethod : AuthenticationMethod {
    override fun authenticate() = "Authenticated with Microsoft"
}