package com.clo.closs.data.local.dao.old

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.clo.closs.data.local.entities.old.PedidoEntity
import kotlinx.coroutines.flow.Flow

// Data Access Object para pedidos
// Interfaz que tiene las funciones a las que se acceden para hacer consultas a la base de datos
@Dao
interface PedidoDao {

    // Función para actualizar/insertar datos en la tabla de pedidos
    @Upsert
    suspend fun upsertPedido(pedido: List<PedidoEntity>)

    // Función para borrar los datos de la tabla de pedidos
    @Query("DELETE FROM ke_opti")
    suspend fun deletePedido()

    // Función para borrar los datos de la tabla de pedidos que no esten en la nube pero si en la base de datos
    @Query("DELETE FROM ke_opti WHERE ktiNdoc = :documento")
    suspend fun deletePedidoOld(documento: String)

    // Flow para obtener todos los datos de la tabla pedidos
    @Query("SELECT * FROM ke_opti ORDER BY ktiCodven DESC")
    fun getPedido(): Flow<List<PedidoEntity>>

    // Funcion para obtener las pedidos actuales en la base de datos
    @Query("SELECT * FROM ke_opti")
    suspend fun getPedidoOld(): List<PedidoEntity>
}
