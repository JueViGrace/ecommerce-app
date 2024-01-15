package com.clo.closs.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TopComponent(
    iconVisible: Boolean = true,
    modifier: Modifier = Modifier.fillMaxWidth(),
    title: String = "",
    text: String = "",
    weightArrow: Float = 0.5f,
    weightText: Float = 0.7f,
    padding: Int = 15,
    titleSize: Int = 18,
    textSize: Int = 18,
    iconPressed: () -> Unit,
) {
    Row(
        modifier = modifier
            .padding(padding.dp),
        horizontalArrangement = if (iconVisible) Arrangement.SpaceBetween else Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (iconVisible) {
            Box(modifier = Modifier.weight(weightArrow)) {
                DefaultBackArrow {
                    iconPressed()
                }
            }
        }

        when {
            text.isNotEmpty() && title.isNotEmpty() -> {
                Box(modifier = Modifier.weight(weightText)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomText(
                            text = title,
                            textSize = titleSize,
                            fontWeight = FontWeight.Bold
                        )
                        CustomText(text = text, textSize = textSize, fontWeight = FontWeight.Bold)
                    }
                }
            }
            title.isNotEmpty() -> {
                Box(modifier = Modifier.weight(weightText)) {
                    CustomText(
                        text = title,
                        textSize = titleSize,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            text.isNotEmpty() -> {
                Box(modifier = Modifier.weight(weightText)) {
                    CustomText(
                        text = text,
                        textSize = textSize,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
