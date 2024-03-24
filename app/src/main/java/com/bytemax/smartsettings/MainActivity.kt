package com.bytemax.smartsettings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bytemax.smartsettings.data.SettingTypes
import com.bytemax.smartsettings.data.entities.SettingsProfile
import com.bytemax.smartsettings.ui.theme.SmartSettingsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SmartSettingsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileCardList(
                        profileCards = listOf(
                            SettingsProfile(
                                id = 1,
                                name = "Home",
                                icon = Icons.Default.Home,
                                enabledSettings = listOf(SettingTypes.WIFI),
                                disabledSettings = listOf(SettingTypes.CELLULAR),
                                isActive = true,
                                triggerDistance = 1
                            )
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileCardList(profileCards: List<SettingsProfile>) {
    Column(Modifier.windowInsetsPadding(WindowInsets.safeContent)) {
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
            .fillMaxWidth()
    ) {
        Modifier.fillMaxWidth()
        Modifier.background(color = MaterialTheme.colorScheme.tertiary)

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
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

        Row {
            Text(text = "Enable:")

            for (setting in settingsProfile.enabledSettings) {
                Text(text = setting.name)
            }
        }

        Row {
            Text(text = "Disable:")

            for (setting in settingsProfile.disabledSettings) {
                Text(text = setting.name)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SmartSettingsTheme {
//        ProfileCard("Preview")
    }
}