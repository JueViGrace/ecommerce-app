package com.clo.closs.domain.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.clo.closs.common.Resource
import com.clo.closs.common.log
import com.clo.closs.domain.model.Product
import com.clo.closs.domain.repository.MainRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.catch

class DownloadWorker @AssistedInject constructor(
    private val repository: MainRepository,
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        return if (repository.getUserSession() == true) {
            downLoad()
        } else {
            onStopped()
            Result.failure()
        }
    }

    private suspend fun downLoad(): Result {
        var result = false

        repository.getProductsFromApi().catch { err: Throwable ->
            err.log("Product worker error")
        }
            .collect { resource: Resource<List<Product>> ->
                when (resource) {
                    is Resource.Error -> result = false
                    is Resource.Loading -> result = false
                    is Resource.Success -> {
                        if (resource.data != null) {
                            repository.upsertProduct(resource.data)
                            result = true
                        }
                    }
                }
            }

        return if (result) {
            Result.success()
        } else {
            Result.retry()
        }
    }
}
