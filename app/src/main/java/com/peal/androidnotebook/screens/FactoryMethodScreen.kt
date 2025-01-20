package com.peal.androidnotebook.screens


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.peal.androidnotebook.designPatterns.factoryMethod.AuthType
import com.peal.androidnotebook.designPatterns.factoryMethod.AuthenticationFactory

/**
 * Created by Peal Mazumder on 20/1/25.
 */

@Composable
fun FactoryMethodScreen(modifier: Modifier) {
    val authTypes = listOf(AuthType.Google, AuthType.Facebook, AuthType.Microsoft, AuthType.Apple)
    val context = LocalContext.current

    LazyColumn(
        modifier = modifier
    ) {
        items(count = authTypes.size, key = { it }) { index ->
            Button(
                onClick = {
                    val authenticationMethod = AuthenticationFactory
                        .getAuthenticationMethod(authTypes[index])
                    val message = authenticationMethod.authenticate()
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .height(56.dp)
            ) {
                Text(text = authTypes[index].name, textAlign = TextAlign.Center)
            }
        }
    }
}
