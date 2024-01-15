package com.clo.closs.presentation.auth.register.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clo.closs.common.Constantes
import com.clo.closs.common.Resource
import com.clo.closs.domain.model.auth.Register
import com.clo.closs.domain.repository.MainRepository
import com.clo.closs.domain.rules.Validator
import com.clo.closs.presentation.auth.register.events.RegisterEvent
import com.clo.closs.presentation.auth.register.state.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    private val _state = MutableStateFlow(RegisterState())
    val state: StateFlow<RegisterState> = _state.asStateFlow()

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.CodeChanged -> {
                _state.update { state ->
                    return@update state.copy(
                        code = event.code
                    )
                }
            }

            is RegisterEvent.EmailChanged -> {
                _state.update { state ->
                    return@update state.copy(
                        email = event.email
                    )
                }
            }

            is RegisterEvent.NameChanged -> {
                _state.update { state ->
                    return@update state.copy(
                        names = event.names
                    )
                }
            }

            is RegisterEvent.PasswordChanged -> {
                _state.update { state ->
                    return@update state.copy(
                        password = event.password
                    )
                }
            }

            is RegisterEvent.PhoneChanged -> {
                _state.update { state ->
                    return@update state.copy(
                        phone = event.phone
                    )
                }
            }

            is RegisterEvent.PrivacyPolicyCheckBoxClicked -> {
                _state.update { state ->
                    return@update state.copy(
                        privacyPolicyAccepted = event.status
                    )
                }
            }

            RegisterEvent.RegisterButtonClicked -> {
                register()
            }
        }
        validateDataWithRules()
    }

    fun register() {
        validateDataWithRules()

        val register = Register(
            password = state.value.password,
            code = state.value.code,
            email = state.value.email,
            telefono = state.value.phone,
            name = state.value.names
        )
        createUser(register)
    }

    private fun createUser(register: Register) {
        viewModelScope.launch {
            repository.register(register).collect { resource ->
                when (resource) {
                    is Resource.Error -> {
                        _state.update { state ->
                            return@update state.copy(
                                registerError = true,
                                registered = false,
                                registerInProgress = false,
                                registerResponse = resource.message
                            )
                        }
                    }

                    is Resource.Loading -> {
                        _state.update { state ->
                            return@update state.copy(
                                registerInProgress = true,
                                registerError = false,
                            )
                        }
                    }

                    is Resource.Success -> {
                        if (resource.data != null) {
                            repository.upsertUser(resource.data.user)
                            repository.saveStringPreference(key = Constantes.TOKEN_KEY, value = resource.data.token)
                            _state.update { state ->
                                return@update state.copy(
                                    registerError = false,
                                    registered = true,
                                    registerInProgress = false,
                                    registerResponse = "Bienvenido"
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun validateDataWithRules() {
        val namesResult = Validator.validateNames(names = _state.value.names)

        val codeResult = Validator.validateCode(code = _state.value.code)

        val phoneResult = Validator.validatePhone(phone = _state.value.phone)

        val emailResult = Validator.validateEmail(email = _state.value.email)

        val passwordResult = Validator.validatePassword(password = _state.value.password)

        val privacyPolicyResult = Validator.validatePrivacyPolicyAcceptance(
            statusValue = _state.value.privacyPolicyAccepted
        )

        _state.update { state ->
            return@update state.copy(
                namesError = namesResult.status,
                emailError = emailResult.status,
                codeError = codeResult.status,
                passwordError = passwordResult.status,
                privacyPolicyError = privacyPolicyResult.status,
                phoneError = phoneResult.status,

                allValidationsPassed =
                namesResult.status &&
                    emailResult.status &&
                    passwordResult.status &&
                    privacyPolicyResult.status &&
                    phoneResult.status &&
                    codeResult.status
            )
        }
    }
}
