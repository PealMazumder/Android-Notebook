package com.peal.androidnotebook.kotlinDelegates
import kotlin.reflect.KProperty

/**
 * Created by Peal Mazumder on 28/1/25.
 */


/*
* What Are Kotlin Delegates?
    Kotlin delegates simplify and reuse code by allowing one object to handle certain tasks on behalf of another object. It’s like saying, “Hey, you take care of this part for me!”
* */

// Custom delegate for wallet balance
class WalletBalanceDelegate(private var balance: Double) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Double {
        println("Getting '${property.name}': Current balance = $balance")
        return balance
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: Double) {
        if (newValue < 0) {
            println("Error: '${property.name}' cannot be set to a negative value!")
        } else {
            println("Updating '${property.name}' from $balance to $newValue")
            balance = newValue
        }
    }
}

class Wallet {
    var balance: Double by WalletBalanceDelegate(100.0) // Initial balance
}

fun main() {
    val wallet = Wallet()

    // Accessing balance
    println(wallet.balance) // Logs: Getting 'balance': Current balance = 100.0

    // Updating balance with a valid value
    wallet.balance = 50.0 // Logs: Updating 'balance' from 100.0 to 50.0
    println(wallet.balance) // Logs: Getting 'balance': Current balance = 50.0

    // Attempting to set a negative balance
    wallet.balance = -20.0 // Logs: Error: 'balance' cannot be set to a negative value!
    println(wallet.balance) // Logs: Getting 'balance': Current balance = 50.0
}
