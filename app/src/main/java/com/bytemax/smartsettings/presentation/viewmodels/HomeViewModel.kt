package com.bytemax.smartsettings.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bytemax.smartsettings.data.entities.SettingsProfile
import com.bytemax.smartsettings.data.repositories.SettingsProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val settingsProfileRepository: SettingsProfileRepository
) : ViewModel() {

    val profileList = settingsProfileRepository.getProfiles().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList(),
    )

    fun addProfile(profile: SettingsProfile) {
        settingsProfileRepository.upsertSettingsProfile(profile)
    }
}