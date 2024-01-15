package com.clo.closs.data.remote.service

import com.clo.closs.common.Resource
import com.clo.closs.data.remote.api.Api
import com.clo.closs.data.sources.RemoteDataSource
import com.clo.closs.di.IoDispatcher
import com.clo.closs.domain.model.Auth
import com.clo.closs.domain.model.Product
import com.clo.closs.domain.model.auth.Login
import com.clo.closs.domain.model.auth.Register
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiService @Inject constructor(
    private val api: Api,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteDataSource {
    override fun register(register: Register): Flow<Resource<Auth>> = flow {
        emit(Resource.Loading())
        when (val response = api.register(register.toServer())) {
            is NetworkResponse.Success -> {
                emit(
                    Resource.Success(
                        data = response.body.toDomain()
                    )
                )
            }

            is NetworkResponse.ServerError -> {
                val index = response.body?.messages?.size ?: 0
                emit(
                    Resource.Error(
                        message = response.body?.messages?.get(index) ?: response.body?.message
                            ?: "Inténtalo de nuevo más tarde",
                    )
                )
            }

            is NetworkResponse.NetworkError -> {
                val index = response.body?.messages?.size ?: 0
                emit(
                    Resource.Error(
                        message = response.body?.messages?.get(index) ?: response.body?.message
                            ?: "Inténtalo de nuevo más tarde"
                    )
                )
            }

            is NetworkResponse.UnknownError -> {
                val index = response.body?.messages?.size ?: 0
                emit(
                    Resource.Error(
                        message = response.body?.messages?.get(index) ?: response.body?.message
                            ?: "Inténtalo de nuevo más tarde"
                    )
                )
            }
        }
    }.flowOn(ioDispatcher)

    override fun login(login: Login): Flow<Resource<Auth>> = flow {
        emit(Resource.Loading())
        when (val response = api.login(login.toServer())) {
            is NetworkResponse.Success -> {
                emit(
                    Resource.Success(
                        data = response.body.toDomain()
                    )
                )
            }

            is NetworkResponse.ServerError -> {
                val index = response.body?.messages?.size ?: 0
                emit(
                    Resource.Error(
                        message = response.body?.messages?.get(index) ?: response.body?.message
                            ?: "Inténtalo de nuevo más tarde",
                    )
                )
            }

            is NetworkResponse.NetworkError -> {
                val index = response.body?.messages?.size ?: 0
                emit(
                    Resource.Error(
                        message = response.body?.messages?.get(index) ?: response.body?.message
                            ?: "Inténtalo de nuevo más tarde"
                    )
                )
            }

            is NetworkResponse.UnknownError -> {
                val index = response.body?.messages?.size ?: 0
                emit(
                    Resource.Error(
                        message = response.body?.messages?.get(index) ?: response.body?.message
                            ?: "Inténtalo de nuevo más tarde"
                    )
                )
            }
        }
    }.flowOn(ioDispatcher)

    override fun getProductsFromApi(): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading())
        when (val response = api.getProducts()) {
            is NetworkResponse.Success -> {
                emit(
                    Resource.Success(
                        data = response.body.productResponse?.map { productResponseItem ->
                            productResponseItem?.toDomain() ?: Product()
                        }
                    )
                )
            }

            is NetworkResponse.ServerError -> {
                emit(
                    Resource.Error(
                        message = response.body?.message ?: "Inténtalo de nuevo más tarde",
                    )
                )
            }

            is NetworkResponse.NetworkError -> {
                emit(
                    Resource.Error(
                        message = response.body?.message ?: "Inténtalo de nuevo más tarde"
                    )
                )
            }

            is NetworkResponse.UnknownError -> {
                emit(
                    Resource.Error(
                        message = response.body?.message ?: "Inténtalo de nuevo más tarde"
                    )
                )
            }
        }
    }.flowOn(ioDispatcher)
}
