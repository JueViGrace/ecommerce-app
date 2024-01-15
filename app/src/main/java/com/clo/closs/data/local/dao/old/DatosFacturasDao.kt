package com.clo.closs.data.local.dao.old

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.clo.closs.data.local.entities.old.DatosFacturasEntity
import kotlinx.coroutines.flow.Flow

// Data Access Object para las líneas de las facturas
// Interfaz que tiene las funciones a las que se acceden para hacer consultas a la base de datos
@Dao
interface DatosFacturasDao {

    // Función para actualizar/insertar datos en la tabla de datos facturas
    @Upsert
    suspend fun upsertDatosFacturas(datosFacturas: List<DatosFacturasEntity>)

    // Función para borrar los datos de la tabla de las líneas de las facturas
    @Query("DELETE FROM ke_doclmv")
    suspend fun deleteDatosFacturas()

    // Función para obtener las lineas de las facturas por cada documento
    @Query("SELECT * FROM ke_doclmv WHERE documento = :documento ORDER BY codigo")
    fun getDatosFacturaPDocumento(documento: String): Flow<List<DatosFacturasEntity>>
}
