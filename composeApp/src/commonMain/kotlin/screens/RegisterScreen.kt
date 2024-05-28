package screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import components.GoBack
import components.HeadingText
import components.RegisterForm
import screenRoutes.Routes

@Composable
fun RegisterScreen(
    navController: NavHostController
){
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 25.dp, bottom = 10.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        GoBack(navController = navController)

        HeadingText(text = "Hello! Register to get Started")

        RegisterForm(navController = navController)

        Spacer(modifier = Modifier.height(10.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Already have an accoutn? ",
            )
            Text(
                text = "Login Now",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xff35c2c1)
                ),
                modifier = Modifier.clickable (
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = {
                        navController.navigate(Routes.LoginScreen.route){
                            popUpTo(Routes.LoginScreen.route){
                                inclusive = true
                            }
                        }
                    }
                )
            )
        }
    }

}
