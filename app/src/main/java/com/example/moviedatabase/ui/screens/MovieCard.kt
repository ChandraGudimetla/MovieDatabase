package com.example.moviedatabase.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.moviedatabase.data.Movie
import com.example.moviedatabase.viewmodel.MovieViewModel

@Composable
fun MovieCard(movie: Movie, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${movie.poster_path}",
                contentDescription = movie.title,
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.padding(top = 20.dp)) {
                Text(text = movie.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(2.dp))
                Text(text = movie.release_date, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(2.dp))
                Text(text = movie.vote_count, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

        }
    }
}

@Composable
fun MovieListScreen(movieViewModel: MovieViewModel, onMovieClick: (Movie) -> Unit) {
    val movies = movieViewModel.movies.collectAsStateWithLifecycle().value

    LazyColumn(modifier = Modifier.background(Color.Magenta)) {
        items(movies) {
            MovieCard(movie = it, onClick = { onMovieClick(it) })
        }
    }


}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    MovieCard(
        movie = Movie(
            id = 1,
            overview = "Overview",
            release_date = "09-17-2024",
            title = "Title",
            vote_count = "2000",
            poster_path = "path///",
            backdrop_path = "back drop path"
        )
    ) {
    }
}

