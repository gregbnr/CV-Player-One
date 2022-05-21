package com.gregoirebonnier.cvplayerone.ui

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

class AboutScreen() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainScreen() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "About me",
                            fontSize = 20.sp,
                            color = MaterialTheme.colors.onPrimary,
                        )
                    },
                    backgroundColor = MaterialTheme.colors.primary
                )
            },
            content = {
                Text(text = "Hello")
            }
        )
    }

}