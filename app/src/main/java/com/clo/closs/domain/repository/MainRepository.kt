package com.clo.closs.domain.repository

import com.clo.closs.common.Resource
import com.clo.closs.data.sources.LocalDataSource
import com.clo.closs.data.sources.PreferencesSource
import com.clo.closs.data.sources.RemoteDataSource
import com.clo.closs.domain.model.Auth
import com.clo.closs.domain.model.Product
import com.clo.closs.domain.model.User
import com.clo.closs.domain.model.auth.Login
import com.clo.closs.domain.model.auth.Register
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val preferencesSource: PreferencesSource
) {
    fun register(register: Register): Flow<Resource<Auth>> = remoteDataSource.register(register)
    fun login(login: Login): Flow<Resource<Auth>> = remoteDataSource.login(login)
    fun getProductsFromApi(): Flow<Resource<List<Product>>> = remoteDataSource.getProductsFromApi()

    suspend fun saveStringPreference(key: String, value: String) = preferencesSource.saveStringPreference(key, value)
    suspend fun getStringPreference(key: String) = preferencesSource.getStringPreference(key)
    suspend fun saveBooleanPreference(key: String, value: Boolean) = preferencesSource.saveBooleanPreference(key, value)
    suspend fun getBooleanPreference(key: String) = preferencesSource.getBooleanPreference(key)
    suspend fun clearPreferences(key: String) = preferencesSource.clearPreferences(key)

    suspend fun upsertUser(user: User) = localDataSource.upsertUser(user)
    suspend fun deleteUser() = localDataSource.deleteUser()
    fun getUser(): Flow<List<User>> = localDataSource.getUser()
    suspend fun getUserSession(): Boolean = localDataSource.getUserSession()

    suspend fun upsertProduct(productList: List<Product>) = localDataSource.upsertProduct(productList)
    suspend fun deleteProduct() = localDataSource.deleteProduct()
    suspend fun getProducts(): List<Product> = localDataSource.getProducts()
    fun searchProducts(query: String) = localDataSource.searchProducts(query)
}
