package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private val BASE_URL = "https://gist.githubusercontent.com/"
    private var movies : ArrayList<MoviesModel>? = null
    private lateinit var binding: ActivityMainBinding
    private var recyclerViewAdapter : RecyclerViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
      binding.recyclerView.layoutManager = layoutManager


        loadData()


    }

    private fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MovieApı::class.java)
        val call = service.getData()
        call.enqueue(object : Callback<List<MoviesModel>>{
            override fun onResponse(
                call: Call<List<MoviesModel>>,
                response: Response<List<MoviesModel>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        movies = ArrayList(it)
                        movies?.let {
                            recyclerViewAdapter = RecyclerViewAdapter(it)
                            binding.recyclerView.adapter = recyclerViewAdapter
                            recyclerViewAdapter!!.setOnItemClickListener(object :
                                RecyclerViewAdapter.onItemClickListener {
                                override fun onItemClick(position: Int) {
                                    val intent =
                                        Intent(this@MainActivity, DetailActivity::class.java)
                                    intent.putExtra("year", movies!![position].Year)
                                    intent.putExtra("director", movies!![position].Director)
                                    intent.putExtra("genre", movies!![position].Genre)
                                    intent.putExtra("plot", movies!![position].Plot)
                                    intent.putExtra("rating", movies!![position].imdbRating)
                                    startActivity(intent)
                                }

                            })
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<MoviesModel>>, t: Throwable) {
                println("sıkıntı var")
            }

        })

    }
}