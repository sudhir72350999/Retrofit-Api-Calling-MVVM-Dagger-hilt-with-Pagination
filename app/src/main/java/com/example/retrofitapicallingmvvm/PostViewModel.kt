package com.example.retrofitapicallingmvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
    val posts: MutableLiveData<List<Post>> = MutableLiveData()

    private var currentPage = 1
    private var isLoading = false
    private val perPage = 20


    fun fetchPosts() {

        if (isLoading) return
        isLoading = true

        Log.v("PhotoViewModel", "Fetching page $currentPage")
        // Simulating an API call, replace this with actual Retrofit call
        apiService.getPosts(currentPage, perPage).enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    posts.value = response.body()
                    currentPage++
                    Log.v(
                        "PhotoViewModel",
                        "Page $currentPage fetched successfully"
                    )// Update LiveData with the response
//                    Log.d("PhotoViewModel", "Fetched ${posts} photos for page $currentPage")

                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                isLoading = false
                Log.e("PhotoViewModel", "Failed to fetch photos", t)
                // Handle failure
            }
        })
    }

}

