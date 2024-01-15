package com.clo.closs.presentation.auth.login.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.clo.closs.presentation.components.CustomText

@Composable
fun UnderLinedTextComponent(
    value: String,
    onButtonClicked: () -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        CustomText(
            text = value,
            modifier = Modifier
                .clickable { onButtonClicked() },
            color = MaterialTheme.colorScheme.tertiary,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
    }
}