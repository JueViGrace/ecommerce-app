package com.clo.closs.data.local.dao.old

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.clo.closs.data.local.entities.old.ImagenEntity
import kotlinx.coroutines.flow.Flow

// Data Access Object para imágenes
// Interfaz que tiene las funciones a las que se acceden para hacer consultas a la base de datos
@Dao
interface ImagenDao {

    // Función para actualizar/insertar datos en la tabla de imágenes
    @Upsert
    suspend fun upsertImagen(imagen: List<ImagenEntity>)

    // Función para borrar los datos de la tabla de imágenes
    @Query("DELETE FROM imagenes")
    suspend fun deleteImagenes()

    // Flow para obtener todos los datos de la tabla imágenes
    @Query("SELECT * FROM imagenes")
    fun getImagenes(): Flow<List<ImagenEntity>>

    // Función para borrar los datos de la tabla de imágenes que no esten en la nube pero si en la base de datos
    @Query("DELETE FROM imagenes WHERE enlace = :img")
    suspend fun deleteImgOld(img: String)
}
