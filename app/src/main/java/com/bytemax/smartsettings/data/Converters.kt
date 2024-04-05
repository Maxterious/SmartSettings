package com.bytemax.smartsettings.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromIcon(icon: ImageVector): String {
        return icon.name
    }

    @TypeConverter
    fun toIcon(iconName: String): ImageVector {
        val iconMap = mapOf(
            "Filled.Home" to Icons.Default.Home,
            "Filled.AccountCircle" to Icons.Default.AccountCircle,
        )
        return iconMap[iconName] ?: error("Icon not found: $iconName")
    }

    @TypeConverter
    fun fromSettingType(value: List<SettingType>): String {
        val type = object : TypeToken<List<SettingType>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toSettingType(value: String): List<SettingType> {
        val type = object : TypeToken<List<SettingType>>() {}.type
        return Gson().fromJson(value, type)
    }
}