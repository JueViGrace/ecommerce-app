package com.clo.closs.domain.usecase

import com.clo.closs.common.Resource
import com.clo.closs.di.IoDispatcher
import com.clo.closs.domain.model.Product
import com.clo.closs.domain.repository.MainRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetProductsFromApi @Inject constructor(
    private val repository: MainRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    operator fun invoke(): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading())
        repository.getProductsFromApi().catch { err ->
            emit(Resource.Error(message = err.message, data = emptyList()))
        }
            .collect { resource ->
                if (resource.data != null) {
                    repository.deleteProduct()
                    repository.upsertProduct(resource.data)
                    emit(Resource.Success(data = resource.data))
                }
            }
    }.flowOn(ioDispatcher)
}
