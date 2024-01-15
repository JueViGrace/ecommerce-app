package com.clo.closs.domain.model.old

import com.clo.closs.data.local.entities.old.VendedorEntity

data class Vendedor(
    val email: String = "",
    val nombre: String = "",
    val sector: String = "",
    val subsector: String = "",
    val supervpor: String = "",
    val telefonoMovil: String = "",
    val telefonos: String = "",
    val ultSinc: String = "",
    val username: String = "",
    val vendedor: String = "",
    val version: String = "",
) {
    fun toDatabase() = VendedorEntity(
        email = email,
        nombre = nombre,
        sector = sector,
        subsector = subsector,
        supervpor = supervpor,
        telefonoMovil = telefonoMovil,
        telefonos = telefonos,
        ultSinc = ultSinc,
        username = username,
        vendedor = vendedor,
        version = version
    )
}
