package com.clo.closs.data.remote.model.response

import com.clo.closs.domain.model.Auth
import com.clo.closs.domain.model.User
import com.google.gson.annotations.SerializedName

data class AuthResponse(

    @field:SerializedName("user")
    val user: UserResponse? = null,

    @field:SerializedName("token")
    val token: String? = null
) {
    fun toDomain() = Auth(
        token = token ?: "",
        user = user?.toDomain() ?: User()
    )
}

data class UserResponse(

    @field:SerializedName("supervpor")
    val supervpor: String? = null,

    @field:SerializedName("ult_sinc")
    val ultSinc: String? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("codigo")
    val codigo: String? = null,

    @field:SerializedName("sesion")
    val sesion: Boolean? = null,

    @field:SerializedName("roleId")
    val roleId: String? = null,

    @field:SerializedName("almacen")
    val almacen: String? = null,

    @field:SerializedName("desactivo")
    val desactivo: Int? = null,

    @field:SerializedName("telefono")
    val telefono: String? = null,

    @field:SerializedName("nombre")
    val nombre: String? = null,

    @field:SerializedName("version")
    val version: String? = null,

    @field:SerializedName("email")
    val email: String? = null
){
    fun toDomain() = User(
        supervpor = supervpor ?: "",
        ultSinc = ultSinc ?: "",
        createdAt = createdAt ?: "",
        codigo = codigo ?: "",
        sesion = sesion ?: false,
        roleId = roleId ?: "",
        almacen = almacen ?: "",
        desactivo = desactivo ?: 0,
        telefono = telefono ?: "",
        nombre = nombre ?: "",
        version = version ?: "",
        email = email ?: "",
    )
}
