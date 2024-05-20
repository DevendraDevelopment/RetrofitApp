package com.example.retrofitapp.retrofitHelper

import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineExceptionHandler
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitHelper {

    private var baseUrl = "https://jsonplaceholder.typicode.com/"

    fun getInstance(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.NONE
        logging.level = HttpLoggingInterceptor.Level.BODY
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY//remove in release version
        interceptor.level = logging.level

        val client = OkHttpClient.Builder().apply {

            addInterceptor(interceptor)
            addInterceptor { chain ->
                var request = chain.request()
                request = request.newBuilder().build()
                val response = chain.proceed(request)
                response
            }
        }

        val gson = GsonBuilder().disableHtmlEscaping().create()


        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client.build())
            .build()
    }


    fun coroutineExceptionHandler(): CoroutineExceptionHandler {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }
        return coroutineExceptionHandler
    }

}