package com.clo.closs.presentation.product.ui.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.clo.closs.common.format
import com.clo.closs.common.round
import com.clo.closs.domain.model.Product
import com.clo.closs.presentation.components.CustomClickableCard
import com.clo.closs.presentation.components.CustomDefaultBtn
import com.clo.closs.presentation.components.CustomText
import com.clo.closs.presentation.components.TwoItemRowComponent

@Composable
fun ProductItemComponent(
    product: Product,
    navigateToDetails: (String) -> Unit
) {
    var cant by remember {
        mutableStateOf(0)
    }
    var enabled by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current

    val dctoaplicar: Double = product.dctotope / 100
    val mtodescuento: Double = product.precio1 * dctoaplicar
    val preciocondescuento: Double = product.precio1 - mtodescuento

    CustomClickableCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.outline),
        shape = CardDefaults.outlinedShape,
        onClick = {
            navigateToDetails(product.codigo)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(3.dp, Alignment.Top)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
                verticalAlignment = Alignment.Top
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(150.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                        .padding(10.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.cloccidental.com/img/${product.codigo}.jpg")
                        .crossfade(enable = true)
                        .crossfade(200)
                        .build(),
                    contentDescription = null
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(3.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TwoItemRowComponent(
                        modifier = Modifier.fillMaxWidth(),
                        title = "Nombre: ",
                        text = product.nombre
                    )
                    TwoItemRowComponent(
                        modifier = Modifier.fillMaxWidth(),
                        title = "Descuento: ",
                        text = product.dctotope.toString()
                    )
                    TwoItemRowComponent(
                        modifier = Modifier.fillMaxWidth(),
                        title = "Descripción: ",
                        text = ".",
                        maxLines = 10
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (product.dctotope > 0) {
                    TwoItemRowComponent(
                        title = "Código: ",
                        text = product.codigo
                    )
                    TwoItemRowComponent(
                        title = "Precio: ",
                        text = preciocondescuento.round().format(2),
                    )
                    TwoItemRowComponent(
                        title = "antes: ",
                        text = product.precio1.round().format(2),
                        textDecoration = TextDecoration.LineThrough
                    )
                    TwoItemRowComponent(
                        title = "Existencia: ",
                        text = product.existencia.toString()
                    )
                } else {
                    TwoItemRowComponent(
                        title = "Código: ",
                        text = product.codigo
                    )
                    TwoItemRowComponent(
                        title = "Precio: ",
                        text = product.precio1.round().format(2),
                    )
                    TwoItemRowComponent(
                        title = "Existencia: ",
                        text = product.existencia.toString()
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomText(
                    text = "Cantidad a llevar: ",
                    textSize = 18,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                CustomText(text = cant.toString())

                ProductButtonsComponent(
                    onSubtract = {
                        cant--
                        if (cant <= 0) {
                            cant = 0
                            enabled = false
                        } else {
                            enabled = true
                        }
                    },
                    onAdd = {
                        cant++
                        enabled = true
                    }
                )
                CustomDefaultBtn(
                    onClick = {
                        if (enabled) {
                            Toast.makeText(context, "Añadido al carrito", Toast.LENGTH_SHORT).show()
                        }
                    },
                    enabled = enabled
                ) {
                    CustomText(text = "Añadir")
                }
            }
        }
    }
}
