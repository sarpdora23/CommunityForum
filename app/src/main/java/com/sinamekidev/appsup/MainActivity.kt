package com.sinamekidev.appsup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sinamekidev.appsup.data.CloudDB
import com.sinamekidev.appsup.sarpdora.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloudDB.initDB(this)
            HomeScreen()
        }
    }
}

