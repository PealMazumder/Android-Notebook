package com.peal.androidnotebook.kotlinDelegates

/**
 * Created by Peal Mazumder on 28/1/25.
 */

class Transaction {
    // New property to represent the transaction category
    var transactionCategory: String = "Deposit"

    // Deprecated property delegating to the new one
    @Deprecated("Use 'transactionCategory' instead", ReplaceWith("transactionCategory"))
    var oldTransactionType: String by this::transactionCategory
}

fun main() {
    val transaction = Transaction()

    // Using the deprecated property
    transaction.oldTransactionType = "Withdrawal"

    // A warning is shown:
    // 'oldTransactionType: String' is deprecated. Use 'transactionCategory' instead.
    println("Transaction Category: ${transaction.transactionCategory}") // Output: Withdrawal

    // The new property can also be used directly
    transaction.transactionCategory = "Deposit"
    println("Old Transaction Type: ${transaction.oldTransactionType}") // Output: Deposit
}
