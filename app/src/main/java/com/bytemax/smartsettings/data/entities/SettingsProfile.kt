package com.bytemax.smartsettings.data.entities

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bytemax.smartsettings.data.SettingType

@Entity
data class SettingsProfile(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val icon: ImageVector,
    val enabledSettings: List<SettingType>,
    val disabledSettings: List<SettingType>,
    val isActive: Boolean,
    val triggerDistance: Int
)
