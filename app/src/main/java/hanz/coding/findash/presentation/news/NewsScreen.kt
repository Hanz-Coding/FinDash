package hanz.coding.findash.presentation.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hanz.coding.findash.R
import hanz.coding.findash.presentation.news.components.NewsCard
import hanz.coding.findash.presentation.news.components.fakeNewsModel
import hanz.coding.findash.presentation.news.model.NewsModel

@Composable
fun NewsScreen(news: List<NewsModel>) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(R.color.background))
                .padding(bottom = 80.dp)
        ) {
            // Header
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shadowElevation = 2.dp,
                color = colorResource(R.color.background)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 80.dp, top = 19.dp, bottom = 19.dp)
                ) {
                    Text(
                        text = "Financial News",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(R.color.primary_text)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 17.dp),
                        horizontalArrangement = Arrangement.spacedBy(22.dp)
                    ) {
                        Text(
                            text = "Latest",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(R.color.primary_text)
                        )
                        Text(
                            text = "Gold",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(R.color.secondary_text)
                        )
                        Text(
                            text = "Currency",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(R.color.secondary_text)
                        )
                        Text(
                            text = "Market",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(R.color.secondary_text)
                        )
                    }
                }
            }

            // News Content
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                // First News Card
                items(news) { item ->
                    NewsCard(item)
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
fun NewsScreenPreview(modifier: Modifier = Modifier) {
    val news = listOf(
        fakeNewsModel, fakeNewsModel, fakeNewsModel
    )
    NewsScreen(news)
}