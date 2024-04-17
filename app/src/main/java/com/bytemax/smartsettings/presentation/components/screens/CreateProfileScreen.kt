package com.bytemax.smartsettings.presentation.components.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bytemax.smartsettings.data.SettingType
import com.bytemax.smartsettings.data.entities.SettingsProfile
import com.bytemax.smartsettings.presentation.theme.SmartSettingsTheme
import com.bytemax.smartsettings.presentation.viewmodels.CreateProfileViewModel

@Composable
fun CreateProfileScreen(
    navController: NavController,
    viewModel: CreateProfileViewModel = hiltViewModel<CreateProfileViewModel>()
) {
    SmartSettingsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                content = {
                    Column(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxWidth()
                            .windowInsetsPadding(WindowInsets.safeContent),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TextField(
                            value = viewModel.profileName,
                            onValueChange = { newValue -> viewModel.updateProfileName(newValue) },
                            label = {
                                Text("Enter a profile name")
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.AccountCircle,
                                    contentDescription = "Profile name"
                                )
                            },
                            singleLine = true
                        )

                        Text(
                            text = "choose settings to enable",
                            modifier = Modifier
                                .padding(top = 40.dp),
                        )
                        EditableSettings(
                            modifier = Modifier
                                .padding(
                                    top = 10.dp,
                                    bottom = 40.dp
                                )
                        )

                    }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {
                        viewModel.addProfile(
                            SettingsProfile(
                                name = viewModel.profileName,
                                icon = Icons.Default.AccountCircle,
                                enabledSettings = viewModel.enabledSettings,
                                disabledSettings = viewModel.disabledSettings,
                                isActive = true,
                                triggerDistance = 5,
                                lat = 52.52010050321414,
                                long = 13.40469898528646,
                            )
                        )
                        navController.popBackStack()
                    }
                    ) {
                        Icon(Icons.Default.Check, contentDescription = "finish profile editing")
                    }
                }
            )
        }
    }
}

@Composable
fun EditableSettings(
    modifier: Modifier = Modifier,
    viewModel: CreateProfileViewModel = hiltViewModel<CreateProfileViewModel>()
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        for (setting in SettingType.entries) {
            val isEnabled = viewModel.enabledSettings.contains(setting)
            Image(
                modifier = Modifier
                    .size(70.dp)
                    .padding(all = 10.dp)
                    .clickable {
                        if (isEnabled) viewModel.disableSetting(setting)
                        else viewModel.enableSetting(setting)
                    },
                painter = painterResource(id = setting.iconDrawableId),
                contentDescription = setting.name,
                colorFilter =
                if (isEnabled) ColorFilter.tint(Color.Green)
                else ColorFilter.tint(Color.Red),
                alignment = Alignment.Center,
            )
        }
    }
}
