package screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import components.GoBack
import components.HeadingText
import components.RegisterForm

@Composable
fun ForgotPasswordScreen(
    navController: NavHostController
){


    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier.fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 25.dp, bottom = 10.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        GoBack()

        HeadingText(text = "Hello! Register to get Started")

        Text(
            text = "Don't worry! It occurs. Please enter the email address linked with your account.",
            style = TextStyle(
                color = Color(0xff808080)
            )
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                if(components.isValidEmail(email)){
                    emailError = false
                }
            },
            modifier = Modifier.fillMaxWidth()
                .background(Color(0xfff7f8f9)),
            placeholder = {
                Text(
                    text = "Enter your email"
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction =  ImeAction.Done
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = if(emailError) Color.Red else Color(0xffe8ecf4),
                focusedBorderColor = if(emailError) Color.Red else Color(0xff7356bf)

            ),
            trailingIcon = {
                if(emailError){
                    Icon(
                        imageVector = Icons.Default.Warning,
                        tint = Color.Red,
                        contentDescription = ""
                    )
                }

            }
        )


        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = {
                if(!components.isValidEmail(email)){
                    emailError = true
                }
            },
            modifier = Modifier.fillMaxWidth()
                .height(54.dp),
            colors = ButtonDefaults.buttonColors(Color.Black.copy(alpha = 0.9f)),
            shape = RoundedCornerShape(5.dp)
        ){
            Text(
                text = "Send Code",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            )
        }

    }
}