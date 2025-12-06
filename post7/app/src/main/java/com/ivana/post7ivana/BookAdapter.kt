package com.ivana.post7ivana

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ivana.post7ivana.databinding.ItemBookBinding


class BookAdapter(
    private var list: List<Book>,
    private val onClick: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.txtTitle.text = book.title ?: "No Title"
            binding.txtRelease.text = book.releaseDate ?: "-"

            Glide.with(itemView.context)
                .load(book.cover)
                .centerCrop()
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(binding.imgCover)

            binding.root.setOnClickListener { onClick(book) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}