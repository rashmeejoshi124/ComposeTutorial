package com.example.composetutorial.composefun

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun createMessageCard(name: String) {
    Text(text = "Hello $name!")
}

@Preview
@Composable
fun createGoodMorningCard() {
    createMessageCard(name = "Good Morning Everyone")
}