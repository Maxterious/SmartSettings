package com.bytemax.smartsettings.presentation.components.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
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
                                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile name")
                            },
                            singleLine = true
                        )

                        TextField(
                            value = viewModel.profileName,
                            onValueChange = { newValue -> viewModel.updateProfileName(newValue) },
                            label = {
                                Text("Enter a profile name")
                            },
                            leadingIcon = {
                                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile name")
                            },
                            singleLine = true
                        )

                    }
                }
            )
        }
    }
}