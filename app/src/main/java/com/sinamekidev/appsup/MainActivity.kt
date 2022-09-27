package com.sinamekidev.appsup

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.huawei.agconnect.AGCRoutePolicy
import com.huawei.agconnect.AGConnectInstance
import com.huawei.agconnect.AGConnectOptions
import com.huawei.agconnect.AGConnectOptionsBuilder
import com.huawei.agconnect.auth.AGConnectAuth
import com.huawei.agconnect.cloud.database.*
import com.huawei.agconnect.cloud.database.exceptions.AGConnectCloudDBException
import com.sinamekidev.appsup.data.DummyDataSource
import com.sinamekidev.appsup.models.Posts
import com.sinamekidev.appsup.models.Student
import com.sinamekidev.appsup.models.User
import com.sinamekidev.appsup.onuralan.LoginScreen
import com.sinamekidev.appsup.sarpdora.HomeScreen
import com.sinamekidev.appsup.ui.theme.AppSupTheme
import java.util.*

class MainActivity : ComponentActivity() {
    private lateinit var mCloudDBZone:CloudDBZone
    private lateinit var mRegister: ListenerHandler
    private lateinit var mConfig:CloudDBZoneConfig
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {



            HomeScreen()
        }
    }
    fun initAGConnectCloudDB(context: Context){
        AGConnectCloudDB.initialize(context)
        println(CloudDBZoneWrapper.mCloudDB.cloudDBZoneConfigs.get(0).cloudDBZoneName + ":initAGConnectCloudDB" )
    }
    fun createObjectType(){
        try {
            CloudDBZoneWrapper.mCloudDB.createObjectType(ObjectTypeInfo())

        }catch (e:Exception){
            println(e.localizedMessage)
        }
    }
    fun openCloudDbZone(){
        mConfig = CloudDBZoneConfig("Zone1",
            CloudDBZoneConfig.CloudDBZoneSyncProperty.CLOUDDBZONE_CLOUD_CACHE,
            CloudDBZoneConfig.CloudDBZoneAccessProperty.CLOUDDBZONE_PUBLIC)
        mConfig.persistenceEnabled = true
        try {
            mCloudDBZone = CloudDBZoneWrapper.mCloudDB.openCloudDBZone(mConfig, true);
        } catch (e: AGConnectCloudDBException) {
           println(e.localizedMessage)
        }
    }
    fun closeCloudDbZone(){
        try {
            CloudDBZoneWrapper.mCloudDB.closeCloudDBZone(mCloudDBZone);
        }catch (e:Exception){
            println(e.localizedMessage)
        }
    }
    object  CloudDBZoneWrapper{
        var mCloudDB = AGConnectCloudDB.getInstance()

    }
}

