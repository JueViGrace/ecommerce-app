package com.clo.closs.presentation.product.state

data class DataState<T>(
    val loading: Boolean = true,
    val error: String? = "",
    val success: T? = null
)
