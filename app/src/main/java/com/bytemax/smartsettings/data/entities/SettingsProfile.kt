package com.bytemax.smartsettings.data.entities

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.bytemax.smartsettings.data.Converters
import com.bytemax.smartsettings.data.SettingType

@Entity
data class SettingsProfile(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,

    @TypeConverters(Converters::class)
    val icon: ImageVector,

    @TypeConverters(Converters::class)
    val enabledSettings: List<SettingType>,

    @TypeConverters(Converters::class)
    val disabledSettings: List<SettingType>,

    val isActive: Boolean,

    val triggerDistance: Int,

    val lat: Double,

    val long: Double
)
