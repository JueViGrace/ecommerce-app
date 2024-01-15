package com.clo.closs.presentation.product.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.clo.closs.R
import com.clo.closs.presentation.components.CustomDefaultBtn
import com.clo.closs.presentation.components.CustomSpacer
import com.clo.closs.presentation.components.CustomText

@Composable
fun ProductButtonsComponent(
    onSubtract: () -> Unit,
    onAdd: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Absolute.Center
    ) {
        CustomDefaultBtn(
            modifier = Modifier.size(30.dp),
            shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp, topEnd = 0.dp, bottomEnd = 0.dp),
            onClick = {
                onSubtract()
            }
        ) {
            CustomText(
                text = stringResource(id = R.string.guion),
                textSize = 16,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        CustomSpacer(paddingHorizontal = 1)
        CustomDefaultBtn(
            modifier = Modifier.size(30.dp),
            shape = RoundedCornerShape(topStart = 0.dp, bottomStart = 0.dp, topEnd = 20.dp, bottomEnd = 20.dp),
            onClick = {
                onAdd()
            }
        ) {
            CustomText(
                text = stringResource(R.string.mas),
                textSize = 16,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}