package hanz.coding.findash.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hanz.coding.findash.R
import hanz.coding.findash.presentation.home.model.PriceData
import hanz.coding.findash.ui.theme.*

@Composable
fun GoldPriceCard(
    priceData: PriceData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = colorResource(R.color.background))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 16.dp),
            ) {
                Text(
                    text = priceData.title,
                    style = Typography.bodySmall,
                    color = colorResource(R.color.primary_text)
                )
                Text(
                    text = priceData.price,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.primary_text),
                    modifier = Modifier.padding(top = 4.dp)
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Text(
                        text = priceData.percentage,
                        style = Typography.bodyMedium.copy(
                            color = if (priceData.isPositive) Green else Red
                        ),
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = priceData.change,
                        style = Typography.bodyMedium.copy(
                            color = if (priceData.isPositive) Green else Red
                        )
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
fun GoldPriceCardPreview(modifier: Modifier = Modifier) {
    GoldPriceCard(
        priceData = fakePriceData,
    )
}

val fakePriceData = PriceData(
    title = "Sell Price",
    price = "$2332",
    isPositive = false,
    percentage = "12.56%",
    change = "12.56"
)