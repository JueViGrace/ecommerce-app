package com.clo.closs.domain.model.auth

import com.clo.closs.data.remote.model.auth.RegisterDto

data class Register(
    val password: String,
    val code: String,
    val telefono: String,
    val name: String,
    val email: String
) {
    fun toServer() = RegisterDto(
        password = password,
        codigo = code,
        telefono = telefono,
        nombre = name,
        email = email
    )
}
