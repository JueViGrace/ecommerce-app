package com.clo.closs.data.remote.model.response

// Data Class para manejar los errores de descarga
data class ErrorResponse(
    val messages: List<String?>? = null,
    val message: String? = null,
    val error: String? = null,
    val statusCode: Int? = null
)
