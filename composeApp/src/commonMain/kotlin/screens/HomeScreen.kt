package screens


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import components.BottomBar
import components.HomeHeader
import components.NeedLunch
import components.OffersAndMenu
import components.OrderForFriend
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

            Column(
                modifier =  Modifier.fillMaxSize()
                    .padding(it)

            ) {
                HomeHeader()

                Column(
                    modifier =  Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    NeedLunch {
                        needLunch = it
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    OrderForFriend(navController =  navController)
                    Spacer(modifier = Modifier.height(40.dp))
                    OffersAndMenu(navController = navController)
                }

            }

    }
}



