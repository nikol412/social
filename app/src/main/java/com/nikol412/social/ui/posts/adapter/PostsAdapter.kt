package com.nikol412.social.ui.posts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nikol412.social.databinding.ItemPostBinding
import com.nikol412.social.ui.posts.PostItemUI

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {
    private var itemsList = listOf<PostItemUI>()

    override fun getItemCount(): Int = itemsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.onBind(itemsList[position])
    }

    inner class PostViewHolder(itemView: ItemPostBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun onBind(item: PostItemUI) {

        }
    }

    fun swapItems(newItems: List<PostItemUI>) {
        itemsList = newItems
        notifyDataSetChanged()
    }
}