package com.caxstudio.challengeandroid.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale

@Composable
fun CharacterImage(imageUrl: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Create an AsyncImagePainter that loads the image from the given URL
        val painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current).data(data = imageUrl)
                .apply(block = fun ImageRequest.Builder.() {
                    // Set crossfade to true to animate the transition when the image loads
                    crossfade(true)
                    // Set the scale to FIT to ensure the entire image fits inside the bounds
                    scale(Scale.FIT)
                }).build()
        )

        // Show a color placeholder if the image is not available
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (painter.state is AsyncImagePainter.State.Error) {
                // If the painter is in an error state, show a gray box as a placeholder
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Gray)
                )
            }
        }

        // Show the image, using the painter created earlier
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}