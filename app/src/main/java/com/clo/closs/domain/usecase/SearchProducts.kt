package com.clo.closs.domain.usecase

import com.clo.closs.common.Resource
import com.clo.closs.common.toLikeSearchable
import com.clo.closs.di.IoDispatcher
import com.clo.closs.domain.model.Product
import com.clo.closs.domain.repository.MainRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SearchProducts @Inject constructor(
    private val repository: MainRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    operator fun invoke(query: String): Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading())
            val products = repository.searchProducts(query.toLikeSearchable())

            emit(Resource.Success(data = products))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message, data = emptyList()))
        }
    }.flowOn(ioDispatcher)
}