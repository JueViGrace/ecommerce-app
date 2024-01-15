package com.clo.closs.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.clo.closs.domain.model.User

// Data Class que representa la tabla de usuarios
@Entity(tableName = "usuario")
data class UserEntity(
    @ColumnInfo(name = "supervpor") val supervpor: String,
    @ColumnInfo(name = "ultSinc") val ultSinc: String,
    @ColumnInfo(name = "createdAt") val createdAt: String,
    @ColumnInfo(name = "codigo") val codigo: String,
    @ColumnInfo(name = "sesion") val sesion: Boolean,
    @ColumnInfo(name = "roleId") val roleId: String,
    @ColumnInfo(name = "almacen") val almacen: String,
    @ColumnInfo(name = "desactivo") val desactivo: Int,
    @ColumnInfo(name = "telefono") val telefono: String,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "version") val version: String,
    @PrimaryKey val email: String,
) {
    // Función de extensión para mapear los datos de la tabla al modelo de dominio
    fun toDomain() = User(
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
