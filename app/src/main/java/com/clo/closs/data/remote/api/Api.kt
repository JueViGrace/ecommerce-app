package com.clo.closs.data.remote.api

import com.clo.closs.data.remote.model.auth.LoginDto
import com.clo.closs.data.remote.model.auth.RegisterDto
import com.clo.closs.data.remote.model.response.AuthResponse
import com.clo.closs.data.remote.model.response.CategoryResponse
import com.clo.closs.data.remote.model.response.ErrorResponse
import com.clo.closs.data.remote.model.response.ProductResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @POST("auth/register")
    suspend fun register(
        @Body registerDto: RegisterDto
    ): NetworkResponse<AuthResponse, ErrorResponse>

    @POST("auth/login")
    suspend fun login(
        @Body loginDto: LoginDto
    ): NetworkResponse<AuthResponse, ErrorResponse>

    @GET("products")
    suspend fun getProducts(): NetworkResponse<ProductResponse, ErrorResponse>

    @GET("categories")
    suspend fun getCategories(): NetworkResponse<CategoryResponse, ErrorResponse>


}
