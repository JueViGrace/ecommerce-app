package com.clo.closs.navigation.detailgraph

import androidx.navigation.NamedNavArgument
import com.clo.closs.common.Constantes.CART
import com.clo.closs.common.Constantes.DEBT_DETAIL
import com.clo.closs.common.Constantes.ORDER_DETAIL
import com.clo.closs.common.Constantes.PRODUCT_DETAIL

sealed class DetailScreens(val route: String, val arguments: List<NamedNavArgument>) {
    data object ProductDetail : DetailScreens(
        route = PRODUCT_DETAIL,
        arguments = emptyList()
    )
    data object CartDetail : DetailScreens(
        route = CART,
        arguments = emptyList()
    )
    data object OrderDetail : DetailScreens(
        route = ORDER_DETAIL,
        arguments = emptyList()
    )
    data object DebtDetail : DetailScreens(
        route = DEBT_DETAIL,
        arguments = emptyList()
    )
}
