package com.example.retrofitapp.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.models.ModelFeedResponse
import com.example.retrofitapp.retrofitHelper.RetrofitHelper
import com.example.retrofitapp.apiService.ApiServices
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedsViewModel : ViewModel() {

    private val _feeds = MutableLiveData<List<ModelFeedResponse>>().apply {
//        val coroutineExceptionHandler = RetrofitHelper.coroutineExceptionHandler()
        viewModelScope.launch(Dispatchers.Main) {
            val result = RetrofitHelper
                .getInstance()
                .create(ApiServices::class.java)
                .getFeeds()
            try {
                if (result.isSuccessful ) {
                    value = result.body()
                } else {
                    Log.d("SERVER_RESPONSE :: ", Gson().toJson(result.body()))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    val feeds: LiveData<List<ModelFeedResponse>> = _feeds
}