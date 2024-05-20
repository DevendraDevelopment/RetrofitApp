package com.example.retrofitapp.apiService

import com.example.retrofitapp.models.ModelFeedResponse
import com.example.retrofitapp.models.ModelPostRequest
import com.example.retrofitapp.models.ModelPostResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiServices {

    //https://jsonplaceholder.typicode.com/posts
    @GET("/posts")
    suspend fun getFeeds(
//        @Header("Authorization") authorization: String?
    ): Response<List<ModelFeedResponse>>

    @POST("/posts")
    suspend fun createPost(@Body newPost: ModelPostRequest): Response<ModelPostResponse>

}