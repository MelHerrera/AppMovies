package com.example.appmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmovies.adapter.PopularMoviesAdapter
import com.example.appmovies.databinding.ActivityMainBinding
import com.example.appmovies.dto.ResponseMovie
import com.example.appmovies.dto.ResponsePopularMovies
import com.example.appmovies.network.ApiAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getPopularMovies()
    }

    private fun getPopularMovies(){
        lateinit var apiResponse: Response<ResponsePopularMovies>

        lifecycleScope.launch {
            withContext(Dispatchers.IO)
            {
                try {
                    apiResponse = ApiAdapter.apiClient.getPopularMovies()
                } catch (e: Exception) {
                    withContext(Dispatchers.Main){
                        Toast.makeText(applicationContext, e.message, Toast.LENGTH_LONG).show()//creo que se debe cambiar al Dispatcher.Main sino el toast causara una exepcion
                    }
                }
            }

            if(apiResponse.isSuccessful && apiResponse.code() ==200 )
                apiResponse.body()?.results?.let { mostrarPopularMovies(it) }
            else
                Toast.makeText(applicationContext, apiResponse.message(), Toast.LENGTH_LONG).show()
        }
    }

    private fun mostrarPopularMovies(popularMovies:ArrayList<ResponseMovie>){
        val mLayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false )
        binding.vRecyclerPopularMovies.layoutManager = mLayoutManager
        binding.vRecyclerPopularMovies.adapter = PopularMoviesAdapter(popularMovies)
    }
}