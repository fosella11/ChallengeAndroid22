package com.caxstudio.challengeandroid.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil.compose.AsyncImage
import com.caxstudio.challengeandroid.domain.model.CharacterDetailsExtended
import com.caxstudio.challengeandroid.domain.model.Episode

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailsDialog(viewModel: CharacterViewModel, id: Int, onBack: () -> Unit) {
    val characterDetails by viewModel.characterDetails.observeAsState()
    viewModel.getCharacterDetails(id)

    val isLoading by viewModel.isLoading.observeAsState(true)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = characterDetails?.character?.name ?: "Character details") },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        if (isLoading) {
            // Muestra el loading mientras se espera que lleguen los datos
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                CircularProgressIndicator()
            }
        } else {
            characterDetails?.let { CharacterDetails(it) }
        }
    }
}

@Composable
fun CharacterDetails(details: CharacterDetailsExtended) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 16.dp)
    ) {
        // Imagen del personaje
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.2f)
        ) {
            CharacterImage(imageUrl = details.character.imageUrl)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 0f,
                            endY = 900f
                        )
                    ),
                verticalArrangement = Arrangement.Bottom,
            ) {
                // Nombre del personaje
                Text(
                    text = details.character.name,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
                )
            }
        }
        // Ubicación del personaje
        Text(
            text = "Location: ${details.location}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Light,
            color = Color.Gray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 8.dp
                )
        )
        // Lista de episodios
        Text(
            text = "Episodes:",
            fontSize = 16.sp,
            fontWeight = FontWeight.Light,
            color = Color.Gray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = 8.dp
            )
        )
        LazyColumn(modifier = Modifier.padding(start = 16.dp)) {
            items(details.episodes) { episode ->
                EpisodeItem(episode = episode)
            }
        }
    }
}

@Composable
fun EpisodeItem(episode: Episode) {
    Row(modifier = Modifier.padding(bottom = 8.dp)) {
        Text(
            text = episode.id,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            color = Color.Gray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        )
        Text(
            text = episode.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            color = Color.Gray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        )
        Text(
            text = episode.releaseDate,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            color = Color.Gray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )
    }
}
