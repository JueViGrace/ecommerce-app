package com.clo.closs.data.remote.model.auth

import com.clo.closs.domain.model.auth.Login

data class LoginDto(
    val password: String? = null,
    val email: String? = null
) {
    fun toDomain() = Login(
        password = password ?: "",
        email = email ?: ""
    )
}
