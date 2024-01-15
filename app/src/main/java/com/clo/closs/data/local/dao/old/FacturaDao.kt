package com.clo.closs.data.local.dao.old

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.clo.closs.data.local.entities.old.FacturaEntity
import kotlinx.coroutines.flow.Flow

// Data Access Object para facturas
// Interfaz que tiene las funciones a las que se acceden para hacer consultas a la base de datos
@Dao
interface FacturaDao {

    // Función para actualizar/insertar datos en la tabla de facturas
    @Upsert
    suspend fun upsertFactura(factura: List<FacturaEntity>)

    // Función para borrar los datos de la tabla de facturas
    @Query("DELETE FROM ke_doccti")
    suspend fun deleteFactura()

    // Función para borrar los datos de la tabla de facturas que no esten en la nube pero si en la base de datos
    @Query("DELETE FROM ke_doccti WHERE documento = :documento")
    suspend fun deleteFacturaOld(documento: String)

    // Flow para obtener todos los datos de la tabla facturas
    @Query("SELECT * FROM ke_doccti ORDER BY vence DESC")
    fun getFactura(): Flow<List<FacturaEntity>>

    // Funcion para obtener las facturas actuales en la base de datos
    @Query("SELECT * FROM ke_doccti ORDER BY documento DESC")
    suspend fun getFacturaOld(): List<FacturaEntity>
}
