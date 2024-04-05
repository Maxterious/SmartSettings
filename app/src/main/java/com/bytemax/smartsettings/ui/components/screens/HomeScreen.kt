package com.bytemax.smartsettings.ui.components.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.bytemax.smartsettings.data.SettingType
import com.bytemax.smartsettings.data.entities.SettingsProfile
import com.bytemax.smartsettings.ui.theme.SmartSettingsTheme
import com.bytemax.smartsettings.ui.viewmodels.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
) {
    val profileList: List<SettingsProfile> by homeViewModel.profileList.collectAsStateWithLifecycle()

    SmartSettingsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                content = {
                    Column(
                        modifier =
                        Modifier.padding(it)
                    ) {
                        ProfileCardList(
                            profileCards = profileList
                        )
                    }
                },
                floatingActionButton = {
//                    FloatingActionButton(onClick = { navController.navigate(Screen.CreateProfileScreen.route) }) {
                    FloatingActionButton(onClick = {
                        homeViewModel.addProfile(
                            SettingsProfile(
                                name = "new",
                                icon = Icons.Default.AccountCircle,
                                enabledSettings = listOf(SettingType.CELLULAR),
                                disabledSettings = listOf(SettingType.BLUETOOTH),
                                isActive = true,
                                triggerDistance = 5
                            )
                        )
                    }) {
                        Icon(Icons.Default.Add, "Add new Profile")
                    }
                }
            )
        }
    }
}

@Composable
fun ProfileCardList(profileCards: List<SettingsProfile>) {
    Column(
        Modifier
            .windowInsetsPadding(WindowInsets.safeContent)
            .verticalScroll(state = rememberScrollState())
    ) {
        for (card in profileCards) {
            ProfileCard(settingsProfile = card)
        }
    }
}

@Composable
fun ProfileCard(settingsProfile: SettingsProfile) {
    ElevatedCard(
        modifier = Modifier
            .height(200.dp)
            .padding(bottom = 10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
        ) {
            Icon(
                imageVector = settingsProfile.icon,
                contentDescription = "Home icon"
            )
            Text(
                text = settingsProfile.name,
                textAlign = TextAlign.Center,
            )
        }

        Row(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
            Text(text = "Enable: ")

            for (setting in settingsProfile.enabledSettings) {
                Text(text = setting.name)
            }
        }

        Row(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
            Text(text = "Disable: ")

            for (setting in settingsProfile.disabledSettings) {
                Text(text = setting.name)
            }
        }

    }
}