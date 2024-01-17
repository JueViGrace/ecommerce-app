package com.clo.closs.domain.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.clo.closs.domain.repository.MainRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DownloadWorkerFactory @Inject constructor(
    private val repository: MainRepository
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker = DownloadWorker(
        repository,
        appContext,
        workerParameters
    )
}
