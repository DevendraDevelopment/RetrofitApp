package com.example.retrofitapp.models

import com.google.gson.annotations.SerializedName

data class ModelPostRequest (
    @SerializedName("title"  ) var title  : String,
    @SerializedName("body"   ) var body   : String,
    @SerializedName("userId" ) var userId : Int
)
