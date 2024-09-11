package com.example.moviedatabase.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviedatabase.api.RetrofitInstance
import com.example.moviedatabase.data.MovieRepository
import com.example.moviedatabase.ui.screens.MovieDetailScreen
import com.example.moviedatabase.ui.screens.MovieListScreen
import com.example.moviedatabase.ui.screens.SplashScreen
import com.example.moviedatabase.ui.theme.MovieDatabaseTheme
import com.example.moviedatabase.viewmodel.MovieViewModel
import com.example.moviedatabase.viewmodel.MovieViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = RetrofitInstance.api
        val repository = MovieRepository(api)
        val factory = MovieViewModelFactory(repository)

        setContent {
            MovieDatabaseTheme {

                val navController = rememberNavController()


                val movieViewModel: MovieViewModel =
                    ViewModelProvider(this, factory).get(MovieViewModel::class.java)

                NavHost(navController = navController, startDestination = "splash") {


                    composable("splash") {
                        SplashScreen(navController = navController)
                    }

                    composable("movies") {
                        LaunchedEffect(Unit) {
                            movieViewModel.fetchPopularMovies()
                        }
                        MovieListScreen(movieViewModel = movieViewModel) {
                            navController.navigate("detail/${it.id}")
                        }
                    }

                    composable("detail/{movieId}"){
                        val movieId = it.arguments?.getString("movieId")?.toInt() ?: 0
                        MovieDetailScreen(movieId = movieId, movieViewModel = movieViewModel, navController = navController)
                    }

                }


            }
        }
    }
}

