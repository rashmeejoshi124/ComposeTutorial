package com.example.composetutorial.composefun

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutorial.model.Article
import com.example.composetutorial.sampledata.articles
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

@Composable
fun Conversation(articles: List<Article>) {
    LazyColumn {
        articles.map { item { publishArticleWithModifiers(article = it) } }
    }
}

@Preview
@Composable
fun previewConversation() {
    ComposeTutorialTheme {
        Conversation(articles = articles)
    }
}