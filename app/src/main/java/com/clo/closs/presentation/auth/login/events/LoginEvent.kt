package com.clo.closs.presentation.auth.login.events

sealed class LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()
    data class RememberChecked(val status: Boolean) : LoginEvent()
    data object LoginButtonClicked : LoginEvent()
}
