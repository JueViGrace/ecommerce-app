package com.clo.closs.data.local.dao.old

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.clo.closs.data.local.entities.old.DatosPedidoEntity
import kotlinx.coroutines.flow.Flow

// Data Access Object para las líneas de las pedidos
// Interfaz que tiene las funciones a las que se acceden para hacer consultas a la base de datos
@Dao
interface DatosPedidoDao {

    // Función para actualizar/insertar datos en la tabla de datos pedidos
    @Upsert
    suspend fun upsertDatosPedido(datosPedido: List<DatosPedidoEntity>)

    // Función para borrar los datos de la tabla de las líneas de los pedidos
    @Query("DELETE FROM ke_opmv")
    suspend fun deleteDatosPedido()

    // Función para obtener las líneas de las pedidos por cada documento
    @Query("SELECT * FROM ke_opmv WHERE ktiNdoc = :documento")
    fun getDatosPedidoPDocumento(documento: String): Flow<List<DatosPedidoEntity>>
}
