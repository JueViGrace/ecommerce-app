package com.clo.closs.presentation.orders.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.clo.closs.presentation.components.CustomCard
import com.clo.closs.presentation.components.CustomText
import com.clo.closs.presentation.components.TopComponent

@Composable
fun OrderDetailScreen(
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

        CustomCard {
            CustomText(text = "Order detail")
        }
    }
}
