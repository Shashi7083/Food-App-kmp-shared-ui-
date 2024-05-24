package screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import components.BottomBar
import org.example.project.resources.Res
import org.example.project.resources.homeselected
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeScreen(
    navController : NavHostController
){
    var needLunch by remember { mutableStateOf(true) }


    Scaffold(
        bottomBar = {
            BottomBar(navController =  navController)
        }
    ) {
        Box(modifier =  Modifier.padding(it).fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(Res.drawable.homeselected),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.size(100.dp)
            )
        }
    }
}