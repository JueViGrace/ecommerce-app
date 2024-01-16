package com.clo.closs.presentation.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clo.closs.domain.usecase.EndSession
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val endSessionUseCase: EndSession
) : ViewModel() {

    fun endSession() {
        viewModelScope.launch {
            endSessionUseCase()
            delay(1000)
        }
    }
}
