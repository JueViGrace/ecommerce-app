package com.clo.closs.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.clo.closs.R

@Composable
fun AppBar(
    isVisible: Boolean = true,
    searchSequence: (String) -> Unit,
    onCartIconClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    /*
    if (isVisible) {*/
    var typedText by remember {
        mutableStateOf("")
    }

    Row(
        modifier = modifier
            ,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomOutlinedTextField(
            value = typedText,
            onValueChanged = { newText ->
                typedText = newText
                searchSequence(newText)
            },
            placeholder = {
                CustomText(text = stringResource(R.string.buscar_producto))
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search_icon),
                    contentDescription = stringResource(
                        R.string.product_search
                    )
                )
            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.weight(1f)
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = CircleShape
                )
                .clickable { onCartIconClick() },
            contentAlignment = Alignment.Center
        ) {
            CustomImage(painter = painterResource(id = R.drawable.ic_cart_icon))
        }
    }
}
// }
