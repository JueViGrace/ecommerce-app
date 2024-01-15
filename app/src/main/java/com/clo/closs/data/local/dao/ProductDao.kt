package com.clo.closs.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.clo.closs.data.local.entities.ProductEntity

// Data Access Object de artículos
// Interfaz que tiene las funciones a las que se acceden para hacer consultas a la base de datos
@Dao
interface ProductDao {

    // Función para actualizar/insertar datos en la tabla de artículos
    @Upsert
    suspend fun upsertProduct(articulo: List<ProductEntity>)

    // Función para eliminar los datos en la tabla de artículos
    @Query("DELETE FROM articulo")
    suspend fun deteleProduct()

    // Función para seleccionar todos los datos de la tabla de artículos
    // que su existencia sea mayor a cero
    @Query("SELECT * FROM articulo WHERE (existencia - comprometido) > 0")
    suspend fun getProducts(): List<ProductEntity>

    @Query("SELECT * FROM articulo WHERE codigo LIKE :query OR nombre LIKE :query or referencia LIKE :query")
    fun searchProduct(query: String): List<ProductEntity>
}
