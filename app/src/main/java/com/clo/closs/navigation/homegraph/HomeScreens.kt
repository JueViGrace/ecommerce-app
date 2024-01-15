package com.clo.closs.navigation.homegraph

import androidx.navigation.NamedNavArgument
import com.clo.closs.common.Constantes
import com.clo.closs.common.Constantes.DASHBOARD
import com.clo.closs.common.Constantes.DEBT
import com.clo.closs.common.Constantes.ORDER
import com.clo.closs.common.Constantes.PRODUCT
import com.clo.closs.common.Constantes.PROFILE
import com.clo.closs.navigation.detailgraph.DetailScreens

sealed class HomeScreens(val route: String, val arguments: List<NamedNavArgument>){
    data object DashBoardScreen : HomeScreens(
        route = DASHBOARD,
        arguments = emptyList()
    )
    data object ProductScreen : HomeScreens(
        route = PRODUCT,
        arguments = emptyList()
    )
    data object OrderScreen : HomeScreens(
        route = ORDER,
        arguments = emptyList()
    )
    data object ProfileScreen : HomeScreens(
        route = PROFILE,
        arguments = emptyList()
    )
    data object DebtScreen : HomeScreens(
        route = DEBT,
        arguments = emptyList()
    )
}
