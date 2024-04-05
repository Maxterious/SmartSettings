package com.bytemax.smartsettings.data.repositories

import com.bytemax.smartsettings.data.dao.SettingsProfileDao
import com.bytemax.smartsettings.data.entities.SettingsProfile
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsProfileRepository @Inject constructor(
    private val settingsProfileDao: SettingsProfileDao
) {
    fun insertSettingsProfile(settingsProfile: SettingsProfile) {
        settingsProfileDao.insertSettingsProfile(settingsProfile)
    }

    fun deleteSettingsProfile(settingsProfile: SettingsProfile) {
        settingsProfileDao.deleteSettingsProfile(settingsProfile)
    }

    fun upsertSettingsProfile(settingsProfile: SettingsProfile) {
        settingsProfileDao.upsertSettingsProfile(settingsProfile)
    }

    fun getProfiles(): Flow<List<SettingsProfile>> {
        return settingsProfileDao.getProfiles()
    }
}