package com.peal.androidnotebook.designPatterns.builder

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

/**
 * Created by Peal Mazumder on 23/1/25.
 */


class DialogBuilder {
    private var title: String = ""
    private var message: String? = null
    private var image: Int? = null
    private var imageWidth: Dp? = null
    private var imageHeight: Dp? = null
    private var positiveText: String? = null
    private var dismissText: String? = null

    private var onPositiveButtonClick: (() -> Unit)? = null
    private var onNegativeButtonClick: (() -> Unit)? = null

    private var titleTextStyle: TextStyle =
        TextStyle(color = Color.Black, fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
    private var messageTextStyle: TextStyle =
        TextStyle(
            color = Color.Black.copy(alpha = 0.7f),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )

    fun setTitle(title: String) = apply { this.title = title }
    fun setMessage(message: String?) = apply { this.message = message }
    fun setImage(imageResId: Int) = apply { this.image = imageResId }
    fun setImageSize(width: Dp?, height: Dp?) = apply {
        this.imageWidth = width
        this.imageHeight = height
    }

    fun setPositiveText(positiveText: String) = apply { this.positiveText = positiveText }
    fun setNegativeButtonText(dismissText: String) = apply { this.dismissText = dismissText }
    fun setOnPositiveButtonClick(action: () -> Unit) = apply { this.onPositiveButtonClick = action }
    fun setOnNegativeButtonClick(action: () -> Unit) = apply { this.onNegativeButtonClick = action }
    fun setTitleTextStyle(style: TextStyle) = apply { this.titleTextStyle = style }
    fun setMessageTextStyle(style: TextStyle) = apply { this.messageTextStyle = style }

    @Composable
    fun BuildDialog(
        showDialog: Boolean,
        onDismissRequest: () -> Unit,
        dismissOnClickOutside: Boolean = true,
        dismissOnBackPress: Boolean = true
    ) {
        if (showDialog) {
            Dialog(
                onDismissRequest = { onDismissRequest() },
                properties = DialogProperties(
                    dismissOnClickOutside = dismissOnClickOutside,
                    dismissOnBackPress = dismissOnBackPress
                )
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .testTag("dialog_container"),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = title,
                            style = titleTextStyle,
                            modifier = Modifier
                                .padding(bottom = 8.dp),
                            textAlign = TextAlign.Center
                        )

                        image?.let {

                            Spacer(modifier = Modifier.height(20.dp))

                            Image(
                                painter = painterResource(id = it),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .applyImageSize(imageWidth, imageHeight)
                                    .padding(bottom = 8.dp)
                                    .testTag("dialog_image")
                            )
                        }

                        message?.let {

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = it,
                                style = messageTextStyle,
                                modifier = Modifier.padding(bottom = 16.dp),
                                textAlign = TextAlign.Center
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            positiveText?.let { text ->
                                GradientButton(
                                    modifier = Modifier.weight(1f),
                                    text = text,
                                    gradientColors = listOf(
                                        Color(0xFFF7F3B2),
                                        Color(0xFFBB904E),
                                    ),
                                    onClick = {
                                        onPositiveButtonClick?.invoke()
                                        onDismissRequest()
                                    }
                                )
                            }

                            dismissText?.let { text ->
                                Spacer(modifier = Modifier.width(8.dp))

                                GradientButton(
                                    modifier = Modifier.weight(1f),
                                    text = text,
                                    gradientColors = listOf(
                                        Color(0xFFD8D8D8),
                                        Color(0xFFA8A9AD),
                                    ),
                                    onClick = {
                                        onNegativeButtonClick?.invoke()
                                        onDismissRequest()
                                    }
                                )
                            }

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GradientButton(
    modifier: Modifier,
    text: String,
    gradientColors: List<Color>,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .then(
                Modifier
                    .height(40.dp)
                    .clip(RoundedCornerShape(13.dp))
                    .background(Brush.verticalGradient(gradientColors))
                    .clickable { onClick() },
            ),

        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.Black.copy(alpha = 0.7f)
        )
    }
}

fun Modifier.applyImageSize(width: Dp?, height: Dp?): Modifier {
    return this
        .then(
            if (width != null) Modifier.width(width) else Modifier.wrapContentWidth()
        )
        .then(
            if (height != null) Modifier.height(height) else Modifier.wrapContentHeight()
        )
}





