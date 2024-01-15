package com.clo.closs.presentation.cart.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CartProductsComponent(
    modifier: Modifier
) {
    Box(modifier = modifier) {
        LazyColumn {
            items(30) {
                CartProductsItemComponent()
            }
        }
    }
}
