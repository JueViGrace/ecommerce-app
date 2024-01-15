package com.clo.closs.domain.model.old

import com.clo.closs.data.local.entities.old.ImagenEntity

data class Imagen(
    val enlace: String = "",
    val fechamodifi: String = "",
    val nombre: String = ""
) {
    fun toDatabase() = ImagenEntity(
        enlace = enlace,
        fechamodifi = fechamodifi,
        nombre = nombre
    )
}
