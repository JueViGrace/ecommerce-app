package com.clo.closs.presentation.auth.forgetpassword.ui.components

import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.clo.closs.R
import com.clo.closs.presentation.auth.login.ui.components.EmailComponent
import com.clo.closs.presentation.components.CustomDefaultBtn
import com.clo.closs.presentation.components.CustomSpacer
import com.clo.closs.presentation.components.CustomText
import com.clo.closs.presentation.components.TopComponent

@Composable
fun ForgotPasswordComponent(
    popBack: () -> Unit
) {
    var email by remember {
        mutableStateOf("")
    }
    var errorState by remember {
        mutableStateOf(false)
    }

    val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    errorState = isEmailValid

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopComponent(
            title = stringResource(R.string.recupere),
            text = stringResource(R.string.escriba_su_correo_electronico),
            weightArrow = 0.3f,
            weightText = 1.0f,
            padding = 0
        ) {
            popBack()
        }

        CustomSpacer(paddingVertical = 25)

        CustomText(text = stringResource(R.string.olvido), textSize = 26, fontWeight = FontWeight.Bold)

        CustomText(
            text = stringResource(R.string.por_favor_escriba),
            textAlign = TextAlign.Center,
            maxLines = 3
        )

        CustomSpacer(paddingVertical = 75)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmailComponent(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                newValue = { newValue ->
                    email = newValue
                },
                errorStatus = errorState
            )

            CustomDefaultBtn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp, bottom = 50.dp),
                onClick = {
                    if (isEmailValid) {
                        popBack()
                    }
                },
                enabled = errorState
            ) {
                CustomText(
                    modifier = Modifier.padding(15.dp),
                    text = stringResource(R.string.continuar),
                    fontWeight = FontWeight.Bold,
                    textSize = 20
                )
            }
        }
    }
}
