package com.clo.closs.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.clo.closs.common.Constantes.navItemList
import com.clo.closs.common.navigateSingleTopTo
import com.clo.closs.navigation.authgraph.AuthScreens
import com.clo.closs.navigation.detailgraph.DetailScreens
import com.clo.closs.navigation.homegraph.HomeScreens

@Composable
fun BottomBar(
    navController: NavHostController,
    isVisible: (Boolean) -> Unit,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    var bottomNavVisibility by remember {
        mutableStateOf(true)
    }

    if (bottomNavVisibility) {
        BottomAppBar(
            modifier = Modifier
                .shadow(
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
                    elevation = 12.dp
                )
                .clip(RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp))
        ) {
            navItemList.forEach { screen ->
                val selected = currentRoute == screen.route
                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        navController.navigateSingleTopTo(screen.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = screen.icon),
                            contentDescription = null,
                            tint = if (selected) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                LocalContentColor.current
                            }
                        )
                    },
                    label = {
                        CustomText(text = screen.title)
                    }
                )
            }
        }
    }

    when (currentRoute) {
        AuthScreens.LoginScreen.route -> {
            bottomNavVisibility = false
            isVisible(false)
        }

        AuthScreens.TermsAndConditionsScreen.route -> {
            bottomNavVisibility = false
            isVisible(false)
        }

        AuthScreens.RegisterScreen.route -> {
            bottomNavVisibility = false
            isVisible(false)
        }

        AuthScreens.ForgetPasswordScreen.route -> {
            bottomNavVisibility = false
            isVisible(false)
        }

        HomeScreens.DashBoardScreen.route -> {
            bottomNavVisibility = true
            isVisible(true)
        }

        HomeScreens.ProductScreen.route -> {
            bottomNavVisibility = true
            isVisible(true)
        }

        HomeScreens.OrderScreen.route -> {
            bottomNavVisibility = true
            isVisible(true)
        }

        HomeScreens.DebtScreen.route -> {
            bottomNavVisibility = true
            isVisible(true)
        }

        DetailScreens.CartDetail.route -> {
            bottomNavVisibility = false
            isVisible(false)
        }

        DetailScreens.OrderDetail.route + "/{orderId}" -> {
            bottomNavVisibility = false
            isVisible(false)
        }

        DetailScreens.DebtDetail.route + "/{debtId}" -> {
            bottomNavVisibility = false
            isVisible(false)
        }

        DetailScreens.ProductDetail.route + "/{productId}" -> {
            bottomNavVisibility = false
            isVisible(false)
        }

        else -> {
            bottomNavVisibility = true
            isVisible(false)
        }
    }
}
