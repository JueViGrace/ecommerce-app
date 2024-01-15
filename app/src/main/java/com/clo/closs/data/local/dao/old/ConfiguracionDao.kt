package com.clo.closs.data.local.dao.old

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.clo.closs.data.local.entities.old.ConfiguracionEntity
import kotlinx.coroutines.flow.Flow

// Data Access Object para configuración
// Interfaz que tiene las funciones a las que se acceden para hacer consultas a la base de datos
@Dao
interface ConfiguracionDao {

    // Función para actualizar/insertar datos en la tabla de configuración
    @Upsert
    suspend fun upsertConfig(config: List<ConfiguracionEntity>)

    // Función para borrar los datos de la tabla de configuración
    @Query("DELETE FROM configuracion")
    suspend fun deleteConfig()

    // Función que selecciona el campo de la configuración
    // según la id de la configuración y si esta activa (numérico)
    @Query("SELECT cnfgValnum FROM configuracion WHERE cnfgIdconfig = :key and cnfgActiva = '1'")
    fun getConfigNum(key: String): Flow<Double>

    // Función que selecciona el campo de la configuración
    // según la id de la configuración y si esta activa (Booleano)
    @Query("SELECT cnfgValsino FROM configuracion WHERE cnfgIdconfig = :key and cnfgActiva = '1'")
    fun getConfigBool(key: String): Flow<Double>

    // Función que selecciona el campo de la configuración
    // según la id de la configuración y si esta activa (Text)
    @Query("SELECT cnfgValtxt FROM configuracion WHERE cnfgIdconfig = :key and cnfgActiva = '1'")
    fun getConfigText(key: String): Flow<String>

    // Función que selecciona el campo de la configuración
    // según la id de la configuración y si esta activa (Fecha)
    @Query("SELECT cnfgValfch FROM configuracion WHERE cnfgIdconfig = :key and cnfgActiva = '1'")
    fun getConfigDate(key: String): Flow<String>
}
