package com.clo.closs.presentation.auth.register.events

sealed class RegisterEvent {
    data class NameChanged(val names: String) : RegisterEvent()
    data class CodeChanged(val code: String) : RegisterEvent()
    data class PhoneChanged(val phone: String) : RegisterEvent()
    data class EmailChanged(val email: String) : RegisterEvent()
    data class PasswordChanged(val password: String) : RegisterEvent()
    data class PrivacyPolicyCheckBoxClicked(val status: Boolean) : RegisterEvent()
    data object RegisterButtonClicked : RegisterEvent()
}
