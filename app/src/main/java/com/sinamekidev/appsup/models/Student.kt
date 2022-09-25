package com.sinamekidev.appsup.models

import java.util.*

data class Student(
    var User:User, var school:String,
    var student_class:String,
    ):User(User.name, User.uid,User.profile_photo,User.bio) {

}