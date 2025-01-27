package com.peal.androidnotebook.coroutinesAndFlow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Created by Peal Mazumder on 24/1/25.
 */

/*
* Coroutines: A coroutine in Kotlin is a lightweight, cooperative unit of concurrency used to perform asynchronous and non-blocking programming.
* Coroutines allow you to write asynchronous code in a sequential and readable way, making it easier to handle tasks like network calls, database operations, or animations without blocking the main thread.
* Internally, they use a combination of state machines, continuations, and structured concurrency to provide a clean and efficient abstraction for asynchronous programming.
*
* * Key Features of Coroutines
* Lightweight:
    Coroutines are much lighter than threads, you can run thousands of coroutines on just a few threads without significant overhead.
* Asynchronous:
    Coroutines can handle long-running tasks (like API calls) without blocking the main thread, ensuring a smooth user interface.
* Structured Concurrency:
    Coroutines work within a structured lifecycle. They are launched within a CoroutineScope, and their lifecycle is tied to that scope (e.g., viewModelScope, lifecycleScope).
* Suspendable Functions:
    Functions marked with the suspend keyword can suspend execution, allowing the coroutine to run other tasks and resume later from where it left off.
    * The state of the coroutine (local variables, where it was paused, etc.) is saved in the coroutine’s continuation object.
    * It may resume on the same thread or a different one, depending on the dispatcher.
* Thread Management:
    Coroutines leverage dispatchers (like Dispatchers.Main, Dispatchers.IO) to control which thread they run on, making thread management simpler.
* */

/*
* Important Coroutine Concepts
    CoroutineScope: A scope that manages the lifecycle of coroutines. When the scope is cancelled, all coroutines within it are also cancelled.
* * Dispatcher: Specifies the thread on which the coroutine should run:
* Dispatchers.Main: Runs on the main/UI thread.
* Dispatchers.IO: For I/O-intensive tasks (network, database).
* Dispatchers.Default: For CPU-intensive tasks.
* Dispatchers.Unconfined: Starts on the caller thread and resumes wherever the thread is available.
*
* * suspend Functions: Functions that can suspend the execution of a coroutine without blocking a thread.
* Example: delay(), withContext().
* * launch vs async:
* launch: Starts a coroutine and does not return a result.
* async: Starts a coroutine and returns a Deferred object that can be used to get the result.
* */




fun main() {
    launchCoroutineWithoutBlockingMain()
}

fun launchCoroutineWithoutBlockingMain() {
    CoroutineScope(Dispatchers.Default).launch {
        println("Running on Default thread")
        withContext(Dispatchers.IO) {
            println("Switching to IO thread")
        }
        println("Back to Default thread")
    }

}

/*
* Output: empty
* Reason: Main thread does not wait for the coroutine to finish.
* The launch function creates a coroutine, but it is non-blocking. Without blocking the main thread,
* the program exits before the coroutine has a chance to execute.
*
* Solution: Use the runBlocking function to wait for the coroutine to finish.
* */

fun launchCoroutineWithBlocking() {
    runBlocking {
        launch {
            println("Running on Default thread")
            withContext(Dispatchers.IO) {
                println("Switching to IO thread")
            }
            println("Back to Default thread")
        }
    }

}


/*
* Job and SupervisorJob are used to manage coroutine lifecycles and structured concurrency
*
* Job:
   * When a child coroutine fails (throws an exception), the failure propagates to the parent.
   * This means the entire coroutine hierarchy is cancelled, including all sibling coroutines.
* SupervisorJob:
   * When a child coroutine fails, the failure does NOT propagate to the parent or other sibling coroutines.
   * Each child is independent, so other child coroutines continue to execute.
* */
