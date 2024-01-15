package com.clo.closs.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.clo.closs.domain.model.Product

// Data Class que representa la tabla de artículos
@Entity(tableName = "articulo")
data class ProductEntity(
    @PrimaryKey val codigo: String,
    @ColumnInfo(name = "enpreventa") val enpreventa: String,
    @ColumnInfo(name = "vtaSolofac") val vtaSolofac: Int,
    @ColumnInfo(name = "grupo") val grupo: String,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "existencia") val existencia: Int,
    @ColumnInfo(name = "marca") val marca: String,
    @ColumnInfo(name = "createdAt") val createdAt: String,
    @ColumnInfo(name = "productImage") val productImage: String,
    @ColumnInfo(name = "comprometido") val comprometido: Int,
    @ColumnInfo(name = "subgrupo") val subgrupo: String,
    @ColumnInfo(name = "vtaSolone") val vtaSolone: Int,
    @ColumnInfo(name = "vtaMax") val vtaMax: Int,
    @ColumnInfo(name = "discont") val discont: Int,
    @ColumnInfo(name = "vtaMinenx") val vtaMinenx: Int,
    @ColumnInfo(name = "vtaMin") val vtaMin: Int,
    @ColumnInfo(name = "dctotope") val dctotope: Double,
    @ColumnInfo(name = "precio1") val precio1: Double,
    @ColumnInfo(name = "precio2") val precio2: Double,
    @ColumnInfo(name = "precio3") val precio3: Double,
    @ColumnInfo(name = "precio4") val precio4: Double,
    @ColumnInfo(name = "precio5") val precio5: Double,
    @ColumnInfo(name = "precio6") val precio6: Double,
    @ColumnInfo(name = "precio7") val precio7: Double,
    @ColumnInfo(name = "unidad") val unidad: String,
    @ColumnInfo(name = "deletedAt") val deletedAt: String?,
    @ColumnInfo(name = "fechamodifi") val fechamodifi: String,
    @ColumnInfo(name = "referencia") val referencia: String,
) {
    // Función de extensión para mapear los datos de la tabla al modelo de dominio
    fun toDomain() = Product(
        enpreventa = enpreventa,
        vtaSolofac = vtaSolofac,
        grupo = grupo,
        nombre = nombre,
        existencia = existencia,
        marca = marca,
        createdAt = createdAt,
        productImage = productImage,
        comprometido = comprometido,
        subgrupo = subgrupo,
        vtaSolone = vtaSolone,
        vtaMax = vtaMax,
        discont = discont,
        vtaMinenx = vtaMinenx,
        codigo = codigo,
        vtaMin = vtaMin,
        dctotope = dctotope,
        precio1 = precio1,
        precio2 = precio2,
        precio3 = precio3,
        precio4 = precio4,
        precio5 = precio5,
        precio6 = precio6,
        precio7 = precio7,
        unidad = unidad,
        deletedAt = deletedAt,
        fechamodifi = fechamodifi,
        referencia = referencia,
    )
}
