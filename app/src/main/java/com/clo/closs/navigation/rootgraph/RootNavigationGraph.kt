package com.clo.closs.navigation.rootgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.clo.closs.navigation.Graph
import com.clo.closs.navigation.authgraph.authNavGraph
import com.clo.closs.navigation.homegraph.homeNavGraph

@Composable
fun RootNavigationGraph(navController: NavHostController, width: Int) {
    NavHost(navController = navController, route = Graph.ROOT, startDestination = Graph.AUTHENTICATION) {
        authNavGraph(navController = navController, width = width / 2)
        homeNavGraph(
            navController
        )
        /*addHome(
            navController = navController,
            width = width / 2
        )*/
    }
}

/*fun NavGraphBuilder.addHome(
    navController: NavHostController,
    width: Int
) {
    composable(
        route = Graph.HOME,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { width },
                animationSpec = tween(
                    durationMillis = 500, easing = FastOutSlowInEasing
                )
            ) + fadeIn(
                animationSpec = tween(durationMillis = 500)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { width },
                animationSpec = tween(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(
                animationSpec = tween(durationMillis = 500)
            )
        }
    ) {

    }
}*/
