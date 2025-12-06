package com.ivana.post7ivana

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ivana.post7ivana.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val releaseDate = intent.getStringExtra("releaseDate")
        val description = intent.getStringExtra("description")
        val cover = intent.getStringExtra("cover")

        binding.txtDetailTitle.text = title
        binding.txtDetailRelease.text = releaseDate
        binding.txtDetailDesc.text = description

        Glide.with(this)
            .load(cover)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .into(binding.imgDetailCover)
    }
}