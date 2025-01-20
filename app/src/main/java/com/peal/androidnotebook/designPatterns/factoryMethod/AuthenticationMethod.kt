package com.peal.androidnotebook.designPatterns.factoryMethod

/**
 * Created by Peal Mazumder on 20/1/25.
 */
interface AuthenticationMethod {
    fun authenticate() : String
}