package com.clo.closs.data.local.entities.old

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.clo.closs.domain.model.old.DatosFactura

// Data Class que representa la tabla de datos factura
@Entity(tableName = "ke_doclmv", primaryKeys = ["documento", "codigo"])
data class DatosFacturasEntity(
    @ColumnInfo(name = "agencia") val agencia: String,
    @ColumnInfo(name = "cantidad") val cantidad: Double,
    @ColumnInfo(name = "cntdevuelt") val cntdevuelt: Double,
    @ColumnInfo(name = "codcoord") val codcoord: String,
    @ColumnInfo(name = "codhijo") val codhijo: String,
    @ColumnInfo(name = "codigo") val codigo: String,
    @ColumnInfo(name = "dmontoneto") val dmontoneto: Double,
    @ColumnInfo(name = "dmontototal") val dmontototal: Double,
    @ColumnInfo(name = "documento") val documento: String,
    @ColumnInfo(name = "dpreciofin") val dpreciofin: Double,
    @ColumnInfo(name = "dpreciounit") val dpreciounit: Double,
    @ColumnInfo(name = "dvndmtototal") val dvndmtototal: Double,
    @ColumnInfo(name = "fechadoc") val fechadoc: String,
    @ColumnInfo(name = "fechamodifi") val fechamodifi: String,
    @ColumnInfo(name = "grupo") val grupo: String,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "origen") val origen: Double,
    @ColumnInfo(name = "pid") val pid: String,
    @ColumnInfo(name = "subgrupo") val subgrupo: String,
    @ColumnInfo(name = "timpueprc") val timpueprc: Double,
    @ColumnInfo(name = "tipodoc") val tipodoc: String,
    @ColumnInfo(name = "tipodocv") val tipodocv: String,
    @ColumnInfo(name = "unidevuelt") val unidevuelt: Double,
    @ColumnInfo(name = "vendedor") val vendedor: String,
    @ColumnInfo(name = "vndcntdevuelt") val vndcntdevuelt: Double
) {
    // Función de extensión para mapear los datos de la tabla al modelo de dominio
    fun toDomain() = DatosFactura(
        agencia = agencia,
        cantidad = cantidad,
        cntdevuelt = cntdevuelt,
        codcoord = codcoord,
        codhijo = codhijo,
        codigo = codigo,
        dmontoneto = dmontoneto,
        dmontototal = dmontototal,
        documento = documento,
        dpreciofin = dpreciofin,
        dpreciounit = dpreciounit,
        dvndmtototal = dvndmtototal,
        fechadoc = fechadoc,
        fechamodifi = fechamodifi,
        grupo = grupo,
        nombre = nombre,
        origen = origen,
        pid = pid,
        subgrupo = subgrupo,
        timpueprc = timpueprc,
        tipodoc = tipodoc,
        tipodocv = tipodocv,
        unidevuelt = unidevuelt,
        vendedor = vendedor,
        vndcntdevuelt = vndcntdevuelt
    )
}
