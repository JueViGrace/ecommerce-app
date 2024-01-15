package com.clo.closs.presentation.profile.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.clo.closs.R
import com.clo.closs.presentation.components.CustomClickableCard
import com.clo.closs.presentation.components.CustomDivider
import com.clo.closs.presentation.components.CustomImage
import com.clo.closs.presentation.components.CustomText
import com.clo.closs.presentation.components.TopComponent

@Composable
fun ProfileComponent(
    popBack: () -> Unit,
    endSession: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopComponent(
            title = "Perfil",
            titleSize = 28,
            padding = 10
        ) {
            popBack()
        }

        CustomImage(
            painter = painterResource(id = R.drawable.user_img),
            modifier = Modifier
                .size(200.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = CircleShape
                )
                .padding(10.dp)
        )

        CustomDivider(
            modifier = Modifier.padding(top = 10.dp)
        )

        CustomClickableCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            onClick = {
                endSession()
            }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomText(text = "Cerrar sesión")
                Icon(painterResource(id = R.drawable.ic_log_out), contentDescription = null)
            }
        }
    }
}
