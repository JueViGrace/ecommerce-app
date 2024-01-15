package com.clo.closs.data.local.dao.old

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.clo.closs.data.local.entities.old.EstadisticaEntity

// Data Access Object para estadísticas
// Interfaz que tiene las funciones a las que se acceden para hacer consultas a la base de datos
@Dao
interface EstadisticaDao {

    // Función para actualizar/insertar datos en la tabla de estadísticas
    @Upsert
    suspend fun upsertEstadistica(estadistica: List<EstadisticaEntity>)

    // Función para borrar los datos de la tabla de estadísticas
    @Query("DELETE FROM ke_estadc01")
    suspend fun deleteEstadistica()
}
