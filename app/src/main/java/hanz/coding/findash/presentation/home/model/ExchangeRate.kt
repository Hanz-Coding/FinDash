package hanz.coding.findash.presentation.home.model

data class ExchangeRate(
    val pair: String,
    val sellPrice: String,
    val sellPercentage: String,
    val sellChange: String,
    val buyPrice: String,
    val buyPercentage: String,
    val buyChange: String,
    val isSellPositive: Boolean,
    val isBuyPositive: Boolean
)
