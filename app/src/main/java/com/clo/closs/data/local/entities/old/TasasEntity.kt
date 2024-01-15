package com.clo.closs.data.local.entities.old

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.clo.closs.domain.model.old.Tasas

// Data Class que representa la tabla de tasas
@Entity(tableName = "tasas")
data class TasasEntity(
    @PrimaryKey val fecha: String,
    @ColumnInfo(name = "fechamodifi") val fechamodifi: String,
    @ColumnInfo(name = "fechayhora") val fechayhora: String,
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "ip") val ip: String,
    @ColumnInfo(name = "tasa") val tasa: Double,
    @ColumnInfo(name = "tasaib") val tasaib: Double,
    @ColumnInfo(name = "usuario") val usuario: String
) {
    // Función de extensión para mapear los datos de la tabla al modelo de dominio
    fun toDomain() = Tasas(
        fecha = fecha,
        fechamodifi = fechamodifi,
        fechayhora = fechayhora,
        id = id,
        ip = ip,
        tasa = tasa,
        tasaib = tasaib,
        usuario = usuario
    )
}
