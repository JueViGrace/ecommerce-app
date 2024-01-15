package com.clo.closs.domain.usecase

import com.clo.closs.common.Resource
import com.clo.closs.di.IoDispatcher
import com.clo.closs.domain.model.Product
import com.clo.closs.domain.repository.MainRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetProducts @Inject constructor(
    private val repository: MainRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    operator fun invoke(): Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading())
            val products = repository.getProducts()

            emit(Resource.Success(data = products))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message, data = emptyList()))
        }
    }.flowOn(ioDispatcher)
}
