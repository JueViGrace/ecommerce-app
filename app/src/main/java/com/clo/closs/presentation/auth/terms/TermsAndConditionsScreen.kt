package com.clo.closs.presentation.auth.terms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.clo.closs.R
import com.clo.closs.presentation.components.TopComponent

@Composable
fun TermsAndConditionsScreen(
    backPressed: () -> Unit
){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        TopComponent(
            iconPressed = { backPressed() },
            title = stringResource(R.string.terms_and_conditions)
        )
    }
}