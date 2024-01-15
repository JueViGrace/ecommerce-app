package com.clo.closs.data.sources

import com.clo.closs.common.Resource
import com.clo.closs.domain.model.Auth
import com.clo.closs.domain.model.Product
import com.clo.closs.domain.model.auth.Login
import com.clo.closs.domain.model.auth.Register
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun register(register: Register): Flow<Resource<Auth>>
    fun login(login: Login): Flow<Resource<Auth>>

    fun getProductsFromApi(): Flow<Resource<List<Product>>>
}
