package com.clo.closs.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DividerTextComponent(
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
        )

        CustomText(
            modifier = Modifier.padding(8.dp),
            text = "o",
            textSize = 18,
        )

        CustomDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
        )
    }
}