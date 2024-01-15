package com.clo.closs.domain.model.old

import com.clo.closs.data.local.entities.old.PedidoEntity

data class Pedido(
    val fechamodifi: String = "",
    val kePedstatus: String = "",
    val ktiCodcli: String = "",
    val ktiCodven: String = "",
    val ktiCondicion: String = "",
    val ktiDocsol: String = "",
    val ktiFchdoc: String = "",
    val ktiNdoc: String = "",
    val ktiNegesp: String = "",
    val ktiNombrecli: String = "",
    val ktiNroped: String = "",
    val ktiStatus: String = "",
    val ktiTdoc: String = "",
    val ktiTipprec: Double = 0.0,
    val ktiTotneto: Double = 0.0
) {
    fun toDatabase() = PedidoEntity(
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
