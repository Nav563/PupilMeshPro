package com.navneet.pupilmeshpro.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


object SignInScreen {


    @Composable
    fun Content() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ̵Box(modifier = Modifier.padding(innerPadding),
                contentAlignment = Alignment.Center) {

        }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SignInScreen.Content()
}