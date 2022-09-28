package com.sinamekidev.appsup.models

interface UserDBInterface {
    fun onAddOrQuery(userList: List<User?>?) //Veri çekerken.

    fun isLastID(lastID: Int) // ID bilgisini almak için.

    fun isDataUpsert(state: Boolean?) // Veri eklerken

}