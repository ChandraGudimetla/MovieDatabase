package com.example.moviedatabase.data


data class MovieResponse(val results: List<Movie>)

data class Movie(
    val id: Int,
    val overview: String,
    val release_date: String,
    val title: String,
    val vote_count: String,
    val poster_path: String,
    val backdrop_path: String
)