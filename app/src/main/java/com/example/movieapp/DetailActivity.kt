package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    private lateinit var film : ArrayList<MoviesModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }

    private fun getData(){

        binding.movieYear.text = intent.getIntExtra("year",0).toString()
        binding.movieDirector.text = intent.getStringExtra("director")
        binding.movieGenre.text = intent.getStringExtra("genre")
        binding.moviePlot.text = intent.getStringExtra("plot")
        binding.movieImbd.text = intent.getDoubleExtra("rating",0.0).toString()

    }
}