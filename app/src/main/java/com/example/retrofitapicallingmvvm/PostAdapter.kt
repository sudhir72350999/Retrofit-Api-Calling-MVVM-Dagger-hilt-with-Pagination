package com.example.retrofitapicallingmvvm

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapicallingmvvm.databinding.ItemPostBinding

class PostAdapter(private var postList: List<Post>) :RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.PostViewHolder {

         val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
         return PostViewHolder(binding)

     }

     override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
         holder.bind(postList[position])

         if(position==postList.size-1){
             Log.d("PostAdapter","Reached end of the list")
             (holder.itemView.context as MainActivity)?.loadMorePosts()
         }

     }

     override fun getItemCount(): Int = postList.size

     fun updatePosts(posts: List<Post>) {
         this.postList = posts

         notifyDataSetChanged()
         Log.d("PostAdapter2", "Number of posts: ${postList.size}")
         Log.d("PhotoAdapter", "Added ${posts.size} photos")
     }








    inner class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.post = post  // Binding the Post object to the variable in XML
            binding.executePendingBindings()
            Log.v("PostAdapter".toString(),post.title)
        }
    }


}