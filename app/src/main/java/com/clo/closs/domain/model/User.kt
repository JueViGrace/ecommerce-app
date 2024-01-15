package com.clo.closs.domain.model

import com.clo.closs.data.local.entities.UserEntity

data class User(
    val supervpor: String = "",
    val ultSinc: String = "",
    val createdAt: String = "",
    val codigo: String = "",
    val sesion: Boolean = false,
    val roleId: String = "",
    val almacen: String = "",
    val desactivo: Int = 0,
    val telefono: String = "",
    val nombre: String = "",
    val version: String = "",
    val email: String = ""
) {
    fun toDatabase() = UserEntity(
        supervpor = supervpor,
        ultSinc = ultSinc,
        createdAt = createdAt,
        codigo = codigo,
        sesion = sesion,
        roleId = roleId,
        almacen = almacen,
        desactivo = desactivo,
        telefono = telefono,
        nombre = nombre,
        version = version,
        email = email,
    )
}
