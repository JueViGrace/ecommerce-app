package com.clo.closs.presentation.auth.register.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.clo.closs.R
import com.clo.closs.presentation.auth.login.ui.components.ButtonComponent
import com.clo.closs.presentation.auth.login.ui.components.EmailComponent
import com.clo.closs.presentation.auth.login.ui.components.PasswordComponent
import com.clo.closs.presentation.auth.register.events.RegisterEvent
import com.clo.closs.presentation.auth.register.ui.components.CheckBoxTermsComponent
import com.clo.closs.presentation.auth.register.ui.components.RegisterTopComponent
import com.clo.closs.presentation.auth.register.viewmodel.RegisterViewModel
import com.clo.closs.presentation.components.AuthBottomComponent
import com.clo.closs.presentation.components.CustomOutlinedTextField
import com.clo.closs.presentation.components.CustomText
import com.clo.closs.presentation.components.DividerTextComponent

@Composable
fun RegisterScreen(
    registerViewModel: RegisterViewModel = hiltViewModel(),
    navigateToHome: () -> Unit,
    navigateToLogin: () -> Unit,
    navigateToTerms: () -> Unit
) {
    val state = registerViewModel.state.collectAsState()
    val events = registerViewModel::onEvent
    val context = LocalContext.current

    if (state.value.registerError) {
        Toast.makeText(context, state.value.registerResponse, Toast.LENGTH_SHORT).show()
    }

    if (state.value.registered) {
        Toast.makeText(context, state.value.registerResponse, Toast.LENGTH_SHORT).show()
        navigateToHome()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.horizontalGradient(
                    if (isSystemInDarkTheme()) {
                        listOf(
                            MaterialTheme.colorScheme.surface,
                            MaterialTheme.colorScheme.surfaceVariant
                        )
                    } else {
                        listOf(
                            MaterialTheme.colorScheme.surface,
                            MaterialTheme.colorScheme.surfaceVariant
                        )
                    }
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        var nameValue by remember {
            mutableStateOf("")
        }
        var codigoValue by remember {
            mutableStateOf("")
        }
        var phoneValue by remember {
            mutableStateOf("")
        }
        var emailValue by remember {
            mutableStateOf("")
        }
        var passwordValue by remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RegisterTopComponent(
                modifier = Modifier
                    .fillMaxWidth(),
                title = stringResource(id = R.string.bienvenido),
                text = stringResource(R.string.crea_tu_cuenta),
                textSize = 20,
            )

            CustomOutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = nameValue,
                onValueChanged = { newValue ->
                    nameValue = newValue
                    events(RegisterEvent.NameChanged(newValue))
                },
                label = {
                    CustomText(text = stringResource(R.string.nombres))
                },
                isError = !state.value.namesError,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )

            CustomOutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = codigoValue,
                onValueChanged = { newValue ->
                    codigoValue = newValue
                    events(RegisterEvent.CodeChanged(newValue))
                },
                label = {
                    CustomText(text = stringResource(R.string.register_code))
                },
                isError = !state.value.codeError,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )

            CustomOutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = phoneValue,
                onValueChanged = { newValue ->
                    phoneValue = newValue
                    events(RegisterEvent.PhoneChanged(newValue))
                },
                label = {
                    CustomText(text = stringResource(R.string.telefono))
                },
                isError = !state.value.phoneError,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Phone
                )
            )

            EmailComponent(
                modifier = Modifier.fillMaxWidth(),
                value = emailValue,
                newValue = { newValue ->
                    emailValue = newValue
                    events(RegisterEvent.EmailChanged(newValue))
                },
                errorStatus = state.value.emailError
            )

            PasswordComponent(
                modifier = Modifier.fillMaxWidth(),
                value = passwordValue,
                newValue = { newValue ->
                    passwordValue = newValue
                    events(RegisterEvent.PasswordChanged(newValue))
                },
                errorStatus = state.value.passwordError
            )

            CheckBoxTermsComponent(
                onTextSelected = {
                    navigateToTerms()
                },
                onCheckedChanged = {
                    events(RegisterEvent.PrivacyPolicyCheckBoxClicked(it))
                }
            )

            ButtonComponent(
                value = stringResource(R.string.register),
                onButtonClicked = {
                    events(RegisterEvent.RegisterButtonClicked)
                },
                isEnabled = state.value.allValidationsPassed
            )

            DividerTextComponent()

            AuthBottomComponent(
                modifier = Modifier.fillMaxWidth(),
                isLogin = true,
                onTextSelected = { navigateToLogin() }
            )
        }
    }
}
