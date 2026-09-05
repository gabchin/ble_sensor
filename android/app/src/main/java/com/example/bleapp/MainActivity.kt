package com.example.bleapp

import android.os.Bundle
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.bleapp.ui.theme.BLEAppTheme
import android.Manifest
import android.content.pm.PackageManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            println("Android 12 or newer")
            val permissionStatus = ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN)
            if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
                println("Bluetooth scan permission granted")
            }
            else {
                println("Bluetooth scan permission not granted")
            }
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BLEAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BLEAppTheme {
        Greeting("Android")
    }
}