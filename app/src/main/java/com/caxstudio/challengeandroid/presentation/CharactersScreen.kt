package com.caxstudio.challengeandroid.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersScreen(
    viewModel: CharacterViewModel,
    onCharacterDetails: (id: Int) -> Unit
) {
    val characters by viewModel.characters.observeAsState(emptyList())

    val isLoading by viewModel.isLoading.observeAsState(false)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Characters") },
                actions = {
                    IconButton(onClick = { viewModel.filterBySexMale() }) {
                        Icon(Icons.Default.Favorite, contentDescription = "Male", tint = Color.Blue)
                    }
                    IconButton(onClick = { viewModel.filterBySexFemale() }) {
                        Icon(Icons.Default.Favorite, contentDescription = "Female", tint = Color.Magenta)
                    }
                    IconButton(onClick = { viewModel.filterBySexAll()}) {
                        Icon(Icons.Default.Favorite, contentDescription = "All", tint = Color.Yellow)
                    }
                }
            )
        },
        content = {
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
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Characters(characters) {
                        onCharacterDetails(it.id)
                    }
                }
            }
        }
    )
}