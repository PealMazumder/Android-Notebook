package com.peal.androidnotebook.kotlinDelegates

import kotlin.properties.Delegates

/**
 * Created by Peal Mazumder on 28/1/25.
 */


/*
* What Are Kotlin Delegates?
    Kotlin delegates simplify and reuse code by allowing one object to handle certain tasks on behalf of another object.
    Property Delegation: Delegate property logic to a built-in or custom delegate using by, like lazy, observable, or vetoable.
    Class Delegation: Delegate interface implementation to another object using by.
* */


// Lazy Initialization: For delayed computation of interest on an account
val accountInterest: String by lazy {
    println("Calculating interest...")
    "Interest Calculated: $500.00"
}

// Observable: For tracking changes in the account balance
var accountBalance: Double by Delegates.observable(1000.0) { _, old, new ->
    println("Account balance changed from $$old to $$new")
}

// Vetoable: For restricting transaction amounts to within a valid range
var transactionLimit: Double by Delegates.vetoable(5000.0) { _, _, new ->
    new in 1.0..10000.0 // Allow only valid transaction limits
}

fun main() {
    println("Lazy Initialization")
    println(accountInterest) // Triggers interest calculation
    println(accountInterest) // Uses cached interest value

    println("\nObservable Example")
    accountBalance = 1200.0 // Triggers observable behavior
    accountBalance = 800.0 // Triggers observable behavior again

    println("\nVetoable Example")
    transactionLimit = 7000.0 // Allowed
    println("Transaction Limit: $$transactionLimit")
    transactionLimit = 12000.0 // Rejected
    println("Transaction Limit: $$transactionLimit")
}