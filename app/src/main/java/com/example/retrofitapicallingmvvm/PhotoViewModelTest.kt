//package com.example.retrofitapicallingmvvm
//
//import android.provider.ContactsContract
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import androidx.lifecycle.Observer
//import org.junit.Assert.assertEquals
//import org.junit.Rule
//import org.junit.Test
//import org.mockito.ArgumentMatchers.any
//import org.mockito.Mockito.mock
//import org.mockito.Mockito.verify
//import org.mockito.Mockito.`when`
//import org.mockito.Mockito.*
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class PhotoViewModelTest {
//
//    @get:Rule
//    val instantExecutorRule = InstantTaskExecutorRule()
//
//    private val apiService: ApiService = mock(ApiService::class.java)
//    private val viewModel = PostViewModel(apiService)
//
//    @Test
//    fun fetchPhotos_updatesLiveData() {
//        // Prepare mock response
//        val mockPhotos = listOf(Post(1, 2, "",""))
//        val call = mock(Call::class.java) as Call<List<Post>>
//        `when`(apiService.getPosts(1, 20)).thenReturn(call)
//        `when`(call.enqueue(any())).thenAnswer {
//            val callback = it.getArgument<Callback<List<ContactsContract.Contacts.Photo>>>(0)
//            callback.onResponse(call, Response.success(mockPhotos))
//        }
//
//        // Observe LiveData
//        val observer: Observer<List<Post>> = mock()
//        viewModel.posts.observeForever(observer)
//
//        // Trigger fetch
//        viewModel.fetchPosts()
//
//        // Verify results
//        verify(observer).onChanged(mockPhotos)
//        assertEquals(1, viewModel.posts.value?.size)
//    }
//
//
//
//
//}
//
//
//
//
//
//
