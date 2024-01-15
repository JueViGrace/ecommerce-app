package com.clo.closs.data.local.dao.old

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.clo.closs.data.local.entities.old.ClienteEntity
import kotlinx.coroutines.flow.Flow

// Data Access Object para clientes
// Interfaz que tiene las funciones a las que se acceden para hacer consultas a la base de datos
@Dao
interface ClienteDao {

    // Función para actualizar/insertar datos en la tabla de clientes
    @Upsert
    suspend fun upsertCliente(cliente: List<ClienteEntity>)

    // Función para borrar los datos de la tabla de clientes
    @Query("DELETE FROM cliempre")
    suspend fun deleteCliente()

    // Flow para obtener un cliente por codigo
    @Query("SELECT * FROM cliempre WHERE codigo = :codigo")
    fun getCliente(codigo: String): Flow<ClienteEntity>
}
