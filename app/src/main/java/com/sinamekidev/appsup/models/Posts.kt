package com.sinamekidev.appsup.models

data class Posts(
    var user:User,
    var imageId:Int?,
    var text:String?,
    var likeCount:Int = 0,
)