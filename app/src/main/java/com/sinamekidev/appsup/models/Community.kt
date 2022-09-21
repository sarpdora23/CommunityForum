package com.sinamekidev.appsup.models

class Community (var name:String,
                 val school:String,
                 var introduction:String,
                 var president:Student,
                 var LogoUrl:String){
    var studentList:ArrayList<Student> = ArrayList()

    fun changeName(newName:String){
        this.name = newName
    }
    fun changeIntroduction(newIntro:String){
        this.introduction = newIntro
    }
    fun changePresident(newPresident:Student){
        this.president = newPresident
    }
    fun addMember(newMember: Student){
        studentList.add(newMember)
    }
    fun removeMember(oldMember:Student){
        studentList.remove(oldMember)
    }
    fun changeLogo(newLogoUrl:String){
        this.LogoUrl = newLogoUrl
    }
}
