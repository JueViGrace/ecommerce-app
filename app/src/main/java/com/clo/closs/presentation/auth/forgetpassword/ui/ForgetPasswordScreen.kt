package com.clo.closs.presentation.auth.forgetpassword.ui

import androidx.compose.runtime.Composable
import com.clo.closs.presentation.auth.forgetpassword.ui.components.ForgotPasswordComponent

@Composable
fun ForgetPasswordScreen(
    popBack: () -> Unit
) {
    ForgotPasswordComponent {
        popBack()
    }
}
