package screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.resources.Res
import org.example.project.resources.hide
import org.example.project.resources.seen
import org.jetbrains.compose.resources.painterResource
import utils.getVibrationUtil


@Composable
fun LoginScreen(){

//    val context = LocalContext.current
//    val vibrationUtil = getVibrationUtil()

    var email by remember { mutableStateOf("") }
    var isEmailValid by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier.fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 25.dp, bottom = 10.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ){
        GoBack()

        HeadingText(text = "Welcome back! Glad to see you, Again!")


        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    isEmailValid = isValidEmail(email)
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
                    unfocusedBorderColor = Color(0xffe8ecf4)

                )
            )

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xfff7f8f9)),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color(0xffe8ecf4)
                ),
                placeholder = {
                    Text(
                        text = "Enter your password"
                    )
                },
                visualTransformation = if(showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(
                        onClick = {
                            showPassword = !showPassword
                        }
                    ){
                        AnimatedVisibility(showPassword){
                            Icon(
                                painter = painterResource(Res.drawable.seen),
                                contentDescription = null,
                                modifier = Modifier.height(20.dp)
                            )
                        }
                        AnimatedVisibility(!showPassword){
                            Icon(
                                painter = painterResource(Res.drawable.hide),
                                contentDescription = null,
                                modifier = Modifier.height(20.dp)
                            )
                        }
                    }
                }
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){
                Text(
                    text = "Forgot Password?",
                    style = TextStyle(
                        color = Color(0xff808080)
                    )
                )
            }
        }

        Button(
            onClick = {
                if(isEmailValid){

                }else{

                }
            },
            modifier = Modifier.fillMaxWidth()
                .height(54.dp),
            colors = ButtonDefaults.buttonColors(Color.Black.copy(alpha = 0.9f)),
            shape = RoundedCornerShape(5.dp)
        ){
            Text(
                text = "Login",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Don't have an accoutn? ",
            )
            Text(
                text = "Register Now",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xff35c2c1)
                )
            )
        }


    }
}

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}



@Composable
fun HeadingText(text : String){
    Text(
        text = text,
        style = TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xff1e232c),
            fontFamily = FontFamily.SansSerif
        )
    )
}

@Composable
fun GoBack(){
    Box(
        modifier = Modifier
            .border(width = 1.dp, shape = RoundedCornerShape(5.dp), color = Color(0xffe8ecf4))
            .padding(5.dp),
        contentAlignment = Alignment.Center
    ){
        Image(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "arrow back",
        )
    }
}