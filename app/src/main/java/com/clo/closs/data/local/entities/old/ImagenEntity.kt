package com.clo.closs.data.local.entities.old

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.clo.closs.domain.model.old.Imagen

// Data Class que representa la tabla de imágenes
@Entity(tableName = "imagenes")
data class ImagenEntity(
    @PrimaryKey val enlace: String,
    @ColumnInfo(name = "fechamodifi") val fechamodifi: String,
    @ColumnInfo(name = "nombre") val nombre: String
) {
    // Función de extensión para mapear los datos de la tabla al modelo de dominio
    fun toDomain() = Imagen(
        enlace = enlace,
        fechamodifi = fechamodifi,
        nombre = nombre
    )
}
