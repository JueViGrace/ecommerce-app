package com.clo.closs.domain.model.auth

import com.clo.closs.data.remote.model.auth.LoginDto

data class Login(
    val password: String,
    val email: String
) {
    fun toServer() = LoginDto(
        password = password,
        email = email
    )
}
