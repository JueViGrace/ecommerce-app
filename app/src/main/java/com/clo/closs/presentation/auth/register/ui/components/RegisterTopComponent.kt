package com.clo.closs.presentation.auth.register.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.clo.closs.presentation.components.CustomText

@Composable
fun RegisterTopComponent(
    modifier: Modifier = Modifier.fillMaxWidth(),
    title: String = "",
    text: String = "",
    padding: Int = 15,
    titleSize: Int = 20,
    textSize: Int = 28,
) {
    Row(
        modifier = modifier
            .padding(padding.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomText(
                text = title,
                textSize = titleSize,
            )
            CustomText(text = text, textSize = textSize, fontWeight = FontWeight.Bold)
        }
    }
}
