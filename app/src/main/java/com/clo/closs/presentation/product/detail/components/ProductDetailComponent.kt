package com.clo.closs.presentation.product.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.clo.closs.presentation.components.CustomDivider
import com.clo.closs.presentation.components.CustomText
import com.clo.closs.presentation.components.TopComponent

@Composable
fun ProductDetailComponent(
    product: String?,
    popBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopComponent {
            popBack()
        }

        CustomDivider()
        product?.let {
            CustomText(text = it)
        }
    }
}
