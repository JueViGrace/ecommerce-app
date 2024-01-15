package com.clo.closs.data.local.dao.old

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.clo.closs.data.local.entities.old.GerenciaEntity
import kotlinx.coroutines.flow.Flow

// Data Access Object para gerencias
// Interfaz que tiene las funciones a las que se acceden para hacer consultas a la base de datos
@Dao
interface GerenciaDao {

    // Función para actualizar/insertar datos en la tabla de gerencias
    @Upsert
    suspend fun upsertGerencia(gerencia: List<GerenciaEntity>)

    // Función para borrar los datos de la tabla de gerencias
    @Query("DELETE FROM ke_nivgcia")
    suspend fun deleteGerencia()

    // Flow para obtener todos los datos de la tabla gerencias
    @Query("SELECT * FROM ke_nivgcia ORDER BY kngCodcoord ASC")
    fun getGerencia(): Flow<List<GerenciaEntity>>
}
