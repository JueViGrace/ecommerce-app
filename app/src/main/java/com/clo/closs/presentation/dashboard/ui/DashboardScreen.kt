package com.clo.closs.presentation.dashboard.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.clo.closs.presentation.components.CustomSpacer
import com.clo.closs.presentation.components.CustomText

@Composable
fun DashBoardScreen(
    onItemClick: (String) -> Unit
) {
    DashboardComponent(
        onItemClick = { item ->
            onItemClick(item)
        }
    )
}

@Composable
fun DashboardComponent(onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
            .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(15.dp),
            verticalArrangement = Arrangement.Center
        ) {
            CustomText(text = "A Spring Surprise")
            CustomText(text = "Cashback 25%", textSize = 26, fontWeight = FontWeight.Bold)
        }

        CustomSpacer(paddingVertical = 10)
    }
}
