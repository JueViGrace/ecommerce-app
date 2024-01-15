package com.clo.closs.presentation.auth.login.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.clo.closs.R
import com.clo.closs.presentation.components.CustomOutlinedTextField
import com.clo.closs.presentation.components.CustomText

@Composable
fun EmailComponent(
    modifier: Modifier,
    value: String,
    newValue: (String) -> Unit,
    errorStatus: Boolean = false
) {
    CustomOutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChanged = {
            newValue(it)
        },
        label = {
            CustomText(text = stringResource(R.string.email))
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        placeholder = {
            CustomText(text = stringResource(R.string.email_placeholder))
        },
        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.ic_email), contentDescription = null)
        },
        isError = !errorStatus
    )
}