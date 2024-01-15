package com.clo.closs.presentation.product.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.clo.closs.domain.model.Product

@Composable
fun ProductComponent(
    modifier: Modifier = Modifier,
    products: List<Product> = emptyList(),
    navigateToDetails: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            products,
            key = { item -> item.codigo }
        ) { product ->
            ProductItemComponent(
                product = product,
                navigateToDetails = { codigo ->
                    navigateToDetails(codigo)
                }
            )
        }
    }
}
