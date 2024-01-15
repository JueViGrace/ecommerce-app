package com.clo.closs.presentation.cart.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.clo.closs.presentation.components.CustomCard
import com.clo.closs.presentation.components.CustomSpacer
import com.clo.closs.presentation.components.CustomText

@Composable
fun CartProductsItemComponent() {
    CustomCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.outline),
        shape = CardDefaults.outlinedShape
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
            /*.pointerInput(Unit) {
                detectVerticalDragGestures { change, dragAmount ->
                    itemDrag = dragAmount
                }
            }*/,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                    .padding(10.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.cloccidental.com/img/1-0010.jpg")
                    .crossfade(enable = true)
                    .crossfade(200)
                    .build(),
                contentDescription = null
            )
            Column {
                CustomText(
                    text = "Cepillo de dientes 3000",
                    fontWeight = FontWeight.Bold,
                    textSize = 16
                )
                CustomSpacer(paddingVertical = 4)
                Row {
                    CustomText(text = "$79.99", fontWeight = FontWeight.Bold, textSize = 16)
                    CustomText(text = "x2", fontWeight = FontWeight.Bold, textSize = 16)
                }
            }
        }
    }
}
