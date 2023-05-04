package com.caxstudio.challengeandroid.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.caxstudio.challengeandroid.domain.model.Character
import com.caxstudio.challengeandroid.domain.model.Status

/**

Composable function that displays a list of [Character] objects in a vertical grid layout.
@param characters A list of [Character] objects to display.
@param onCharacterClick A callback function to handle click events on a [Character] item.
 */
@Composable
fun Characters(characters: List<Character>, onCharacterClick: (character: Character) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(characters) { character ->
// Call the CharacterItem composable to display each character in the list
            CharacterItem(character = character, onItemClick = { clickedCharacter ->
                onCharacterClick(clickedCharacter)
            })
        }
    }
}

// Define a composable function that displays a character item
@Composable
fun CharacterItem(
    character: Character,
    onItemClick: (Character) -> Unit
) {
    // Display a card that can be clicked to select a character
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(character) },
        shape = RoundedCornerShape(8.dp),
    ) {
        // Display a column that contains the character's information
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display the character's status and gender in a row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Display the character's status as a badge wrapped in a Surface
                Surface(
                    shape = CircleShape,
                    modifier = Modifier.size(24.dp),
                    color = when (character.status.value) {
                        Status.ALIVE -> Color(0xFF51924E)
                        Status.DEAD -> Color(0xFF696969)
                        Status.UNKNOWN -> Color(0xFFFFFFFF)
                        else -> Color.Transparent // Make sure to always return a value of type Color
                    }
                ) {}
                // Add some space between the circle and the character's gender
                Spacer(modifier = Modifier.width(8.dp))

                // Display the character's status value in a larger and bolder font
                Text(
                    text = character.status.value,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

            }
            // Add some space between the image and the character's name
            Spacer(modifier = Modifier.height(8.dp))

            // Display the character's image
            AsyncImage(
                model = character.imageUrl,
                contentDescription = "Character ${character.name} image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(shape = RoundedCornerShape(8.dp))
            )

            // Add some space between the image and the character's name
            Spacer(modifier = Modifier.height(8.dp))

            // Display the character's name
            Text(
                text = character.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).align(CenterHorizontally),
                textAlign = TextAlign.Center
            )

            // Add some space between the character's name and the character's status and gender
            Spacer(modifier = Modifier.height(4.dp))

            // Display the character's gender value in a larger and bolder font
            Text(
                text = character.gender.value,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}