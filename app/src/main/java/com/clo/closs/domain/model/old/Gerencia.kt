package com.clo.closs.domain.model.old

import com.clo.closs.data.local.entities.old.GerenciaEntity

data class Gerencia(
    val fechamodifi: String = "",
    val kngCodcoord: String = "",
    val kngCodgcia: String = ""
) {
    fun toDatabase() = GerenciaEntity(
        fechamodifi = fechamodifi,
        kngCodcoord = kngCodcoord,
        kngCodgcia = kngCodgcia
    )
}
