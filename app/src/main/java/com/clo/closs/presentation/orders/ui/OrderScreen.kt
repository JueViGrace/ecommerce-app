package com.clo.closs.presentation.orders.ui

import androidx.compose.runtime.Composable
import com.clo.closs.presentation.orders.ui.components.OrderComponent

@Composable
fun OrderScreen(
    navigateToDetails: (String) -> Unit
) {
    OrderComponent(
        navigateToDetails = { codigo ->
            navigateToDetails(codigo)
        }
    )
}
