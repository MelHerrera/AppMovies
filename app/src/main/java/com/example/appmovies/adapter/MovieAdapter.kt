package com.example.appmovies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appmovies.R
import com.example.appmovies.dto.ResponseMovie
import com.example.appmovies.services.Utils
import com.example.appmovies.services.Utils.Companion.fromUrl
import com.example.appmovies.services.Utils.Companion.getCompleteMovieImagePath

class PopularMoviesAdapter(private val movies: ArrayList<ResponseMovie>): RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        private val movieTitle: TextView = itemView.findViewById(R.id.vMovieTitle)
        private val moviePoster:ImageView = itemView.findViewById(R.id.vPoster)

        fun bindItem(movie: ResponseMovie){
//            movieTitle.text = movie.title
            val completePath = getCompleteMovieImagePath(movie.poster, Utils.backdrop_sizes.w500.toString())
            moviePoster.fromUrl(completePath)
        }
    }
}