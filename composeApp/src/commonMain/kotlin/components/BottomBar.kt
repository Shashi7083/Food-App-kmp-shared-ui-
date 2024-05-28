package components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.LocalAbsoluteElevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import screenRoutes.Routes

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
        modifier = Modifier.height(73.dp),
        backgroundColor = Color.White,
        elevation = 15.dp
    ){
        screens.forEachIndexed { index, screen ->
            BottomNavigationItem(
                selected =  selectedScreen.equals(screen.route),
                onClick = {
                    if(!selectedScreen.equals(screen.route)){
                        navController.navigate(screen.route){
                            popUpTo(screen.route){
                                inclusive = true
                            }
                        }
                    }

                },
                icon = {
                    Column (
                        modifier = Modifier.padding(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ){

                        AnimatedVisibility(selectedScreen.equals(screen.route) ){
                            Box(
                                modifier = Modifier
                                    .height(10.dp)
                                    .fillMaxWidth(0.35f)
                                    .background(Color(0xff7356bf), shape = RoundedCornerShape(bottomStart = 5.dp, bottomEnd = 5.dp))
                            )
                        }




                        Icon(
                            painter = if(selectedScreen.equals(screen.route)) painterResource(screen.selectedIcon) else painterResource(screen.unselectedIcon),
                            contentDescription = "selected icon",
                            tint = Color.Unspecified,
                            modifier = Modifier.width(30.dp).height(30.dp)
                        )



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