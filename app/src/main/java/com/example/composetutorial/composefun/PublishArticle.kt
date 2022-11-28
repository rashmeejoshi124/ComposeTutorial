package com.example.composetutorial.composefun

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.R
import com.example.composetutorial.model.Article
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun PublishArticle(article: Article) {
    Text(text = article.body)
    Text(text = "Published by - ${article.author}")
}

/**
 * Shows text in Column - arranges elements vertically
 */
@Composable
fun PublishArticleInColumn(article: Article) {
    Column {
        Text(text = article.body)
        Text(text = "Published by - ${article.author}")
        Image(
            painter = painterResource(id = R.drawable.picture_background),
            contentDescription = "munjitla photo"
        )
    }
}

/**
 * Shows text in Row - arranges elements horizontally
 */
@Composable
fun PublishArticleInRow(article: Article) {
    Row {
        Text(text = article.body)
        Text(text = "Published by - ${article.author}")
    }
}

/**
 * Shows text in Box - stack elements
 */
@Composable
fun PublishArticleInBox(article: Article) {
    Box {
        Text(text = article.body)
        Text(text = "Published by - ${article.author}")
    }
}

@Composable
fun PublishArticleWithImage(article: Article){
    Column {
        Text(text = article.body)
        Row {
            Image(
                painter = painterResource(id = R.drawable.picture_background),
                contentDescription = "munjitla photo"
            )
            Text(text = "Published by - ${article.author}")
        }
    }
}

@Composable
fun publishArticleWithModifiers(article: Article) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.picture_background),
            contentDescription = "munjitla photo",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember {
            mutableStateOf(false)
        }
        val surfaceColor by animateColorAsState(targetValue = if (isExpanded)
            MaterialTheme.colors.primary else MaterialTheme.colors.surface)

        Surface(
            shape = MaterialTheme.shapes.medium,
            elevation = 1.dp,
            color = surfaceColor,
            modifier = Modifier.animateContentSize().padding(1.dp)
        ){
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = article.body,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = article.author, style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewPublishArticle() {
   ComposeTutorialTheme {
        publishArticleWithModifiers(
            Article(
                "Rashmi",
                "Start Reading about Compose with me"
            )
        )
    }
    /*PublishArticleInRow(
        Article(
            "Rashmi",
            "Start Reading about Compose with me"
        )
    )*/
    /* PublishArticleInBox(
         Article(
             "Rashmi",
             "Start Reading about Compose with me"
         )
     )*/
}