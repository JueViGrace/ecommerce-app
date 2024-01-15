package com.clo.closs.di

import android.content.Context
import com.clo.closs.data.preferences.PreferencesService
import com.clo.closs.data.sources.PreferencesSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Singleton
    @Provides
    fun provideDataStoreRepository(@ApplicationContext context: Context): PreferencesSource {
        return PreferencesService(context)
    }
}
