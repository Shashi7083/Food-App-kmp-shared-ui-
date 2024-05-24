package components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.LocalAbsoluteElevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.jetbrains.compose.resources.painterResource
import screenRoutes.BottomNavScreen

@Composable
fun BottomBar(
    navController : NavHostController
){

    val screens = listOf(
        BottomNavScreen.HomeScreen,
        BottomNavScreen.BoxScreen,
        BottomNavScreen.PaymentScreen
    )

    val backStackEntry = navController.currentBackStackEntryAsState().value
    val selectedScreen = backStackEntry?.destination?.route

    BottomNavigation(
        modifier = Modifier.height(83.dp),
        backgroundColor = Color.White,
        elevation = 15.dp
    ){
        screens.forEachIndexed { index, screen ->
            BottomNavigationItem(
                selected =  selectedScreen.equals(screen.route),
                onClick = {
                    navController.navigate(screen.route){
                        popUpTo(screen.route){
                            inclusive = true
                        }
                    }
                },
                icon = {
                    Column (
                        modifier = Modifier.height(80.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ){

                        if(selectedScreen.equals(screen.route)){
                            AnimatedVisibility(true){
                                Icon(
                                    painter = painterResource(screen.selectedIcon),
                                    contentDescription = "selected icon"
                                )
                            }
                        }else{
                            AnimatedVisibility(true){
                                Icon(
                                    painter = painterResource(screen.unselectedIcon),
                                    contentDescription = "selected icon"
                                )
                            }
                        }

                        Text(
                            text = screen.name,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if(selectedScreen.equals(screen.route)) Color(0xffff3d00) else Color(0xff1e232c)
                            )
                        )



                    }
                }
            )
        }
    }




}