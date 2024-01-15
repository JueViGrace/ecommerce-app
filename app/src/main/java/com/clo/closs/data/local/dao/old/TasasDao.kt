package com.clo.closs.data.local.dao.old

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.clo.closs.data.local.entities.old.TasasEntity
import kotlinx.coroutines.flow.Flow

// Data Access Object para las tasas
// Interfaz que tiene las funciones a las que se acceden para hacer consultas a la base de datos
@Dao
interface TasasDao {

    // Función para actualizar/insertar datos en la tabla de tasas
    @Upsert
    suspend fun upsertTasa(tasas: List<TasasEntity>)

    // Función para borrar los datos de la tabla de tasas
    @Query("DELETE FROM tasas")
    suspend fun deleteTasas()

    // Flow para obtener todos los datos de la tabla tasas
    @Query("SELECT * FROM tasas")
    fun getTasas(): Flow<List<TasasEntity>>
}
