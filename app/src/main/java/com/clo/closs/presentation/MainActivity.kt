package com.clo.closs.presentation

import android.content.Context
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.clo.closs.common.Constantes.WORKER_ID
import com.clo.closs.common.Constantes.WORKER_REPEAT_INTERVAL
import com.clo.closs.domain.workers.DownloadWorker
import com.clo.closs.presentation.main.ui.ClossAppComposable
import com.clo.closs.presentation.theme.CLOSSTheme
import dagger.hilt.android.AndroidEntryPoint
import java.time.Duration
import java.util.UUID

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initWorkerManager(this.applicationContext)
        setContent {
            CLOSSTheme {
                ClossAppComposable()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun GreetingPreview() {
    CLOSSTheme {
        ClossAppComposable()
    }
}

private fun initWorkerManager(applicationContext: Context) {
    val workRequest =
        PeriodicWorkRequestBuilder<DownloadWorker>(repeatInterval = Duration.ofMinutes(WORKER_REPEAT_INTERVAL))
            .setId(UUID.fromString(WORKER_ID))
            .setBackoffCriteria(
                backoffPolicy = BackoffPolicy.LINEAR,
                duration = Duration.ZERO
            )
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .setRequiresBatteryNotLow(true)
                    .build()
            )
            .build()
    WorkManager
        .getInstance(applicationContext)
        .enqueueUniquePeriodicWork(
            workRequest.stringId,
            ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE,
            workRequest
        )
}
