package com.clo.closs.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.clo.closs.data.local.entities.UserEntity
import kotlinx.coroutines.flow.Flow

// Data Access Object para usuario
// Interfaz que tiene las funciones a las que se acceden para hacer consultas a la base de datos
@Dao
interface UserDao {
    // Función para insertar/actualizar los datos de la tabla usuario
    @Upsert
    suspend fun upsertUser(users: UserEntity)

    // Función para borrar los datos de la tabla usuario
    @Query("DELETE FROM usuario")
    suspend fun deleteUser()

    // Función para actualizar la fecha de sincronización
    @Query("UPDATE usuario SET ultSinc = :fecha")
    suspend fun updateFechaSinc(fecha: String)

    // Flow para obtener todos los datos de la tabla usuario
    @Query("SELECT * FROM usuario")
    fun getUser(): Flow<List<UserEntity>>

    @Query("SELECT sesion FROM usuario")
    suspend fun getUserSession(): Boolean?
}
