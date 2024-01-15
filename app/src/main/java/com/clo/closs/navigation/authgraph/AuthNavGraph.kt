package com.clo.closs.navigation.authgraph

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.clo.closs.common.navigateSingleTopTo
import com.clo.closs.navigation.Graph
import com.clo.closs.presentation.auth.forgetpassword.ui.ForgetPasswordScreen
import com.clo.closs.presentation.auth.login.ui.LoginScreen
import com.clo.closs.presentation.auth.register.ui.RegisterScreen
import com.clo.closs.presentation.auth.terms.TermsAndConditionsScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController, width: Int) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreens.LoginScreen.route
    ) {
        addLogin(
            navController = navController,
            width = width
        )
        addRegister(navController = navController, width = width)
        addTerms(navController = navController, width = width)
        addForgetPassword(navController = navController, width = width)
    }
}

fun NavGraphBuilder.addLogin(navController: NavHostController, width: Int) {
    composable(
        route = AuthScreens.LoginScreen.route,
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -width },
                animationSpec = tween(
                    durationMillis = 500, easing = FastOutSlowInEasing
                )
            ) + fadeOut(
                animationSpec = tween(durationMillis = 500)
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -width },
                animationSpec = tween(
                    durationMillis = 500, easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(durationMillis = 500))
        },
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { -width },
                animationSpec = tween(
                    durationMillis = 500, easing = FastOutSlowInEasing
                )
            ) + fadeIn(
                animationSpec = tween(durationMillis = 500)
            )
        }
    ) {
        LoginScreen(
            navigateToRegister = {
              navController.navigateSingleTopTo(AuthScreens.RegisterScreen.route)
            },
            navigateToHome = {
                navController.navigateSingleTopTo(Graph.HOME)
            },
            navigateToForgotPassword = {
                navController.navigateSingleTopTo(AuthScreens.ForgetPasswordScreen.route)
            }
        )
    }
}

fun NavGraphBuilder.addRegister(
    navController: NavHostController,
    width: Int
) {
    composable(
        route = AuthScreens.RegisterScreen.route,
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
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { width },
                animationSpec = tween(
                    durationMillis = 500, easing = FastOutSlowInEasing
                )
            ) + fadeOut(
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
            ) + fadeOut(animationSpec = tween(durationMillis = 500))
        }
    ) {
        RegisterScreen(
            navigateToHome = {
                navController.navigateSingleTopTo(Graph.HOME)
            },
            navigateToLogin = {
                navController.navigateSingleTopTo(AuthScreens.LoginScreen.route)
            },
            navigateToTerms = {
                navController.navigateSingleTopTo(AuthScreens.TermsAndConditionsScreen.route)
            }
        )
    }
}

fun NavGraphBuilder.addTerms(
    navController: NavHostController,
    width: Int
) {
    composable(
        route = AuthScreens.TermsAndConditionsScreen.route,
        enterTransition = {
            slideInVertically(
                initialOffsetY = { -width },
                animationSpec = tween(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(
                animationSpec = tween(durationMillis = 500)
            )
        },
        popExitTransition = {
            slideOutVertically(
                targetOffsetY = { width },
                animationSpec = tween(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(durationMillis = 500))
        }
    ) {
        TermsAndConditionsScreen {
            navController.popBackStack()
        }
    }
}

fun NavGraphBuilder.addForgetPassword(
    navController: NavHostController,
    width: Int
) {
    composable(
        route = AuthScreens.ForgetPasswordScreen.route,
        enterTransition = {
            slideInVertically(
                initialOffsetY = { -width },
                animationSpec = tween(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(
                animationSpec = tween(durationMillis = 500)
            )
        },
        popExitTransition = {
            slideOutVertically(
                targetOffsetY = { width },
                animationSpec = tween(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(durationMillis = 500))
        }
    ) {
        ForgetPasswordScreen {
            navController.popBackStack()
        }
    }
}
