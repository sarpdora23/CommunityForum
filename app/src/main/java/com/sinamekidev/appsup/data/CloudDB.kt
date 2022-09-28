package com.sinamekidev.appsup.data

import android.content.Context
import android.os.Handler
import com.huawei.agconnect.AGConnectInstance
import com.huawei.agconnect.auth.AGConnectAuth
import com.huawei.agconnect.cloud.database.*
import com.huawei.agconnect.cloud.database.exceptions.AGConnectCloudDBException
import com.sinamekidev.appsup.models.ObjectTypeInfoHelper
import com.sinamekidev.appsup.models.User
import com.sinamekidev.appsup.models.UserDBInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object CloudDB {
    var mCloudDBZone: CloudDBZone? = null
    private lateinit var mRegister: ListenerHandler
    private lateinit var mConfig:CloudDBZoneConfig
    private lateinit var mUiCallBack:UserDBInterface
    private lateinit var mCloudDB:AGConnectCloudDB
    fun initAGConnectCloudDB(context: Context){
        AGConnectCloudDB.initialize(context)
        try {
            mCloudDB = AGConnectCloudDB.getInstance(AGConnectInstance.getInstance(), AGConnectAuth.getInstance())
        }catch (e:Exception){
            println(e.localizedMessage)
        }

    }
    fun createObjectType(){
        try {
            mCloudDB.createObjectType(ObjectTypeInfoHelper.getObjectTypeInfo())

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
            mCloudDBZone = mCloudDB.openCloudDBZone(mConfig, true);
        } catch (e: AGConnectCloudDBException) {
            println(e.localizedMessage)
        }
    }
    fun closeCloudDbZone(){
        try {
            mCloudDB.closeCloudDBZone(mCloudDBZone);
        }catch (e:Exception){
            println(e.localizedMessage)
        }
    }

    fun addCallBacks(userDBInterface: UserDBInterface){
        mUiCallBack  = userDBInterface
    }
    fun insertUser(user:User){
        var state = false
        if(mCloudDBZone == null){
            println("CLOUDZONE NULL")
            return
        }
        var upsertTask = mCloudDBZone!!.executeUpsert(user)
        if(mUiCallBack == null){
            println("UI CALLBACK NULL")
            return
        }
        upsertTask.addOnCompleteListener {
            if (it.isSuccessful){
                state = true
            }
            else{
                println(it.exception)
                state = false
            }

        }
        if (mUiCallBack != null) {
            mUiCallBack.isDataUpsert(state);
        }
    }
    fun getAllUsers(){
        if (mCloudDBZone == null) {
            println("GET USER DETAIL : CloudDBZone is null, try re-open it");
            return;
        }
        var queryTask = mCloudDBZone!!.executeQuery(CloudDBZoneQuery.where(User::class.java),CloudDBZoneQuery.CloudDBZoneQueryPolicy.POLICY_QUERY_FROM_CLOUD_ONLY)
        queryTask.addOnCompleteListener {
            if (it.isSuccessful){
                userListResult(it.result)
            }
            else{
                println(it.exception)
            }
        }

    }
    fun userListResult(snapshot: CloudDBZoneSnapshot<User>){
        var userCursor = snapshot.snapshotObjects
        var userList = ArrayList<User>()
        try {
            while (userCursor.hasNext()){
                var user = userCursor.next()
                userList.add(user)
                println(user.name)
            }

        }catch (e:Exception){
            println(e.localizedMessage)
        }
        snapshot.release()
        if(mUiCallBack != null){
            mUiCallBack.onAddOrQuery(userList)
        }
    }
    fun initDB(context: Context){
        GlobalScope.launch(Dispatchers.IO){
            initAGConnectCloudDB(context)
            createObjectType()
            openCloudDbZone()
            getAllUsers()
            closeCloudDbZone()
        }
    }
}
