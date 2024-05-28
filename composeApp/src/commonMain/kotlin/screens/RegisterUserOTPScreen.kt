package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.navigation.NavHostController
import components.GoBack
import components.HeadingText
import screenRoutes.BottomNavScreen
import screenRoutes.Routes

@Composable
fun RegisterUserOTPScreen(
    navController : NavHostController
){

    var otp1 by remember { mutableStateOf("") }
    var otp2 by remember { mutableStateOf("") }
    var otp3 by remember { mutableStateOf("") }
    var otp4 by remember { mutableStateOf("") }

    val focusRequesters = List(4) { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Column (
        modifier = Modifier.fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 25.dp, bottom = 10.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        GoBack(navController = navController)

        HeadingText(text = "Hello! Register to get Started")

        Text(
            text = "Enter the verification code we just sent on your email address.",
            style = TextStyle(
                color = Color(0xff808080)
            )
        )

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            OutlinedTextField(
                value = otp1,
                onValueChange = {
                    if(it.length>1){
                        otp1 = it.get(it.length -1).toString()
                        focusRequesters[1].requestFocus()
                    }else{
                        otp1 = it
                    }

                    if(it.length ==1 ) {
                        focusRequesters[1].requestFocus()
                    }
                },
                modifier = Modifier
                    .background(Color(0xfff7f8f9))
                    .height(60.dp)
                    .width(60.dp)
                    .focusRequester(focusRequesters[0]),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = if(otp1.length!=0)Color(0xff35c2c1) else Color(0xffe8ecf4),
                    focusedBorderColor =  Color(0xff35c2c1)
                ),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                ),
                visualTransformation = VisualTransformation.None,
                maxLines = 1,
            )

            OutlinedTextField(
                value = otp2,
                onValueChange = {
                    if(it.length>1){
                        otp2 = it.get(it.length -1).toString()
                        focusRequesters[2].requestFocus()
                    }else{
                        otp2 = it
                    }
                    if(it.length ==1 )
                    {
                        focusRequesters[2].requestFocus()
                    }
                },
                modifier = Modifier
                    .background(Color(0xfff7f8f9))
                    .width(60.dp)
                    .height(60.dp)
                    .focusRequester(focusRequesters[1]),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = if(otp1.length!=0)Color(0xff35c2c1) else Color(0xffe8ecf4),
                    focusedBorderColor =  Color(0xff35c2c1)
                ),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                ),
                visualTransformation = VisualTransformation.None,
                maxLines = 1
            )

            OutlinedTextField(
                value = otp3,
                onValueChange = {
                    if(it.length>1){
                        otp3 = it.get(it.length -1).toString()
                        focusRequesters[3].requestFocus()
                    }else{
                        otp3 = it
                    }
                    if(it.length ==1 ) {
                        focusRequesters[3].requestFocus()
                    }
                },
                modifier = Modifier
                    .background(Color(0xfff7f8f9))
                    .height(60.dp)
                    .width(60.dp)
                    .focusRequester(focusRequesters[2]),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = if(otp1.length!=0)Color(0xff35c2c1) else Color(0xffe8ecf4),
                    focusedBorderColor =  Color(0xff35c2c1)
                ),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                ),
                visualTransformation = VisualTransformation.None,
                maxLines = 1
            )
            OutlinedTextField(
                value = otp4,
                onValueChange = {
                    if(it.length>1){
                        otp4 = it.get(it.length -1).toString()
                        focusManager.clearFocus()
                    }else{
                        otp4 = it
                    }
                    if(it.length ==1 ) {
                        focusManager.clearFocus()

                    }
                },
                modifier = Modifier
                    .background(Color(0xfff7f8f9))
                    .height(60.dp)
                    .width(60.dp)
                    .focusRequester(focusRequesters[3]),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = if(otp1.length!=0)Color(0xff35c2c1) else Color(0xffe8ecf4),
                    focusedBorderColor =  Color(0xff35c2c1)
                ),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                ),
                visualTransformation = VisualTransformation.None,
                maxLines = 1,
                keyboardActions = KeyboardActions(

                )
            )
        }




        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = {
                val otp = otp1 + otp2 + otp3 + otp4
                println(otp)
                if(otp.length == 4){
                    navController.navigate(BottomNavScreen.HomeScreen.route){
                        popUpTo(BottomNavScreen.HomeScreen.route){
                            inclusive  = true
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
                .height(54.dp),
            colors = ButtonDefaults.buttonColors(Color.Black.copy(alpha = 0.9f)),
            shape = RoundedCornerShape(5.dp)
        ){
            Text(
                text = "Verify",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            )
        }

    }
}