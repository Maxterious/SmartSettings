package com.bytemax.smartsettings.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bytemax.smartsettings.data.entities.SettingsProfile
import com.bytemax.smartsettings.data.repositories.SettingsProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateProfileViewModel @Inject constructor(
    private val settingsProfileRepository: SettingsProfileRepository
) : ViewModel() {

    val profileName = mutableStateOf("")

    val profileList = settingsProfileRepository.getProfiles().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList(),
    )

    fun addProfile(profile: SettingsProfile) {
        viewModelScope.launch {
            settingsProfileRepository.upsertSettingsProfile(profile)
        }
    }
}