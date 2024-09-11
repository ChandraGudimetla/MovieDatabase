package com.example.moviedatabase.data

import com.example.moviedatabase.api.ApiService
import java.lang.Exception

class MovieRepository(private val api: ApiService) {

    suspend fun getPopularMovies(apiKey: String): List<Movie> {
        return try {
            val response = api.getPopularMovies(apiKey = apiKey)
            return response.results
        } catch (e: Exception) {
            println(e.printStackTrace())
            emptyList()
        }
    }

}