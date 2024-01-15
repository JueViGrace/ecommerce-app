package com.clo.closs.data.remote.model.response

import com.clo.closs.domain.model.Product
import com.google.gson.annotations.SerializedName

data class ProductResponse(

    @field:SerializedName("products")
    val productResponse: List<ProductResponseItem?>? = null
)

data class ProductResponseItem(

    @field:SerializedName("enpreventa")
    val enpreventa: String? = null,

    @field:SerializedName("vta_solofac")
    val vtaSolofac: Int? = null,

    @field:SerializedName("grupo")
    val grupo: String? = null,

    @field:SerializedName("nombre")
    val nombre: String? = null,

    @field:SerializedName("existencia")
    val existencia: Int? = null,

    @field:SerializedName("marca")
    val marca: String? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("productImage")
    val productImage: String? = null,

    @field:SerializedName("comprometido")
    val comprometido: Int? = null,

    @field:SerializedName("subgrupo")
    val subgrupo: String? = null,

    @field:SerializedName("vta_solone")
    val vtaSolone: Int? = null,

    @field:SerializedName("vta_max")
    val vtaMax: Int? = null,

    @field:SerializedName("discont")
    val discont: Int? = null,

    @field:SerializedName("vta_minenx")
    val vtaMinenx: Int? = null,

    @field:SerializedName("codigo")
    val codigo: String? = null,

    @field:SerializedName("vta_min")
    val vtaMin: Int? = null,

    @field:SerializedName("dctotope")
    val dctotope: Double? = null,

    @field:SerializedName("precio1")
    val precio1: Double? = null,

    @field:SerializedName("precio2")
    val precio2: Double? = null,

    @field:SerializedName("precio3")
    val precio3: Double? = null,

    @field:SerializedName("precio4")
    val precio4: Double? = null,

    @field:SerializedName("precio5")
    val precio5: Double? = null,

    @field:SerializedName("precio6")
    val precio6: Double? = null,

    @field:SerializedName("precio7")
    val precio7: Double? = null,

    @field:SerializedName("unidad")
    val unidad: String? = null,

    @field:SerializedName("deletedAt")
    val deletedAt: String? = null,

    @field:SerializedName("fechamodifi")
    val fechamodifi: String? = null,

    @field:SerializedName("referencia")
    val referencia: String? = null
) {
    fun toDomain() = Product(
        enpreventa = enpreventa ?: "",
        vtaSolofac = vtaSolofac ?: 0,
        grupo = grupo ?: "",
        nombre = nombre ?: "",
        existencia = existencia ?: 0,
        marca = marca ?: "",
        createdAt = createdAt ?: "",
        productImage = productImage ?: "",
        comprometido = comprometido ?: 0,
        subgrupo = subgrupo ?: "",
        vtaSolone = vtaSolone ?: 0,
        vtaMax = vtaMax ?: 0,
        discont = discont ?: 0,
        vtaMinenx = vtaMinenx ?: 0,
        codigo = codigo ?: "",
        vtaMin = vtaMin ?: 0,
        dctotope = dctotope ?: 0.0,
        precio1 = precio1 ?: 0.0,
        precio2 = precio2 ?: 0.0,
        precio3 = precio3 ?: 0.0,
        precio4 = precio4 ?: 0.0,
        precio5 = precio5 ?: 0.0,
        precio6 = precio6 ?: 0.0,
        precio7 = precio7 ?: 0.0,
        unidad = unidad ?: "",
        deletedAt = deletedAt ?: "",
        fechamodifi = fechamodifi ?: "",
        referencia = referencia ?: "",
    )
}
