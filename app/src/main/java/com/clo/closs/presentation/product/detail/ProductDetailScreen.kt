package com.clo.closs.presentation.product.detail

import androidx.compose.runtime.Composable
import com.clo.closs.presentation.product.detail.components.ProductDetailComponent

@Composable
fun ProductDetailScreen(
    product: String?,
    popBack: () -> Unit
) {
    ProductDetailComponent(
        product = product
    ) {
        popBack()
    }
}
