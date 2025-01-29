package com.peal.androidnotebook.designPatterns.builder.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.peal.androidnotebook.R
import com.peal.androidnotebook.designPatterns.builder.DialogBuilder

/**
 * Created by Peal Mazumder on 23/1/25.
 */

@Composable
fun AlertDialogBuilderScreen(modifier: Modifier = Modifier) {
    var currentDialog by remember { mutableStateOf<DialogBuilder?>(null) }

    val dialog1 = DialogBuilder()
        .setTitle("Please Smile!")
        .setImage(R.drawable.smile)
        .setImageSize(111.dp, 160.dp)
        .setPositiveText("Okay")
        .setOnPositiveButtonClick { currentDialog = null }

    val dialog2 = DialogBuilder()
        .setTitle("Photo matching unsuccessful!")
        .setTitleTextStyle(
            TextStyle(
                color = Color(0xFFE60026),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        .setMessage("Please contact our customer care")
        .setImage(R.drawable.photo_mismatch)
        .setImageSize(100.dp, 100.dp)
        .setPositiveText("Call 1345")
        .setNegativeButtonText("Cancel")
        .setOnPositiveButtonClick { currentDialog = null }
        .setOnNegativeButtonClick { currentDialog = null }

    val dialog3 = DialogBuilder()
        .setTitle("Alert!")
        .setTitleTextStyle(
            TextStyle(
                color = Color.Black.copy(alpha = 0.7f),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        .setMessage("Do you want to remove this beneficiary account?")
        .setPositiveText("Delete")
        .setNegativeButtonText("Cancel")
        .setOnPositiveButtonClick { currentDialog = null }
        .setOnNegativeButtonClick { currentDialog = null }


    val dialog4 = DialogBuilder()
        .setTitle("Disable Touch/Face ID?")
        .setTitleTextStyle(
            TextStyle(
                color = Color.Black.copy(alpha = 0.7f),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        .setImage(R.drawable.biometric)
        .setMessage("By disabling Touch/Face ID, you can login with PIN only.")
        .setImageSize(100.dp, 120.dp)
        .setPositiveText("Disable")
        .setNegativeButtonText("Cancel")
        .setOnPositiveButtonClick { currentDialog = null }
        .setOnNegativeButtonClick { currentDialog = null }

    val dialog5 = DialogBuilder()
        .setTitle("Congratulations!")
        .setTitleTextStyle(
            TextStyle(
                color = Color(0xFF3DAE72),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        .setImage(R.drawable.biometric_success)
        .setImageSize(100.dp, 120.dp)
        .setMessage("You have successfully enabled Touch/Face ID.")
        .setPositiveText("Done")
        .setOnPositiveButtonClick { currentDialog = null }

    val dialog6 = DialogBuilder()
        .setTitle("Record not found")
        .setTitleTextStyle(
            TextStyle(
                color = Color.Black.copy(alpha = 0.7f),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        .setImage(R.drawable.record_not_found)
        .setImageSize(100.dp, 100.dp)
        .setPositiveText("Okay")
        .setOnPositiveButtonClick { currentDialog = null }


    Column(
        modifier = modifier.testTag("dialog_builder_screen"),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { currentDialog = dialog1 }) {
            Text("Show Dialog 1")
        }

        Button(onClick = { currentDialog = dialog2 }) {
            Text("Show Dialog 2")
        }

        Button(onClick = { currentDialog = dialog3 }) {
            Text("Show Dialog 3")
        }

        Button(onClick = { currentDialog = dialog4 }) {
            Text("Show Dialog 4")
        }

        Button(onClick = { currentDialog = dialog5 }) {
            Text("Show Dialog 5")
        }

        Button(onClick = { currentDialog = dialog6 }) {
            Text("Show Dialog 6")
        }

        currentDialog?.BuildDialog(
            showDialog = currentDialog != null,
            onDismissRequest = { currentDialog = null }
        )
    }
}
