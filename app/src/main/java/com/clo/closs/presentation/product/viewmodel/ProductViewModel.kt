package com.clo.closs.presentation.product.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clo.closs.common.Resource
import com.clo.closs.domain.model.Product
import com.clo.closs.domain.usecase.GetProducts
import com.clo.closs.domain.usecase.GetProductsFromApi
import com.clo.closs.domain.usecase.SearchProducts
import com.clo.closs.presentation.main.events.SearchEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsFromApiUseCase: GetProductsFromApi,
    private val getProductsUseCase: GetProducts,
    private val searchProductsUseCase: SearchProducts
) : ViewModel() {
    private val _state = MutableStateFlow<Resource<List<Product>>>(Resource.Loading())
    val state: StateFlow<Resource<List<Product>>> = _state

    init {
        getProductsFromApi()
        getProducts()
    }

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.SearchQuery -> {
                searchProducts(event.query)
            }
        }
    }

    private fun getProductsFromApi() {
        getProductsFromApiUseCase().onEach { resource ->
            when (resource) {
                is Resource.Error -> Log.d("products", "getProductsFromApi: Error: ${resource.message}")
                is Resource.Loading -> Log.d("products", "getProductsFromApi: Loading")
                is Resource.Success -> {
                    if (resource.data != null) {
                        Log.d("products", "getProductsFromApi: Success")
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getProducts() {
        getProductsUseCase().onEach { resource ->
            when (resource) {
                is Resource.Error -> _state.value = Resource.Error(
                    message = resource.message ?: "No se encontraron productos",
                )
                is Resource.Loading -> _state.value = Resource.Loading()
                is Resource.Success -> {
                    if (resource.data != null) {
                        _state.value = Resource.Success(data = resource.data)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun searchProducts(query: String) {
        searchProductsUseCase(query).onEach { resource: Resource<List<Product>> ->
            when (resource) {
                is Resource.Error -> _state.value = Resource.Error(
                    message = resource.message ?: "No se encontraron productos",
                    data = resource.data
                )
                is Resource.Loading -> _state.value = Resource.Loading()
                is Resource.Success -> {
                    if (resource.data != null) {
                        _state.value = Resource.Success(data = resource.data)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    /*private fun getProducts() {
        getProductsUseCase().onEach { resource ->
            when (resource) {
                is Resource.Error -> _state.value = _state.value.copy(loading = false, error = resource.message)
                is Resource.Loading -> _state.value = _state.value.copy(loading = true)
                is Resource.Success -> {
                    if (resource.data != null) {
                        _state.value = _state.value.copy(loading = false, success = resource.data)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }*/
}
