package com.clo.closs.presentation.auth.login.state

data class LoginState(
    var email: String = "",
    var password: String = "",
    val rememberChecked: Boolean = false,
    var loginResponse: String? = "",

    var emailError: Boolean = false,
    var passwordError: Boolean = false,
    var loginError: Boolean = false,
    val allValidationsPassed: Boolean = false,

    val loginInProgress: Boolean = false,
    val loggedIn: Boolean = false,
)
