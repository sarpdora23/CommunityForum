package com.sinamekidev.appsup.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.sinamekidev.appsup.models.Posts

object DummyDataSource {
    var homePostList = mutableStateListOf<Posts>()

    fun getPosts():SnapshotStateList<Posts>{
        return homePostList
    }
    fun addPost(newPost:Posts){
        homePostList.add(newPost)
    }
}