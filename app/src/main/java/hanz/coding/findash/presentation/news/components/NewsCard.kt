package hanz.coding.findash.presentation.news.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import hanz.coding.findash.R
import hanz.coding.findash.presentation.news.model.NewsModel

@Composable
fun NewsCard(newsModel: NewsModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.card_background))
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2.76f)
            ) {
                AsyncImage(
                    model = newsModel.imageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                newsModel.overlayImageUrl?.let {
                    AsyncImage(
                        model = it,
                        contentDescription = null,
                        modifier = Modifier
                            .size(56.dp)
                            .clip(RoundedCornerShape(28.dp))
                            .align(Alignment.Center),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = newsModel.source,
                        fontSize = 12.sp,
                        color = colorResource(R.color.secondary_text),
                    )
                    Text(
                        text = newsModel.timeAgo,
                        fontSize = 12.sp,
                        color = colorResource(R.color.secondary_text),
                    )
                }

                Text(
                    text = newsModel.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(R.color.primary_text),
                    modifier = Modifier.padding(top = 9.dp)
                )

                Text(
                    text = newsModel.description,
                    fontSize = 14.sp,
                    color = colorResource(R.color.secondary_text),
                    lineHeight = 21.sp,
                    modifier = Modifier.padding(top = 9.dp)
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun NewsCardPreview(modifier: Modifier = Modifier) {
    NewsCard(fakeNewsModel)
}

val fakeNewsModel = NewsModel(
    title = "Chiều 17/4, giá vàng SJC, vàng nhẫn mua vào tăng mạnh 4 triệu đồng mỗi lượng, tiếp tục lập đỉnh mới",
    source = "cafef.vn",
    imageUrl = "https://cafefcdn.com/203337114487263232/2025/4/17/avatar1744875948902-17448759498492079401269.jpg",
    timeAgo = "2 hours",
    description = "Chiều 17/4, một nhà vàng đã tăng giá vàng SJC mua vào thêm 4 triệu đồng/lượng so với mở cửa phiên giao dịch sáng nay.",
)