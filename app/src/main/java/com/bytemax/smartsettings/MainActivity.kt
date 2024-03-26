package com.bytemax.smartsettings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bytemax.smartsettings.ui.theme.SmartSettingsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation()
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