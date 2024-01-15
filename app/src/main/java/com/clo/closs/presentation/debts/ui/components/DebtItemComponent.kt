package com.clo.closs.presentation.debts.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.clo.closs.presentation.components.CustomClickableCard
import com.clo.closs.presentation.components.CustomDivider
import com.clo.closs.presentation.components.CustomText
import com.clo.closs.presentation.components.TwoItemRowComponent

@Composable
fun DebtItemComponent(
    navigateToDetails: (String) -> Unit
) {
    CustomClickableCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.outline),
        shape = CardDefaults.outlinedShape,
        onClick = {
            navigateToDetails("1")
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TwoItemRowComponent(
                    title = "Cliente: ",
                    text = "J-000000000",
                    textSize = 18
                )
                CustomText(
                    text = "Por Vencer",
                    fontWeight = FontWeight.Bold,
                    textSize = 20
                )
            }

            CustomDivider()

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TwoItemRowComponent(
                    title = "Documento: ",
                    text = "00012312"
                )
                TwoItemRowComponent(
                    title = "Estado: ",
                    text = "Abonado"
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TwoItemRowComponent(
                    title = "Monto: ",
                    text = "$ 1,232.12"
                )
                TwoItemRowComponent(
                    title = "Deuda: ",
                    text = "$ 232.12"
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TwoItemRowComponent(
                    title = "Emisión: ",
                    text = "2023-10-11"
                )
                TwoItemRowComponent(
                    title = "Vence: ",
                    text = "2023-12-11"
                )
            }
        }
    }
}
