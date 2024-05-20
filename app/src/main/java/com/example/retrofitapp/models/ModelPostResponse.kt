package com.example.retrofitapp.models

import com.google.gson.annotations.SerializedName

data class ModelPostResponse (
    @SerializedName("title"  ) var title  : String,
    @SerializedName("body"   ) var body   : String,
    @SerializedName("userId" ) var userId : Int,
    @SerializedName("id"     ) var id     : Int
)