package screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import getPlatform
import org.example.project.resources.Res
import org.example.project.resources.welcome1
import org.example.project.resources.welcome2
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import screenRoutes.BottomNavScreen
import screenRoutes.Routes


@Composable
fun WelcomeScreen(
    navController : NavHostController
){

    val platform = getPlatform()

    val img1 = "https://thumbs.dreamstime.com/b/art-illustration-203657393.jpg"
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                top = 25.dp,
                bottom = 15.dp,
                start = 20.dp,
                end = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        EmojiText("🤩 Free Delivery","🏠 Homemade")

        //Spacer(modifier = Modifier.fillMaxHeight(0.1f))

        WelcomeImage(Res.drawable.welcome2,"")

        //Spacer(modifier = Modifier.fillMaxHeight(0.1f))

        EmojiText("🟢 Pure veg","👍🏻 Quality assurance")

        //Spacer(modifier = Modifier.fillMaxHeight(0.1f))

        WelcomeImage(Res.drawable.welcome1,"")

        //Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        LoginRegister(navController = navController)

        Spacer(modifier = Modifier.fillMaxHeight(0.2f))

        Text(
            text = "Continue as a guest",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xff35c2c1)
            ),
            modifier =  Modifier
                .clickable (
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = {
                        navController.navigate(BottomNavScreen.HomeScreen.route){
                            popUpTo(BottomNavScreen.HomeScreen.route){
                                inclusive = true
                            }
                        }
                    }
                )
        )

        Spacer(modifier = Modifier.fillMaxHeight(0.13f))


    }
}


@Composable
fun EmojiText(
    text : String,
    text1 : String
){
    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = text,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
        )

        Text(
            text = text1,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
        )
    }
}

@Composable
fun WelcomeImage(
    image: DrawableResource,
    desc: String
){

        Image(
            painter =  painterResource(image ),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .padding(8.dp, top = 10.dp),
            contentDescription = desc,
            contentScale = ContentScale.Fit
        )


}


@Composable
fun LoginRegister(
    navController: NavHostController
){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = {
                navController.navigate(route = Routes.LoginScreen.route){
                    popUpTo(route = Routes.LoginScreen.route){
                        inclusive = true
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(Color.Black.copy(alpha = 0.9f)),
            shape = RoundedCornerShape(14.dp)
        ){
            Text(
                text = "Login",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                    navController.navigate(route = Routes.RegisterScreen.route){
                        popUpTo(route = Routes.RegisterScreen.route){
                            inclusive = true
                        }
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            border = BorderStroke(2.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(14.dp)
        ){
            Text(
                text = "Register",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,

                )
            )
        }
    }
}


