package com.clo.closs.data.local.entities.old

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.clo.closs.domain.model.old.Pedido

// Data Class que representa la tabla de pedidos
@Entity(tableName = "ke_opti", indices = [Index(value = ["ktiCodcli"])])
data class PedidoEntity(
    @ColumnInfo(name = "fechamodifi") val fechamodifi: String,
    @ColumnInfo(name = "kePedstatus") val kePedstatus: String,
    @ColumnInfo(name = "ktiCodcli") val ktiCodcli: String,
    @ColumnInfo(name = "ktiCodven") val ktiCodven: String,
    @ColumnInfo(name = "ktiCondicion") val ktiCondicion: String,
    @ColumnInfo(name = "ktiDocsol") val ktiDocsol: String,
    @ColumnInfo(name = "ktiFchdoc") val ktiFchdoc: String,
    @PrimaryKey val ktiNdoc: String,
    @ColumnInfo(name = "ktiNegesp") val ktiNegesp: String,
    @ColumnInfo(name = "ktiNombrecli") val ktiNombrecli: String,
    @ColumnInfo(name = "ktiNroped") val ktiNroped: String,
    @ColumnInfo(name = "ktiStatus") val ktiStatus: String,
    @ColumnInfo(name = "ktiTdoc") val ktiTdoc: String,
    @ColumnInfo(name = "ktiTipprec") val ktiTipprec: Double,
    @ColumnInfo(name = "ktiTotneto") val ktiTotneto: Double
) {
    // Función de extensión para mapear los datos de la tabla al modelo de dominio
    fun toDomain() = Pedido(
        fechamodifi = fechamodifi,
        kePedstatus = kePedstatus,
        ktiCodcli = ktiCodcli,
        ktiCodven = ktiCodven,
        ktiCondicion = ktiCondicion,
        ktiDocsol = ktiDocsol,
        ktiFchdoc = ktiFchdoc,
        ktiNdoc = ktiNdoc,
        ktiNegesp = ktiNegesp,
        ktiNombrecli = ktiNombrecli,
        ktiNroped = ktiNroped,
        ktiStatus = ktiStatus,
        ktiTdoc = ktiTdoc,
        ktiTipprec = ktiTipprec,
        ktiTotneto = ktiTotneto
    )
}
