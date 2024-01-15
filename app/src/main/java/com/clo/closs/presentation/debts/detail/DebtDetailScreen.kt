package com.clo.closs.presentation.debts.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.clo.closs.presentation.components.CustomCard
import com.clo.closs.presentation.components.CustomText
import com.clo.closs.presentation.components.TopComponent

@Composable
fun DebtDetailScreen(
    popBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopComponent {
            popBack()
        }


        CustomCard {
            CustomText(text = "Debt detail")
        }
    }
}

