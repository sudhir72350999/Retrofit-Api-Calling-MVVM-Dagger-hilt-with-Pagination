package com.example.retrofitapicallingmvvm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapicallingmvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val postViewModel: PostViewModel by viewModels()
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Correct binding initialization

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel=postViewModel

        binding.lifecycleOwner = this
        postAdapter = PostAdapter(emptyList())
        binding.recyclerView.adapter = postAdapter

        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        postViewModel.posts.observe(this) { posts ->
            postAdapter.updatePosts(posts)
        }
        postViewModel.fetchPosts()



    }

    fun loadMorePosts() {
        postViewModel.fetchPosts()
    }
}
