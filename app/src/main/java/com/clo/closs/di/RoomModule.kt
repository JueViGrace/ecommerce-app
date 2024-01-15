package com.clo.closs.di

import android.content.Context
import androidx.room.Room
import com.clo.closs.common.Constantes.DATABASE_NAME
import com.clo.closs.data.local.db.RoomDataBase
import com.clo.closs.data.local.service.RoomService
import com.clo.closs.data.sources.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, RoomDataBase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideRoomDataSource(db: RoomDataBase): LocalDataSource {
        return RoomService(
            db.userDao(),
            db.productDao()
        )
    }
}
