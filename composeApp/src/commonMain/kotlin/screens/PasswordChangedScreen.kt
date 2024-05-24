package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import components.HeadingText
import org.example.project.resources.Res
import org.example.project.resources.success
import org.jetbrains.compose.resources.painterResource

@Composable
fun PasswordChangedScreen(
    navController : NavHostController
){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column (
            modifier = Modifier.fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 25.dp, bottom = 10.dp),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.success),
                contentDescription = "success",
                modifier = Modifier.height(100.dp)
                    .width(100.dp)
            )

            HeadingText("Password Changed!")
            Text(
                text= "Your password has been changed \nsuccessfully.",
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {

                },
                modifier = Modifier.fillMaxWidth()
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(Color.Black.copy(alpha = 0.9f)),
                shape = RoundedCornerShape(5.dp)
            ){
                Text(
                    text = "Back to Login",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                )
            }
        }
    }

}