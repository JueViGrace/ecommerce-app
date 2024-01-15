package com.clo.closs.presentation.orders.ui.components

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
import androidx.compose.ui.unit.dp
import com.clo.closs.presentation.components.CustomClickableCard
import com.clo.closs.presentation.components.TwoItemRowComponent

@Composable
fun OrderItemComponent(
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
                    title = "Pedido: ",
                    text = "99-PED-20230606300"
                )
                TwoItemRowComponent(
                    title = "Nº Pedido: ",
                    text = "00046213"
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TwoItemRowComponent(
                    title = "Estado: ",
                    text = "Esperando ord. despacho"
                )
                TwoItemRowComponent(
                    title = "Emisión: ",
                    text = "2023-11-11"
                )
            }
        }
    }
}
