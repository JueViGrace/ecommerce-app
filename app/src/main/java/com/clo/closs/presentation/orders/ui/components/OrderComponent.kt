package com.clo.closs.presentation.orders.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OrderComponent(
    navigateToDetails: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(15) {
            OrderItemComponent(
                navigateToDetails = { codigo ->
                    navigateToDetails(codigo)
                }
            )
        }
    }
}
