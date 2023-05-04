package com.caxstudio.challengeandroid

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.caxstudio.challengeandroid.presentation.CharacterDetailsDialog
import com.caxstudio.challengeandroid.presentation.CharacterViewModel
import com.caxstudio.challengeandroid.presentation.CharactersScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: CharacterViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "characters") {
                composable("characters") {
                    CharactersScreen(viewModel) {
                        navController.navigate("detail/${it}")
                    }
                }
                composable(
                    route = "detail/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.IntType })
                ) {
                    val id = it.arguments?.getInt("id") ?: 0
                    CharacterDetailsDialog(viewModel, id) {
                        navController.popBackStack()
                    }
                }
            }
        }
    }
}