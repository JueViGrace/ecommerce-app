package com.clo.closs.presentation.auth.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clo.closs.common.Constantes.TOKEN_KEY
import com.clo.closs.common.Resource
import com.clo.closs.domain.model.auth.Login
import com.clo.closs.domain.repository.MainRepository
import com.clo.closs.domain.rules.Validator
import com.clo.closs.presentation.auth.login.events.LoginEvent
import com.clo.closs.presentation.auth.login.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    init {
        validateSession()
    }

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> {
                _state.update { state ->
                    state.copy(
                        email = event.email
                    )
                }
            }

            is LoginEvent.PasswordChanged -> {
                _state.update { state ->
                    state.copy(
                        password = event.password
                    )
                }
            }

            LoginEvent.LoginButtonClicked -> {
                login()
            }

            is LoginEvent.RememberChecked -> {
                _state.update { state ->
                    state.copy(
                        rememberChecked = event.status
                    )
                }
            }
        }
        validateDataWithRules()
    }

    fun login() {
        validateDataWithRules()

        val login = Login(
            password = state.value.password,
            email = state.value.email,
        )
        doLogin(login)
    }

    private fun doLogin(login: Login) {
        viewModelScope.launch {
            repository.login(login).collect { resource ->
                when (resource) {
                    is Resource.Error -> {
                        _state.update { state ->
                            state.copy(
                                loginError = true,
                                loggedIn = false,
                                loginInProgress = false,
                                loginResponse = resource.message
                            )
                        }
                    }

                    is Resource.Loading -> {
                        _state.update { state ->
                            state.copy(
                                loginInProgress = true,
                                loginError = false,
                            )
                        }
                    }

                    is Resource.Success -> {
                        if (resource.data != null) {
                            val response = resource.data
                            val usuario = response.user
                            repository.upsertUser(usuario.copy(sesion = _state.value.rememberChecked))
                            repository.saveStringPreference(key = TOKEN_KEY, value = response.token)
                            _state.update { state ->
                                state.copy(
                                    loginError = false,
                                    loggedIn = true,
                                    loginInProgress = false,
                                    loginResponse = "Bienvenido"
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun validateSession() {
        viewModelScope.launch {
            val rememberChecked = repository.getUserSession() ?: false
            _state.update { state ->
                state.copy(
                    loggedIn = rememberChecked,
                    loginResponse = "Bienvenido"
                )
            }
        }
    }

    private fun validateDataWithRules() {
        val emailResult = Validator.validateEmail(email = _state.value.email)

        val passwordResult = Validator.validatePassword(password = _state.value.password)

        _state.update { state ->
            return@update state.copy(

                emailError = emailResult.status,

                passwordError = passwordResult.status,

                allValidationsPassed = emailResult.status && passwordResult.status
            )
        }
    }
}
