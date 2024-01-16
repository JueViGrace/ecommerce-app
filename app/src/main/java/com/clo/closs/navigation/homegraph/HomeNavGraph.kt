package com.clo.closs.navigation.homegraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.clo.closs.common.navigateSingleTopTo
import com.clo.closs.navigation.Graph
import com.clo.closs.navigation.detailgraph.DetailScreens
import com.clo.closs.navigation.detailgraph.detailNavGraph
import com.clo.closs.presentation.dashboard.ui.DashBoardScreen
import com.clo.closs.presentation.debts.ui.DebtScreen
import com.clo.closs.presentation.orders.ui.OrderScreen
import com.clo.closs.presentation.product.ui.ProductScreen
import com.clo.closs.presentation.profile.ui.ProfileScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.HOME,
        startDestination = HomeScreens.DashBoardScreen.route
    ) {
        addDashboard(navController = navController)
        addProduct(navController = navController)
        addOrder(navController = navController)
        addDebt(navController = navController)
        addProfile(navController = navController)
        detailNavGraph(navController)
    }
}

fun NavGraphBuilder.addProfile(
    navController: NavHostController
) {
    composable(
        route = HomeScreens.ProfileScreen.route,
        /*enterTransition = {
            slideInHorizontally(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        }*/
    ) {
        ProfileScreen(
            popBack = {
                navController.popBackStack()
            }
        ) {
            navController.navigateSingleTopTo(Graph.ROOT)
        }
    }
}

fun NavGraphBuilder.addDebt(
    navController: NavHostController
) {
    composable(
        route = HomeScreens.DebtScreen.route,
        /*enterTransition = {
            slideInHorizontally(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        }*/
    ) {
        DebtScreen { debtId ->
            navController.navigateSingleTopTo(DetailScreens.DebtDetail.route + "/$debtId")
        }
    }
}
fun NavGraphBuilder.addOrder(
    navController: NavHostController
) {
    composable(
        route = HomeScreens.OrderScreen.route,
        /*enterTransition = {
            slideInHorizontally(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        }*/
    ) {
        OrderScreen { orderId ->
            navController.navigateSingleTopTo(DetailScreens.OrderDetail.route + "/$orderId")
        }
    }
}

fun NavGraphBuilder.addProduct(
    navController: NavHostController
) {
    composable(
        route = HomeScreens.ProductScreen.route,
        /*enterTransition = {
            slideInHorizontally(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        }*/
    ) {
        ProductScreen(
            navigateToDetails = { productId ->
                navController.navigateSingleTopTo(DetailScreens.ProductDetail.route + "/$productId")
            },
            navigateToCart = {
                navController.navigateSingleTopTo(DetailScreens.CartDetail.route)
            }
        )
    }
}

fun NavGraphBuilder.addDashboard(
    navController: NavHostController
) {
    composable(
        route = HomeScreens.DashBoardScreen.route,
        /*enterTransition = {
            slideInHorizontally(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        }*/
    ) {
        DashBoardScreen(
            onItemClick = { item ->
            }
        )
    }
}
