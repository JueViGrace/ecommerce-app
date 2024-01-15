package com.clo.closs.common

import android.util.Log
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.clo.closs.common.Constantes.CIEN_DOUBLE
import com.clo.closs.common.Constantes.CIEN_INT
import com.clo.closs.navigation.Graph
import com.clo.closs.navigation.authgraph.AuthScreens
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.roundToInt

fun <T> T.log(msg: String? = "") = Log.i("Informacion de Prueba", "$msg: $this")

inline fun Modifier.thenIf(predicate: Boolean, modify: () -> Modifier): Modifier {
    return this.then(if (predicate) modify() else Modifier)
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        when (route) {
            Graph.ROOT -> {
                popUpTo(Graph.ROOT) {
                    inclusive = true
                }
            }
            else -> {
                popUpTo(this@navigateSingleTopTo.graph.findStartDestination().id) {
                    inclusive =
                        (route == AuthScreens.LoginScreen.route) ||
                        (route == Graph.HOME) ||
                        (route == Graph.AUTHENTICATION)
                    // saveState = true
                }
            }
        }
        launchSingleTop = true
        restoreState = true
    }

fun Date.toStringFormat(format: Int): String =
    when (format) {
        1 -> {
            SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(this)
        }
        2 -> {
            SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(this)
        }
        else -> {
            SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(this)
        }
    }

fun String.toDateFormat(format: Int): Date =
    if (this.isNotEmpty()) {
        when (format) {
            1 -> {
                SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(this) as Date
            }

            2 -> {
                SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(this) as Date
            }

            else -> {
                Date()
            }
        }
    } else {
        Date()
    }

fun Double.round(): Double = (this * CIEN_DOUBLE).roundToInt() / CIEN_DOUBLE

fun Double.roundToInt(): Int = (this * CIEN_INT).roundToInt() / CIEN_INT

fun Double.format(format: Int): String =
    when (format) {
        0 -> DecimalFormat("#,##0").format(this)
        2 -> DecimalFormat("#,##0.00").format(this)
        else -> DecimalFormat("#,##0.00").format(this)
    }

// Formato que agrega "%" a un String que es utilizado para búsquedas de datos en la base de datos
fun String.toLikeSearchable(): String = "%$this%"