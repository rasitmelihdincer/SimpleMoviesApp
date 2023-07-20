package com.example.movieapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.databinding.RecyclerRowBinding


class RecyclerViewAdapter(private val movieList : ArrayList<MoviesModel>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    private lateinit var binding : RecyclerRowBinding
    private lateinit var listener : onItemClickListener

    class MyViewHolder(var binding: RecyclerRowBinding,clickListener: onItemClickListener) : RecyclerView.ViewHolder(binding.root){
        fun bind(movieModel : MoviesModel){
            binding.movieName.text = movieModel.Title
            Glide.with(binding.root)
                .load(movieModel.Poster)
                .into(binding.movieImage)

        }
        init {  binding.detailButton.setOnClickListener {
            clickListener.onItemClick(bindingAdapterPosition)
        }


        }

    }

    interface onItemClickListener{
            fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(clickListener : onItemClickListener){
            listener = clickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding, listener)

    }


    override fun getItemCount(): Int {
      return  movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])


    }

}