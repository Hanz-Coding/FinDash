package hanz.coding.findash.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import hanz.coding.findash.R
import hanz.coding.findash.presentation.home.components.ExchangeRateItem
import hanz.coding.findash.presentation.home.components.GoldPriceCard
import hanz.coding.findash.presentation.home.model.ExchangeRate
import hanz.coding.findash.presentation.home.model.PriceData
import hanz.coding.findash.ui.theme.Typography
import hanz.coding.findash.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = 16.dp)
    ) {
        // Header
        TopAppBar(
            title =
                {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.logo),
                                contentDescription = "Logo",
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Fit
                            )
                            Text(
                                text = "FinDash",
                                style = Typography.headlineMedium
                            )
                        }
                    }
                }
        )

        // Gold Price Section
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(R.color.card_background))
        ) {
            Text(
                text = "Gold Price",
                style = Typography.headlineSmall,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp),
                color = colorResource(R.color.primary_text)
            )
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                GoldPriceCard(
                    priceData = PriceData(
                        title = "Sell Price (Bid)",
                        price = "$2023.50",
                        percentage = "-0.8%",
                        change = "$-16.20",
                        isPositive = false
                    ),
                    modifier = Modifier.weight(1f)
                )
                GoldPriceCard(
                    priceData = PriceData(
                        title = "Buy Price (Ask)",
                        price = "$2024.20",
                        percentage = "+1.2%",
                        change = "$+24.00",
                        isPositive = true
                    ),
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Exchange Rates Section
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(R.color.card_background))
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Exchange Rates",
                    style = Typography.headlineSmall,
                    color = colorResource(R.color.primary_text),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                ExchangeRateItem(
                    rate = ExchangeRate(
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
                )

                Spacer(modifier = Modifier.height(24.dp))

                ExchangeRateItem(
                    rate = ExchangeRate(
                        pair = "GBP/USD",
                        sellPrice = "0.7850",
                        sellPercentage = "+1.1%",
                        sellChange = "+0.0086",
                        buyPrice = "0.7890",
                        buyPercentage = "+1.2%",
                        buyChange = "+0.0094",
                        isSellPositive = true,
                        isBuyPositive = true
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

                ExchangeRateItem(
                    rate = ExchangeRate(
                        pair = "JPY/USD",
                        sellPrice = "148.20",
                        sellPercentage = "-0.4%",
                        sellChange = "-0.59",
                        buyPrice = "148.45",
                        buyPercentage = "-0.3%",
                        buyChange = "-0.45",
                        isSellPositive = false,
                        isBuyPositive = false
                    )
                )
            }
        }

        // Trending News Section
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Trending News",
                    style = Typography.headlineSmall
                )
                Text(
                    text = "Latest Updates",
                    style = Typography.bodySmall
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun HomeScreenPreview(modifier: Modifier = Modifier) {
    HomeScreen()
}