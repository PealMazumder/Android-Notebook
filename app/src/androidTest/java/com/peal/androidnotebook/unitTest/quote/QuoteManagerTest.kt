package com.peal.androidnotebook.unitTest.quote

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals
import java.io.FileNotFoundException

/**
 * Created by Peal Mazumder on 28/1/25.
 */
class QuoteManagerTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun testPopulateQuoteFromAssets_InvalidJSON_expected_Exception() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "malformed.json")
    }

    @Test
    fun testPopulateQuoteFromAssets_InvalidJSON_expected_Count() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "quotes.json")
        assertEquals(10,quoteManager.quoteList.size)
    }

    @Test
    fun testCurrentQuote_expected_CorrectQuote() {
        // arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(arrayOf(
            Quote("Quote 1", "Author 1"),
            Quote("Quote 2", "Author 2"),
            Quote("Quote 3", "Author 3")
        ))

        // act
        val currentQuote = quoteManager.getCurrentQuote()

        // assert
        assertEquals("Quote 1", currentQuote.text)
        assertEquals("Author 1", currentQuote.author)
    }

    @Test
    fun testPreviousQuote_expected_CorrectQuote() {
        // arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(arrayOf(
            Quote("Quote 1", "Author 1"),
            Quote("Quote 2", "Author 2"),
            Quote("Quote 3", "Author 3")
        ))

        // act
        val currentQuote = quoteManager.getPreviousQuote()

        // assert
        assertEquals("Quote 1", currentQuote.text)
        assertEquals("Author 1", currentQuote.author)
    }

    @Test
    fun testNextQuote_expected_CorrectQuote() {
        // arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(arrayOf(
            Quote("Quote 1", "Author 1"),
            Quote("Quote 2", "Author 2"),
            Quote("Quote 3", "Author 3")
        ))

        // act
        val currentQuote = quoteManager.getNextQuote()

        // assert
        assertEquals("Quote 2", currentQuote.text)
        assertEquals("Author 2", currentQuote.author)
    }

}