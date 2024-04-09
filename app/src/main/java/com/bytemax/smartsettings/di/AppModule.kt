package com.bytemax.smartsettings.di

import android.app.Application
import androidx.room.Room
import com.bytemax.smartsettings.data.AppDatabase
import com.bytemax.smartsettings.data.dao.SettingsProfileDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesAppDatabase(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, "SmartSettingsDB")
            .build()
    }

    @Provides
    @Singleton
    fun providesSettingsProfileDao(appDatabase: AppDatabase): SettingsProfileDao {
        return appDatabase.settingsProfileDao
    }
}