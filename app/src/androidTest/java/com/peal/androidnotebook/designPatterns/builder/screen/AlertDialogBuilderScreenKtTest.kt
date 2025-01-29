package com.peal.androidnotebook.designPatterns.builder.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.peal.androidnotebook.MainActivity
import org.junit.Rule
import org.junit.Test


/**
 * Created by Peal Mazumder on 29/1/25.
 */

class AlertDialogBuilderScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testDialog1_DisplayAndDismiss() {
        // Click the first dialog button
        composeTestRule.onNodeWithText("Show Dialog 1").performClick()

        // Verify dialog content
        composeTestRule.onNodeWithText("Please Smile!").assertIsDisplayed()
        composeTestRule.onNodeWithText("Okay").assertIsDisplayed()

        // Check if image is displayed
        composeTestRule.onNode(hasTestTag("dialog_image")).assertExists()

        // Click positive button and verify dialog dismissal
        composeTestRule.onNodeWithText("Okay").performClick()
        composeTestRule.onNodeWithText("Please Smile!").assertDoesNotExist()
    }

    @Test
    fun testDialog2_DisplayAndDismiss() {
        // Click the second dialog button
        composeTestRule.onNodeWithText("Show Dialog 2").performClick()

        // Verify dialog content
        composeTestRule.onNodeWithText("Photo matching unsuccessful!").assertIsDisplayed()
        composeTestRule.onNodeWithText("Please contact our customer care").assertIsDisplayed()
        composeTestRule.onNodeWithText("Call 1345").assertIsDisplayed()
        composeTestRule.onNodeWithText("Cancel").assertIsDisplayed()

        // Check if image is displayed
        composeTestRule.onNode(hasTestTag("dialog_image")).assertExists()

        // Test positive button dismissal
        composeTestRule.onNodeWithText("Call 1345").performClick()
        composeTestRule.onNodeWithText("Photo matching unsuccessful!").assertDoesNotExist()
    }

    @Test
    fun testDialog2_CancelButton() {
        composeTestRule.onNodeWithText("Show Dialog 2").performClick()
        composeTestRule.onNodeWithText("Cancel").performClick()
        composeTestRule.onNodeWithText("Photo matching unsuccessful!").assertDoesNotExist()
    }

    @Test
    fun testDialog3_ConfirmationDialog() {
        composeTestRule.onNodeWithText("Show Dialog 3").performClick()

        // Verify dialog content
        composeTestRule.onNodeWithText("Alert!").assertIsDisplayed()
        composeTestRule.onNodeWithText("Do you want to remove this beneficiary account?").assertIsDisplayed()
        composeTestRule.onNodeWithText("Delete").assertIsDisplayed()
        composeTestRule.onNodeWithText("Cancel").assertIsDisplayed()

        // Test delete button
        composeTestRule.onNodeWithText("Delete").performClick()
        composeTestRule.onNodeWithText("Alert!").assertDoesNotExist()
    }

    @Test
    fun testDialog4_BiometricDisableDialog() {
        composeTestRule.onNodeWithText("Show Dialog 4").performClick()

        // Verify dialog content
        composeTestRule.onNodeWithText("Disable Touch/Face ID?").assertIsDisplayed()
        composeTestRule.onNodeWithText("By disabling Touch/Face ID, you can login with PIN only.").assertIsDisplayed()
        composeTestRule.onNode(hasTestTag("dialog_image")).assertExists()

        // Test both buttons
        composeTestRule.onNodeWithText("Disable").performClick()
        composeTestRule.onNodeWithText("Disable Touch/Face ID?").assertDoesNotExist()
    }

    @Test
    fun testDialog5_SuccessDialog() {
        composeTestRule.onNodeWithText("Show Dialog 5").performClick()

        // Verify dialog content
        composeTestRule.onNodeWithText("Congratulations!").assertIsDisplayed()
        composeTestRule.onNodeWithText("You have successfully enabled Touch/Face ID.").assertIsDisplayed()
        composeTestRule.onNode(hasTestTag("dialog_image")).assertExists()

        // Test dismissal
        composeTestRule.onNodeWithText("Done").performClick()
        composeTestRule.onNodeWithText("Congratulations!").assertDoesNotExist()
    }

    @Test
    fun testDialog6_RecordNotFoundDialog() {
        composeTestRule.onNodeWithText("Show Dialog 6").performClick()

        // Verify dialog content
        composeTestRule.onNodeWithText("Record not found").assertIsDisplayed()
        composeTestRule.onNode(hasTestTag("dialog_image")).assertExists()

        // Test dismissal
        composeTestRule.onNodeWithText("Okay").performClick()
        composeTestRule.onNodeWithText("Record not found").assertDoesNotExist()
    }

    @Test
    fun testAllButtonsExist() {
        // Verify all dialog trigger buttons are present
        composeTestRule.onNodeWithText("Show Dialog 1").assertExists()
        composeTestRule.onNodeWithText("Show Dialog 2").assertExists()
        composeTestRule.onNodeWithText("Show Dialog 3").assertExists()
        composeTestRule.onNodeWithText("Show Dialog 4").assertExists()
        composeTestRule.onNodeWithText("Show Dialog 5").assertExists()
        composeTestRule.onNodeWithText("Show Dialog 6").assertExists()
    }

}