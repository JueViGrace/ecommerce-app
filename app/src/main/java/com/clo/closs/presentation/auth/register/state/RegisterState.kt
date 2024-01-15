package com.clo.closs.presentation.auth.register.state

data class RegisterState(
    var names: String = "",
    var code: String = "",
    var phone: String = "",
    var email: String = "",
    var password: String = "",
    var privacyPolicyAccepted: Boolean = false,
    var registerResponse: String? = "",

    var namesError: Boolean = false,
    var codeError: Boolean = false,
    var phoneError: Boolean = false,
    var emailError: Boolean = false,
    var passwordError: Boolean = false,
    var privacyPolicyError: Boolean = false,
    var registerError: Boolean = false,
    val allValidationsPassed: Boolean = false,

    val registerInProgress: Boolean = false,
    val registered: Boolean = false,
)
