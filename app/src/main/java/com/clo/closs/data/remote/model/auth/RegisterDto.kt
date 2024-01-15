package com.clo.closs.data.remote.model.auth

import com.clo.closs.domain.model.auth.Register

data class RegisterDto(
    val password: String? = null,
    val codigo: String? = null,
    val telefono: String? = null,
    val nombre: String? = null,
    val email: String? = null
) {
    fun toDomain() = Register(
        password = password ?: "",
        code = codigo ?: "",
        telefono = telefono ?: "",
        name = nombre ?: "",
        email = email ?: ""
    )
}
