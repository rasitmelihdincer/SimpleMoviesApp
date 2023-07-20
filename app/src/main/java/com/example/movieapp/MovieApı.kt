package com.example.movieapp

import android.graphics.ColorSpace.Model
import retrofit2.Call
import retrofit2.http.GET


interface MovieApı {
    @GET("Urdzik/de477f8e3d7baf4366c9d797cfe63531/raw/38c6afa2937ef222323392cc34c8c8c77e02fc40/Movie.json")
    fun getData() : Call<List<MoviesModel>>
}