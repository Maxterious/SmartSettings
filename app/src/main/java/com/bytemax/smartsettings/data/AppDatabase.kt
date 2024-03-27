package com.bytemax.smartsettings.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bytemax.smartsettings.data.dao.SettingsProfileDao
import com.bytemax.smartsettings.data.entities.SettingsProfile

@Database(
    entities = [SettingsProfile::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract val settingsProfileDao: SettingsProfileDao
}