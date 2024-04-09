package com.bytemax.smartsettings.presentation.components.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
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
import com.bytemax.smartsettings.data.entities.SettingsProfile
import com.bytemax.smartsettings.presentation.Screen
import com.bytemax.smartsettings.presentation.theme.SmartSettingsTheme
import com.bytemax.smartsettings.presentation.viewmodels.HomeViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
) {
    val profileList: List<SettingsProfile> by viewModel.profileList.collectAsStateWithLifecycle()

    SmartSettingsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
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
                    FloatingActionButton(onClick = { navController.navigate(Screen.CreateProfileScreen.route) }) {
//                    FloatingActionButton(onClick = {
//                        homeViewModel.addProfile(
//                            SettingsProfile(
//                                name = "new",
//                                icon = Icons.Default.AccountCircle,
//                                enabledSettings = listOf(SettingType.CELLULAR),
//                                disabledSettings = listOf(SettingType.BLUETOOTH),
//                                isActive = true,
//                                triggerDistance = 5,
//                                lat = 52.52010050321414,
//                                long = 13.40469898528646,
//                            )
//                        )
//                    }) {
                        Icon(Icons.Default.Add, "Add new Profile")
                    }
                }
            )
        }
    }
}

@Composable
fun ProfileCardList(profileCards: List<SettingsProfile>) {
    LazyColumn(
        Modifier
            .windowInsetsPadding(WindowInsets.safeContent)
    ) {
        items(profileCards.size) { index ->
            ProfileCard(settingsProfile = profileCards[index])
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
        ) {
            Spacer(modifier = Modifier.weight(1F))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1F)
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

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.weight(1F)
            ) {
                Icon(
                    modifier = Modifier.clickable { println("edit profile") },
                    imageVector = Icons.Default.Edit,
                    contentDescription = "edit profile",
                )
            }
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

        MapPreview(settingsProfile)
    }
}

@Composable
fun MapPreview(settingsProfile: SettingsProfile) {
    GoogleMap(
        properties = MapProperties(),
        uiSettings = MapUiSettings(
            compassEnabled = false,
            rotationGesturesEnabled = false,
            scrollGesturesEnabled = false,
            scrollGesturesEnabledDuringRotateOrZoom = false,
            tiltGesturesEnabled = false,
            zoomControlsEnabled = true,
            zoomGesturesEnabled = false,
        ),
        cameraPositionState = CameraPositionState(
            CameraPosition(
                LatLng(settingsProfile.lat, settingsProfile.long),
                15F,
                0F,
                0F
            )
        ),
    )
}