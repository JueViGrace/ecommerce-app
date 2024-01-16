package com.clo.closs.application

import android.app.Application
import android.util.Log
import androidx.work.Configuration
import com.clo.closs.domain.workers.DownloadWorkerFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class ClossApp : Application(), Configuration.Provider {
    @Inject
    lateinit var workerFactory: DownloadWorkerFactory
    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
            .setMinimumLoggingLevel(Log.DEBUG)
            .setWorkerFactory(workerFactory)
            .build()
}
