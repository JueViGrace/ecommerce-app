package com.clo.closs.presentation.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import com.clo.closs.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashBoardViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
}