package com.example.reviewretrofit

import retrofit2.Call
import retrofit2.http.GET


interface Apilnterface {
    // [] => JsonArray.. {}=> JsonObject
    @GET("posts")
    fun getData(): Call<List<MyDataItem>>
}