package com.clo.closs.data.local.dao.old

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.clo.closs.data.local.entities.old.VendedorEntity
import kotlinx.coroutines.flow.Flow

// Data Access Object para vendedores
// Interfaz que tiene las funciones a las que se acceden para hacer consultas a la base de datos
@Dao
interface VendedorDao {

    // Función para actualizar/insertar datos en la tabla de vendedores
    @Upsert
    suspend fun upsertVendedor(vendedor: List<VendedorEntity>)

    // Función para borrar los datos de la tabla de vendedores
    @Query("DELETE FROM vendedores")
    suspend fun deleteVendedor()

    // Flow para obtener todos los datos de la tabla vendedores
    @Query("SELECT * FROM vendedores ORDER BY ult_sinc ASC")
    fun getVendedores(): Flow<List<VendedorEntity>>
}
