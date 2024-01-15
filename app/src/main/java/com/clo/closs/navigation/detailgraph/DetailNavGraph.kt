package com.clo.closs.navigation.detailgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.clo.closs.common.Constantes.PRODUCT_ID_KEY
import com.clo.closs.navigation.Graph
import com.clo.closs.presentation.cart.ui.CartScreen
import com.clo.closs.presentation.debts.detail.DebtDetailScreen
import com.clo.closs.presentation.orders.detail.OrderDetailScreen
import com.clo.closs.presentation.product.detail.ProductDetailScreen

fun NavGraphBuilder.detailNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailScreens.ProductDetail.route + "/${PRODUCT_ID_KEY}"
    ) {
        addProductDetail(navController = navController)
        addCartDetail(navController = navController)
        addOrderDetail(navController = navController)
        addDebtDetail(navController = navController)
    }
}

fun NavGraphBuilder.addDebtDetail(navController: NavHostController) {
    composable(
        route = DetailScreens.DebtDetail.route + "/{debtId}",
        /*enterTransition = {
            fadeIn(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        },
        popExitTransition = {
            fadeOut(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        }*/
    ) {
        DebtDetailScreen(
            popBack = {
                navController.popBackStack()
            }
        )
    }
}

fun NavGraphBuilder.addOrderDetail(navController: NavHostController) {
    composable(
        route = DetailScreens.OrderDetail.route + "/{orderId}",
        /*enterTransition = {
            fadeIn(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        },
        popExitTransition = {
            fadeOut(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        }*/
    ) {
        OrderDetailScreen(
            popBack = {
                navController.popBackStack()
            }
        )
    }
}

fun NavGraphBuilder.addCartDetail(navController: NavHostController) {
    composable(
        route = DetailScreens.CartDetail.route,
        /*enterTransition = {
            fadeIn(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        },
        popExitTransition = {
            fadeOut(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        }*/
    ) {
        CartScreen(
            popBack = {
                navController.popBackStack()
            }
        )
    }
}

fun NavGraphBuilder.addProductDetail(navController: NavHostController) {
    composable(
        route = DetailScreens.ProductDetail.route + "/{productId}",
        arguments = listOf(
            navArgument("productId") { defaultValue = "" }
        ),
        /*enterTransition = {
            fadeIn(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        },
        popExitTransition = {
            fadeOut(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                )
            )
        }*/
    ) {
        ProductDetailScreen(
            product = it.arguments?.getString(PRODUCT_ID_KEY)
        ) {
            navController.popBackStack()
        }
    }
}
