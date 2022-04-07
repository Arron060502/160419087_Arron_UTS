package com.ubaya.a160419087_arron_uts.model

import com.google.gson.annotations.SerializedName

data class Books(
    val id :String?,
    @SerializedName("student_name")
    var name:String?,
    var dor:String?,
    @SerializedName("birth_of_date")
    var writer: String?,
    @SerializedName("photo_url")

    var photoURL:String?)
