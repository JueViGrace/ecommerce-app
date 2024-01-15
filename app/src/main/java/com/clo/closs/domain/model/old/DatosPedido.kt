package com.clo.closs.domain.model.old

import com.clo.closs.data.local.entities.old.DatosPedidoEntity

data class DatosPedido(
    val kmvArtprec: Double = 0.0,
    val kmvCant: Double = 0.0,
    val kmvCodart: String = "",
    val kmvDctolin: Double = 0.0,
    val kmvNombre: String = "",
    val kmvStot: Double = 0.0,
    val ktiNdoc: String = "",
    val ktiTdoc: String = "",
    val ktiTipprec: Double = 0.0
) {
    fun toDatabase() = DatosPedidoEntity(
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
