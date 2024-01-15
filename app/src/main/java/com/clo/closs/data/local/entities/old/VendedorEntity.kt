package com.clo.closs.data.local.entities.old

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.clo.closs.domain.model.old.Vendedor

// Data Class que representa la tabla de vendedores
@Entity(tableName = "vendedores")
data class VendedorEntity(
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "sector") val sector: String,
    @ColumnInfo(name = "subsector") val subsector: String,
    @ColumnInfo(name = "supervpor") val supervpor: String,
    @ColumnInfo(name = "telefono_movil") val telefonoMovil: String,
    @ColumnInfo(name = "telefonos") val telefonos: String,
    @ColumnInfo(name = "ult_sinc") val ultSinc: String,
    @ColumnInfo(name = "username") val username: String,
    @PrimaryKey val vendedor: String,
    @ColumnInfo(name = "version") val version: String,
) {
    // Función de extensión para mapear los datos de la tabla al modelo de dominio
    fun toDomain() = Vendedor(
        email = email,
        nombre = nombre,
        sector = sector,
        subsector = subsector,
        supervpor = supervpor,
        telefonoMovil = telefonoMovil,
        telefonos = telefonos,
        ultSinc = ultSinc,
        username = username,
        vendedor = vendedor,
        version = version
    )
}
