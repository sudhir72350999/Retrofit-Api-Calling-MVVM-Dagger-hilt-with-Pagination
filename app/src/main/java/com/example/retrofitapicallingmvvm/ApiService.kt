package com.example.retrofitapicallingmvvm

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface ApiService {
    @GET("posts")
    fun getPosts(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int

    ): Call<List<Post>>

}