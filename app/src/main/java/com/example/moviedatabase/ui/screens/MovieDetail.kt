package com.example.moviedatabase.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.moviedatabase.data.Movie
import com.example.moviedatabase.viewmodel.MovieViewModel

@Composable
fun MovieDetailScreen(movieId: Int, movieViewModel: MovieViewModel, navController: NavController) {
    val movies by movieViewModel.movies.collectAsState()

    val movie = movies.find { it.id == movieId }

    movie?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Button(onClick = {
                navController.popBackStack()
            }) {
                Text(text = "Back")
            }

            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500/${it.poster_path}",
                contentDescription = it.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = it.title, style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = it.overview, style = MaterialTheme.typography.bodySmall)


        }
    }

}
