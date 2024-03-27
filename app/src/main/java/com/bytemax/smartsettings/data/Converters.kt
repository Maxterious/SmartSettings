package com.bytemax.smartsettings.data

import androidx.compose.material.icons.Icons
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
    fun iconByName(name: String): ImageVector {
        val cl = Class.forName("androidx.compose.material.icons.filled.${name}Kt")
        val method = cl.declaredMethods.first()
        return method.invoke(null, Icons.Filled) as ImageVector
    }

    @TypeConverter
    fun fromSettingType(value: List<SettingType>): String? {
        val type = object : TypeToken<List<SettingType>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toSettingType(value: String): List<SettingType?> {
        val type = object : TypeToken<List<SettingType>>() {}.type
        return Gson().fromJson(value, type)
    }
}