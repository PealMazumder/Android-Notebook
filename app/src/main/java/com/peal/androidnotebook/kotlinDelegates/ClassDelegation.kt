package com.peal.androidnotebook.kotlinDelegates

/**
 * Created by Peal Mazumder on 28/1/25.
 */

interface PaymentGateway {
    fun pay(amount: Double)
}

class StripeGateway : PaymentGateway {
    override fun pay(amount: Double) = println("Paid $$amount using Stripe")
}

class PayPalGateway : PaymentGateway {
    override fun pay(amount: Double) = println("Paid $$amount using PayPal")
}

class PaymentProcessor(gateway: PaymentGateway) : PaymentGateway by gateway

fun main() {
    val stripeProcessor = PaymentProcessor(StripeGateway())
    stripeProcessor.pay(50.0)

    val paypalProcessor = PaymentProcessor(PayPalGateway())
    paypalProcessor.pay(100.0)
}
