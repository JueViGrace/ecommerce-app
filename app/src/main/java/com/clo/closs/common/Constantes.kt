package com.clo.closs.common

import com.clo.closs.presentation.main.BottomNavItem

object Constantes {
    const val LOGIN = "Login"
    const val REGISTER = "Register"
    const val FORGOT_PASSWORD = "ForgotPassword"
    const val DASHBOARD = "DashBoardScreen"
    const val PROFILE = "ProfileScreen"
    const val ORDER = "OrderScreen"
    const val DEBT = "DebtScreen"
    const val PRODUCT = "ProductScreen"
    const val PRODUCT_DETAIL = "ProductScreen"
    const val CART = "CartScreen"
    const val ORDER_DETAIL = "ProductDetailScreen"
    const val DEBT_DETAIL = "DebtDetailScreen"
    const val TERMS_AND_CONDITIONS = "TermsAndConditionsScreen"

    const val PRODUCT_ID_KEY = "productId"

    const val TOKEN_KEY: String = "TOKEN_KEY"
    const val REMEMBER_KEY: String = "REMEMBER_KEY"

    const val CIEN_DOUBLE: Double = 100.00
    const val CIEN_INT: Int = 100

    val navItemList = listOf(
        BottomNavItem.HomeNav,
        BottomNavItem.ProductNav,
        BottomNavItem.OrderNav,
        BottomNavItem.DebtNav,
        BottomNavItem.ProfileNav
    )

    const val WORKER_ID = "10101010-1010-1010-1010-101010101010"
    const val WORKER_REPEAT_INTERVAL: Long = 15

    // Variable que contiene la version anterior de la base de datos
    const val DATABASE_VERSION_OLD: Int = 1

    // Variable que contiene la version nueva y actual de la base de datos
    const val DATABASE_VERSION_NEW: Int = 1

    // Variable que contiene el nombre de la base de datos
    const val DATABASE_NAME: String = "room_closs_app"

    // Variable que contiene el nombre de las Shared preferences
    const val DATASTORE_NAME = "PREFERECES"

    // Variables que contienen los links de la empresa para la descarga o envio de datos
    const val BASE_URL1 = "https://aa5a-45-186-203-254.ngrok-free.app/api/v1/"
    const val BASE_URL2 = "http://cloccidental.com:5001"

    const val CONNECTION_TIMEOUT: Long = 30
}
