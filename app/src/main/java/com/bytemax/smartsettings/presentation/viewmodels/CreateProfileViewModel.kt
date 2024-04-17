package com.bytemax.smartsettings.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bytemax.smartsettings.data.SettingType
import com.bytemax.smartsettings.data.entities.SettingsProfile
import com.bytemax.smartsettings.data.repositories.SettingsProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateProfileViewModel @Inject constructor(
    private val settingsProfileRepository: SettingsProfileRepository
) : ViewModel() {

    var profileName by mutableStateOf("")
        private set

    var enabledSettings = mutableStateListOf<SettingType>()
        private set

    var disabledSettings = mutableStateListOf<SettingType>()
        private set

    fun updateProfileName(input: String) {
        profileName = input
    }

    fun addProfile(profile: SettingsProfile) {
        viewModelScope.launch {
            settingsProfileRepository.upsertSettingsProfile(profile)
        }
    }

    fun enableSetting(setting: SettingType) {
        enabledSettings.add(setting)
        disabledSettings.remove(setting)
    }

    fun disableSetting(setting: SettingType) {
        enabledSettings.remove(setting)
        disabledSettings.add(setting)
    }
}