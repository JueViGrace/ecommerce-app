package com.clo.closs.data.sources

import com.clo.closs.domain.model.Product
import com.clo.closs.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    // Funciones para Usuarios
    suspend fun upsertUser(user: User)
    suspend fun deleteUser()
    fun getUser(): Flow<List<User>>
    suspend fun getUserSession(): Boolean

    // Funciones para Artículos
    suspend fun upsertProduct(productList: List<Product>)
    suspend fun deleteProduct()
    suspend fun getProducts(): List<Product>
    fun searchProducts(query: String): List<Product>
}
