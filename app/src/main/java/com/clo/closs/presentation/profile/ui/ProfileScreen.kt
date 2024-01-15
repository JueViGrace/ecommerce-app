package com.clo.closs.presentation.profile.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.clo.closs.presentation.profile.ui.components.ProfileComponent
import com.clo.closs.presentation.profile.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel = hiltViewModel(),
    popBack: () -> Unit,
    endSession: () -> Unit
) {
    ProfileComponent(
        popBack = {
            popBack()
        },
        endSession = {
            endSession()
            profileViewModel.endSession()
        }
    )
}
