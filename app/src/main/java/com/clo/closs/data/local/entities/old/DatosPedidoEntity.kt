package com.clo.closs.data.local.entities.old

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.clo.closs.domain.model.old.DatosPedido

// Data Class que representa la tabla de datos pedido
@Entity(tableName = "ke_opmv", primaryKeys = ["ktiNdoc", "kmvCodart"])
data class DatosPedidoEntity(
    @ColumnInfo(name = "kmvArtprec") val kmvArtprec: Double,
    @ColumnInfo(name = "kmvCant") val kmvCant: Double,
    @ColumnInfo(name = "kmvCodart") val kmvCodart: String,
    @ColumnInfo(name = "kmvDctolin") val kmvDctolin: Double,
    @ColumnInfo(name = "kmvNombre") val kmvNombre: String,
    @ColumnInfo(name = "kmvStot") val kmvStot: Double,
    @ColumnInfo(name = "ktiNdoc") val ktiNdoc: String,
    @ColumnInfo(name = "ktiTdoc") val ktiTdoc: String,
    @ColumnInfo(name = "ktiTipprec") val ktiTipprec: Double
) {
    // Función de extensión para mapear los datos de la tabla al modelo de dominio
    fun toDomain() = DatosPedido(
        kmvArtprec = kmvArtprec,
        kmvCant = kmvCant,
        kmvCodart = kmvCodart,
        kmvDctolin = kmvDctolin,
        kmvNombre = kmvNombre,
        kmvStot = kmvStot,
        ktiNdoc = ktiNdoc,
        ktiTdoc = ktiTdoc,
        ktiTipprec = ktiTipprec
    )
}
