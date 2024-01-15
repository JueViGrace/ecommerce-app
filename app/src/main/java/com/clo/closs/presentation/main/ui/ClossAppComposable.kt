package com.clo.closs.presentation.main.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.clo.closs.navigation.rootgraph.RootNavigationGraph
import com.clo.closs.presentation.components.BottomBar

@Composable
fun ClossAppComposable(
) {
    val navController = rememberNavController()
    var topBarVisibilityState by rememberSaveable {
        mutableStateOf(true)
    }

    Scaffold(
        /*topBar = {
            AppBar(
                isVisible = topBarVisibilityState,
                searchSequence = { query ->
                    when (navBackStackEntry?.destination?.route) {
                        HomeScreens.DashBoardScreen.route -> {
                        }

                        HomeScreens.ProductScreen.route -> {
                            onProductSearch(SearchEvent.SearchQuery(query))
                        }
                    }
                },
                onCartIconClick = {
                    navController.navigateSingleTopTo(DetailScreens.CartDetail.route)
                }
            )
        },*/
        bottomBar = {
            BottomBar(
                navController = navController,
                isVisible = { isVisible ->
                    topBarVisibilityState = isVisible
                }
            )
        }
    ) { paddingValues ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Surface {
                RootNavigationGraph(navController = navController, width = constraints.maxWidth)
            }
        }
    }
}
