package com.clo.closs.domain.rules

import android.util.Patterns

object Validator {

    fun validateNames(names: String): ValidationResult {
        return ValidationResult(
            (names.isNotEmpty() && names.length >= 4)
        )
    }

    fun validateCode(code: String): ValidationResult {
        return ValidationResult(
            (code.isNotEmpty() && code.length > 6)
        )
    }

    fun validatePhone(phone: String): ValidationResult {
        return ValidationResult(
            (phone.isNotEmpty() && phone.length > 10)
        )
    }

    fun validateEmail(email: String): ValidationResult {
        return ValidationResult(
            (Patterns.EMAIL_ADDRESS.matcher(email).matches())
        )
    }

    fun validatePassword(password: String): ValidationResult {
        return ValidationResult(
            (password.isNotEmpty() && password.length >= 6)
        )
    }

    fun validatePrivacyPolicyAcceptance(statusValue: Boolean): ValidationResult {
        return ValidationResult(
            statusValue
        )
    }
}

data class ValidationResult(
    val status: Boolean = false
)
