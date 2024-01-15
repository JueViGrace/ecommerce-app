package com.clo.closs.presentation.components

import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomDivider(
    modifier: Modifier = Modifier,
    thickness: Double = 1.0,
    color: Color = MaterialTheme.colorScheme.onSurface,
) {
    Divider(modifier = modifier, thickness = thickness.dp, color = color)
}
