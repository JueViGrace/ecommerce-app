package com.clo.closs.presentation.cart.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.clo.closs.R
import com.clo.closs.presentation.components.TopComponent

@Composable
fun CartTopBarComponent(
    modifier: Modifier,
    popBack: () -> Unit
) {
    Box(modifier = modifier) {
        TopComponent(
            title = stringResource(R.string.your_cart),
            text = "5 items",
            iconPressed = {
                popBack()
            }
        )
    }
}
