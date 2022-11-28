package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.composetutorial.composefun.Conversation
import com.example.composetutorial.composefun.publishArticleWithModifiers
import com.example.composetutorial.model.Article
import com.example.composetutorial.sampledata.articles
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* setContent {
            //s1 - Add text
            //Text("Hello Android!!")

            //s2 - Add Composable function
            //createMessageCard(name = "Rashmi")

            //s3 - Add Com Fun with Preview in studio
            //createGoodMorningCard()

            //s4 - Add multiple texts
            *//* PublishArticle(
                 article = Article(
                     "Rashmi Joshi",
                     "Reading about Dune & 5am club"
                 )
             )*//*

            //s5 - Using a column
            //PreviewPublishArticle()

            //s6 - Add image
            *//*PublishArticleWithImage(
                article = Article(
                    "Rashmi Joshi",
                    "Reading about Dune & 5am club"
                )
            )*//*

            //s7 - Use Modifiers
            publishArticleWithModifiers(
                article = Article(
                    "Rashmi",
                    "Start Reading about Compose with me"
                )
            )
        }*/

        //s8 - Use Matrial Design

        setContent {
            ComposeTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    /*publishArticleWithModifiers(
                        article = Article(
                            "Rashmi",
                            "Start Reading about Compose with me"
                        )
                    )*/

                    //s9 - Lists
                    Conversation(articles = articles)
                }
            }
        }
    }
}
