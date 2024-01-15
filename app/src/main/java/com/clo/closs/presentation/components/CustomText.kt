package com.clo.closs.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun CustomText(
    text: String,
    textSize: Int = 14,
    fontWeight: FontWeight = FontWeight.Light,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = 1,
    color: Color = MaterialTheme.colorScheme.onSurface,
    modifier: Modifier = Modifier,
    textDecoration: TextDecoration = TextDecoration.None
) {
    Text(
        text = text,
        fontSize = textSize.sp,
        fontWeight = fontWeight,
        textAlign = textAlign,
        maxLines = maxLines,
        color = color,
        modifier = modifier,
        textDecoration = textDecoration
    )
}
