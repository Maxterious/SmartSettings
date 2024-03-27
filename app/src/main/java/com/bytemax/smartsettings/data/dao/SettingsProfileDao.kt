package com.bytemax.smartsettings.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Upsert
import com.bytemax.smartsettings.data.entities.SettingsProfile

@Dao
interface SettingsProfileDao {
    @Insert
    fun insertSettingsProfile(settingsProfile: SettingsProfile)

    @Delete
    fun deleteSettingsProfile(settingsProfile: SettingsProfile)

    @Upsert
    fun upsertSettingsProfile(settingsProfile: SettingsProfile)
}