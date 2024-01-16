package com.clo.closs.presentation.product.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.clo.closs.common.Resource
import com.clo.closs.domain.model.Product
import com.clo.closs.presentation.components.AppBar
import com.clo.closs.presentation.components.ErrorScreen
import com.clo.closs.presentation.main.events.SearchEvent
import com.clo.closs.presentation.product.ui.components.ProductComponent
import com.clo.closs.presentation.product.viewmodel.ProductViewModel

@Composable
fun ProductScreen(
    productViewModel: ProductViewModel = hiltViewModel(),
    navigateToDetails: (String) -> Unit,
    navigateToCart: () -> Unit
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val uiState by produceState<Resource<List<Product>>>(
        initialValue = Resource.Loading(),
        key1 = lifecycle,
        key2 = productViewModel
    ) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            productViewModel.state.collect { value = it }
        }
    }

    val event = productViewModel::onEvent

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (appBar, productList) = createRefs()

        AppBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 5.dp)
                .constrainAs(appBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            searchSequence = {
                event(SearchEvent.SearchQuery(it))
            },
            onCartIconClick = {
                navigateToCart()
            }
        )
        when (uiState) {
            is Resource.Error -> {
                ErrorScreen(uiState.message ?: "No se encontraron productos")
            }

            is Resource.Loading -> {
                // ProgressBarComponent()
            }

            is Resource.Success -> {
                if (uiState.data != null) {
                    ProductComponent(
                        modifier = Modifier
                            .fillMaxWidth()
                            .constrainAs(productList) {
                                top.linkTo(appBar.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                                height = Dimension.fillToConstraints
                            },
                        products = uiState.data ?: emptyList(),
                        navigateToDetails = { codigo ->
                            navigateToDetails(codigo)
                        }
                    )
                }
            }
        }
    }
}
