package hanz.coding.findash.presentation.news.model

data class NewsModel(
    val source: String,
    val title: String,
    val description: String,
    val timeAgo: String,
    val imageUrl: String,
    val overlayImageUrl: String? = null
)
