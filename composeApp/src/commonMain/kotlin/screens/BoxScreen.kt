package screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import components.BottomBar

@Composable
fun BoxScreen(
    navController : NavHostController
){

    Scaffold(
        bottomBar = {
            BottomBar(navController =  navController)
        }
    ) {

    }
}