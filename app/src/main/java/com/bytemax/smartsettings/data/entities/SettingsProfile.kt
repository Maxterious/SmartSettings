package com.bytemax.smartsettings.data.entities

import androidx.compose.ui.graphics.vector.ImageVector
import com.bytemax.smartsettings.data.SettingTypes

data class SettingsProfile(
    val id: Long,
    val name: String,
    val icon: ImageVector,
    val enabledSettings: List<SettingTypes>,
    val disabledSettings: List<SettingTypes>,
    val isActive: Boolean,
    val triggerDistance: Int
)
