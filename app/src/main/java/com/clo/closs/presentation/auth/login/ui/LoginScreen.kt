package com.clo.closs.presentation.auth.login.ui

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.clo.closs.R
import com.clo.closs.presentation.auth.login.events.LoginEvent
import com.clo.closs.presentation.auth.login.ui.components.ButtonComponent
import com.clo.closs.presentation.auth.login.ui.components.EmailComponent
import com.clo.closs.presentation.auth.login.ui.components.PasswordComponent
import com.clo.closs.presentation.auth.login.ui.components.UnderLinedTextComponent
import com.clo.closs.presentation.auth.login.viewmodel.LoginViewModel
import com.clo.closs.presentation.components.AuthBottomComponent
import com.clo.closs.presentation.components.CheckBoxComponent
import com.clo.closs.presentation.components.CustomCard
import com.clo.closs.presentation.components.CustomImage
import com.clo.closs.presentation.components.CustomSpacer
import com.clo.closs.presentation.components.CustomText
import com.clo.closs.presentation.components.DividerTextComponent

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navigateToRegister: () -> Unit,
    navigateToHome: () -> Unit,
    navigateToForgotPassword: () -> Unit
) {
    val state = loginViewModel.state.collectAsState()
    val events = loginViewModel::onEvent
    val context = LocalContext.current

    if (state.value.loginError) {
        Toast.makeText(context, state.value.loginResponse, Toast.LENGTH_SHORT).show()
    }

    if (state.value.loggedIn) {
        Toast.makeText(context, "Bienvenido", Toast.LENGTH_SHORT).show()
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
        contentAlignment = Alignment.BottomCenter
    ) {
        var emailValue by rememberSaveable {
            mutableStateOf("")
        }
        var passwordValue by rememberSaveable {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomImage(
                modifier = Modifier
                    .size(200.dp)
                    .background(
                        color = if (isSystemInDarkTheme()) {
                            MaterialTheme.colorScheme.surface
                        } else {
                            MaterialTheme.colorScheme.primary
                        },
                        shape = CircleShape
                    ),
                painter = painterResource(id = R.drawable.icon_avlogo)
            )

            CustomCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                shape = CardDefaults.outlinedShape,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CustomText(
                        text = stringResource(R.string.bienvenido),
                        fontWeight = FontWeight.Bold,
                        textSize = 20
                    )
                    CustomText(
                        text = stringResource(R.string.accede_a_tu_cuenta),
                        fontWeight = FontWeight.Bold,
                        textSize = 20
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        EmailComponent(
                            modifier = Modifier.fillMaxWidth(),
                            value = emailValue,
                            newValue = { newValue ->
                                emailValue = newValue
                                events(LoginEvent.EmailChanged(newValue))
                            },
                            errorStatus = state.value.emailError
                        )

                        PasswordComponent(
                            modifier = Modifier.fillMaxWidth(),
                            value = passwordValue,
                            newValue = { newValue ->
                                passwordValue = newValue
                                events(LoginEvent.PasswordChanged(newValue))
                            },
                            errorStatus = state.value.passwordError
                        )

                        CustomSpacer(
                            paddingVertical = 5
                        )

                        CheckBoxComponent(text = "Recuérdame") { newValue ->
                            events(LoginEvent.RememberChecked(newValue))
                        }

                        CustomSpacer(
                            paddingVertical = 5
                        )

                        UnderLinedTextComponent(value = stringResource(R.string.olvido_su_contraseña)) {
                            navigateToForgotPassword()
                        }

                        CustomSpacer(
                            paddingVertical = 5
                        )

                        ButtonComponent(
                            value = stringResource(R.string.login),
                            onButtonClicked = {
                                events(LoginEvent.LoginButtonClicked)
                            },
                            isEnabled = state.value.allValidationsPassed
                        )
                    }
                }
            }

            DividerTextComponent(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )

            AuthBottomComponent(
                modifier = Modifier.fillMaxWidth(),
                isLogin = false,
                onTextSelected = { navigateToRegister() }
            )
        }
    }
}
