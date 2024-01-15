package com.clo.closs.domain.model.old

import com.clo.closs.data.local.entities.old.TasasEntity

data class Tasas(
    val fecha: String = "",
    val fechamodifi: String = "",
    val fechayhora: String = "",
    val id: String = "",
    val ip: String = "",
    val tasa: Double = 0.0,
    val tasaib: Double = 0.0,
    val usuario: String = ""
) {
    fun toDatabase() = TasasEntity(
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
