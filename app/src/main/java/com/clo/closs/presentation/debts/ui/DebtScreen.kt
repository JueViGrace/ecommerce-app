package com.clo.closs.presentation.debts.ui

import androidx.compose.runtime.Composable
import com.clo.closs.presentation.debts.ui.components.DebtComponent

@Composable
fun DebtScreen(
    navigateToDetails: (String) -> Unit
) {
    DebtComponent(
        navigateToDetails = { codigo ->
            navigateToDetails(codigo)
        }
    )
}
