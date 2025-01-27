package com.peal.androidnotebook.coroutinesAndFlow

import kotlinx.coroutines.flow.Flow

/**
 * Created by Peal Mazumder on 24/1/25.
 */

/*
* Reactive programming: a programming approach where code automatically responds to changes in data, like a spreadsheet that instantly updates all related cells when one cell's value changes.
*
* Instead of requesting data, we observe it so any update to the source of data will flow down to the consumer automatically
*
* Flow: A reactive data stream that can be observed and transformed in a reactive way without blocking the main thread of execution.
*       Flow can safely make a network request to produce the next value without blocking the main thread.
*
*
* There are three entities involved in streams of data:
        A producer produces data that is added to the stream. Thanks to coroutines, flows can also produce data asynchronously.
        (Optional) Intermediaries can modify each value emitted into the stream or the stream itself.
        A consumer consumes the values from the stream.
        *
        *
        * Flows are cold and lazy unless specified with other intermediate operators. If the flow is used as a producer, it will be executed only when the first consumer is subscribed to it.
* */


