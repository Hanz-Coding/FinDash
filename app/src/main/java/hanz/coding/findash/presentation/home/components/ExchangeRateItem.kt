package hanz.coding.findash.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import hanz.coding.findash.R
import hanz.coding.findash.presentation.home.model.ExchangeRate
import hanz.coding.findash.ui.theme.*

@Composable
fun ExchangeRateItem(
    rate: ExchangeRate,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
            .background(color = colorResource(R.color.card_background))
    ) {
        Text(
            text = rate.pair,
            style = Typography.headlineSmall,
            color = colorResource(R.color.primary_text)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Sell (Bid)",
                    style = Typography.bodySmall,
                    color = colorResource(R.color.primary_text)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.padding(top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = rate.sellPrice,
                        style = Typography.bodyMedium,
                        color = colorResource(R.color.primary_text)
                    )
                    Text(
                        text = rate.sellPercentage,
                        style = Typography.bodySmall.copy(
                            color = if (rate.isSellPositive) Green else Red
                        )
                    )
                    Text(
                        text = rate.sellChange,
                        style = Typography.bodySmall.copy(
                            color = if (rate.isSellPositive) Green else Red
                        )
                    )
                }
            }

            Column {
                Text(
                    text = "Buy (Ask)",
                    style = Typography.bodySmall
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Text(
                        text = rate.buyPrice,
                        style = Typography.bodyMedium
                    )
                    Text(
                        text = rate.buyPercentage,
                        style = Typography.bodySmall.copy(
                            color = if (rate.isBuyPositive) Green else Red
                        )
                    )
                    Text(
                        text = rate.buyChange,
                        style = Typography.bodySmall.copy(
                            color = if (rate.isBuyPositive) Green else Red
                        )
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
fun ExchangeRatePreview(modifier: Modifier = Modifier) {
    ExchangeRateItem(rate = fakeExchangeRateItem)
}

val fakeExchangeRateItem = ExchangeRate(
    pair = "EUR/USD",
    sellPrice = "1.0850",
    sellPercentage = "-0.8%",
    sellChange = "-0.0087",
    buyPrice = "1.0920",
    buyPercentage = "-0.7%",
    buyChange = "-0.0077",
    isSellPositive = false,
    isBuyPositive = false
)