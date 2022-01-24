package com.example.appmovies.services

import android.widget.ImageView
import com.squareup.picasso.Picasso

class Utils {
    companion object
    {
        var bearerToken:String = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1M2Y1N2M1ZDIyYzc5M2Q0ZWQ2YTg3YTYxNWEwYjZkZSIsInN1YiI6IjYxZWQ2ODQwNmQ0Yzk3MDAxYjU2YTdkOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.fBBrWba_3v4eWqOyZflMIbjsF-_W5bvgudRaP6_2J1c"
        var imagesMoviePath:String = "https://image.tmdb.org/t/p/{0}/{1}"


        fun ImageView.fromUrl(url:String){
            Picasso.get().load(url).into(this)
        }
        fun getCompleteMovieImagePath(moviePath:String, movieSize:String):String{
            return "https://image.tmdb.org/t/p/$movieSize/$moviePath";
        }
    }

    enum class backdrop_sizes{
        w300,
        w500
    }
}