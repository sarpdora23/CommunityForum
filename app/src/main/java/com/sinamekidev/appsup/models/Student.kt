package com.sinamekidev.appsup.models

class Student(var name:String,
              var school:String,
              var student_class:String,
              var profile_photo:String,
              var bio:String) {

    fun changeSchool(newSchool:String){
        this.school = newSchool
    }
    fun changeClass(newClass:String){
        this.student_class = newClass
    }
    fun changeProfilePhoto(profile_photo: String){
        this.profile_photo = profile_photo
    }
    fun changeBio(bio:String){
        this.bio = bio
    }

}