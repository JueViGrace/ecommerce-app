package com.clo.closs.domain.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.clo.closs.domain.repository.MainRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

class DownloadWorker @AssistedInject constructor(
    private val repository: MainRepository,
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        TODO("Not yet implemented")
    }
}