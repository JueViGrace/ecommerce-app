package com.clo.closs.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomSpacer(
    paddingVertical: Int = 0,
    paddingHorizontal: Int = 0
) {
    Spacer(modifier = Modifier.padding(vertical = paddingVertical.dp, horizontal = paddingHorizontal.dp))
}
