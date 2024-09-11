package com.example.moviedatabase.ui.screens

import android.window.SplashScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){

    LaunchedEffect(Unit) {
        delay(2000L)
        navController.navigate("movies"){
            popUpTo("splash"){
                inclusive = true
            }
        }
    }

    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Movie Database",
            fontSize = 32.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center)
    }

}