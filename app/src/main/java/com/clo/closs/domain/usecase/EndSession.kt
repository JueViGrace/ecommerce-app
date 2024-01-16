package com.clo.closs.domain.usecase

import com.clo.closs.common.Constantes.TOKEN_KEY
import com.clo.closs.domain.repository.MainRepository
import javax.inject.Inject

class EndSession @Inject constructor(
    private val repository: MainRepository,
) {
    suspend operator fun invoke() {
        repository.deleteUser()
        repository.clearPreferences(TOKEN_KEY)
        repository.deleteProduct()
    }
}
