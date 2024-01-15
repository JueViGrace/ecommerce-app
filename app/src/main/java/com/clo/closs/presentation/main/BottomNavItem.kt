package com.clo.closs.presentation.main

import androidx.annotation.DrawableRes
import com.clo.closs.R
import com.clo.closs.navigation.homegraph.HomeScreens

sealed class BottomNavItem(val title: String, @DrawableRes val icon: Int, val route: String) {
    data object HomeNav : BottomNavItem(
        title = "Home",
        icon = R.drawable.ic_shop_icon,
        route = HomeScreens.DashBoardScreen.route
    )
    data object ProductNav : BottomNavItem(
        title = "Artículos",
        icon = R.drawable.ic_catalog,
        route = HomeScreens.ProductScreen.route
    )
    data object OrderNav : BottomNavItem(
        title = "Pedidos",
        icon = R.drawable.ic_bag,
        route = HomeScreens.OrderScreen.route
    )
    data object DebtNav : BottomNavItem(
        title = "Facturas",
        icon = R.drawable.ic_receipt,
        route = HomeScreens.DebtScreen.route
    )
    data object ProfileNav : BottomNavItem(
        title = "Perfil",
        icon = R.drawable.ic_user_icon,
        route = HomeScreens.ProfileScreen.route
    )
}
