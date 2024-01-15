package com.clo.closs.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun TwoItemRowComponent(
    modifier: Modifier = Modifier,
    title: String = "",
    text: String = "",
    textSize: Int = 14,
    textDecoration: TextDecoration = TextDecoration.None,
    maxLines: Int = 1
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Absolute.Left,
        verticalAlignment = Alignment.Top
    ) {
        CustomText(
            text = title,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            textSize = textSize,
            maxLines = maxLines
        )
        CustomText(
            text = text,
            fontWeight = FontWeight.Bold,
            textSize = textSize,
            textDecoration = textDecoration,
            maxLines = maxLines
        )
    }
}