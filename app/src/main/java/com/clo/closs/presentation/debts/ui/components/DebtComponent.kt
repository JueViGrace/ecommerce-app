package com.clo.closs.presentation.debts.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DebtComponent(
    navigateToDetails: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(15) {
            DebtItemComponent(
                navigateToDetails = { codigo ->
                    navigateToDetails(codigo)
                }
            )
        }
    }
}