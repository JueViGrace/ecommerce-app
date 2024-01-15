package com.clo.closs.di

import android.content.Context
import com.clo.closs.data.remote.api.Api
import com.clo.closs.data.remote.service.ApiService
import com.clo.closs.data.sources.LocalDataSource
import com.clo.closs.data.sources.PreferencesSource
import com.clo.closs.data.sources.RemoteDataSource
import com.clo.closs.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context = context.applicationContext

    @Singleton
    @Provides
    fun provideMainRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource,
        preferencesSource: PreferencesSource
    ): MainRepository {
        return MainRepository(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource,
            preferencesSource = preferencesSource
        )
    }

    @Singleton
    @Provides
    fun provideMainService(
        api: Api,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): RemoteDataSource {
        return ApiService(
            api = api,
            ioDispatcher = ioDispatcher
        )
    }
}
