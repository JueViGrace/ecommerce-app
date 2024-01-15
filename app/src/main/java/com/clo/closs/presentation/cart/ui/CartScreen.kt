package com.clo.closs.presentation.cart.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.clo.closs.presentation.cart.ui.components.CartProductsComponent
import com.clo.closs.presentation.cart.ui.components.CartTopBarComponent
import com.clo.closs.presentation.cart.ui.components.CheckoutComponent

@Composable
fun CartScreen(
    popBack: () -> Unit
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize().padding(1.dp)
    ) {
        val (topBar, product, checkout, spacer1) = createRefs()

        CartTopBarComponent(
            modifier = Modifier
                .constrainAs(topBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            popBack = {
                popBack()
            }
        )

        CartProductsComponent(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(10.dp)
                .constrainAs(product) {
                    top.linkTo(topBar.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(spacer1.top)
                    height = Dimension.fillToConstraints
                }
        )

        Spacer(
            modifier = Modifier
                .padding(vertical = 2.dp)
                .constrainAs(spacer1) {
                    top.linkTo(product.bottom)
                    bottom.linkTo(checkout.top)
                    width = Dimension.matchParent
                }
        )

        CheckoutComponent(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)
                )
                .padding(15.dp)
                .constrainAs(checkout) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(spacer1.bottom)
                }
        )
    }
}
