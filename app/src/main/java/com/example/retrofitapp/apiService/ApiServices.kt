package com.example.retrofitapp.apiService

import com.example.retrofitapp.models.ModelFeedResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiServices {

    //https://jsonplaceholder.typicode.com/posts
    @GET("/posts")
    suspend fun getFeeds(
//        @Header("Authorization") authorization: String?
    ): Response<List<ModelFeedResponse>>


    //https://jsonplaceholder.typicode.com/posts
    @GET("/posts1")
    suspend fun getFeeds1(
//        @Header("Authorization") authorization: String?
    ): Response<List<ModelFeedResponse>>
}