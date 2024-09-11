package com.example.moviedatabase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedatabase.data.Movie
import com.example.moviedatabase.data.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class MovieViewModel(private val movieRepository: MovieRepository): ViewModel() {

   private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies : StateFlow<List<Movie>> = _movies

    init {
        fetchPopularMovies()
    }

    fun fetchPopularMovies(){
        viewModelScope.launch {
            val result = movieRepository.getPopularMovies("0eff3f792b957008c042369a70c145c9")
            _movies.value = result
        }
    }
}