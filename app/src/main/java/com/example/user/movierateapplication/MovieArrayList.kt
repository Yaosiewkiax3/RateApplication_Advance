package com.example.user.movierateapplication

import android.app.Application

class MovieArrayList: Application() {
    var movieAL = ArrayList<Movie>()

    init{
        this.movieAL = arrayListOf<>()
    }

    fun AddMovie(movie: Movie){
        this.movieAL.add(movie)
    }

    fun getMovies():ArrayList<Movie>{
        return this.movieAL
    }
}