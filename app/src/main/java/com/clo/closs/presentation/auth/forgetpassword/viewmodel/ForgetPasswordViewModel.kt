package com.clo.closs.presentation.auth.forgetpassword.viewmodel

import androidx.lifecycle.ViewModel
import com.clo.closs.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgetPasswordViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
}