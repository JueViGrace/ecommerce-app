package com.clo.closs.navigation.authgraph

import androidx.navigation.NamedNavArgument
import com.clo.closs.common.Constantes.FORGOT_PASSWORD
import com.clo.closs.common.Constantes.LOGIN
import com.clo.closs.common.Constantes.REGISTER
import com.clo.closs.common.Constantes.TERMS_AND_CONDITIONS

sealed class AuthScreens(val route: String, val arguments: List<NamedNavArgument>) {
    data object LoginScreen : AuthScreens(
        route = LOGIN,
        arguments = emptyList()
    )
    data object RegisterScreen : AuthScreens(
        route = REGISTER,
        arguments = emptyList()
    )
    data object TermsAndConditionsScreen : AuthScreens(
        route = TERMS_AND_CONDITIONS,
        arguments = emptyList()
    )
    data object ForgetPasswordScreen : AuthScreens(
        route = FORGOT_PASSWORD,
        arguments = emptyList()
    )
}
