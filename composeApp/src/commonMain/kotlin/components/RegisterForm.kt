package components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import org.example.project.resources.Res
import org.example.project.resources.hide
import org.example.project.resources.seen
import org.jetbrains.compose.resources.painterResource

@Composable
fun RegisterForm(){

    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var userNameError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    var confirmPasswordError by remember { mutableStateOf(false) }
    var showPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {

        OutlinedTextField(
            value = userName,
            onValueChange = {
                userName = it
                if(!userName.isEmpty()){
                    userNameError = false
                }

            },
            modifier = Modifier.fillMaxWidth()
                .background(Color(0xfff7f8f9)),
            placeholder = {
                Text(
                    text = "Username"
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = if(userNameError) Color.Red else Color(0xffe8ecf4),
                focusedBorderColor = if(userNameError) Color.Red else Color(0xff7356bf)
            ),
            trailingIcon = {
                if(userNameError){
                    Icon(
                        imageVector = Icons.Default.Warning,
                        tint = Color.Red,
                        contentDescription = ""
                    )
                }

            }
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                if(isValidEmail(email)){
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


        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                if(!password.isEmpty()){
                    passwordError = false
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xfff7f8f9)),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = if(passwordError) Color.Red else Color(0xffe8ecf4),
                focusedBorderColor = if(passwordError) Color.Red else Color(0xff7356bf)
            ),
            placeholder = {
                Text(
                    text = "Password"
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


        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                if(!confirmPassword.isEmpty()){
                    confirmPasswordError = false
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xfff7f8f9)),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = if(confirmPasswordError) Color.Red else Color(0xffe8ecf4),
                focusedBorderColor = if(confirmPasswordError) Color.Red else Color(0xff7356bf)
            ),
            placeholder = {
                Text(
                    text = "Confirm password"
                )
            },
            visualTransformation = if(showConfirmPassword) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(
                    onClick = {
                        showConfirmPassword = !showConfirmPassword
                    }
                ){
                    AnimatedVisibility(showConfirmPassword){
                        Icon(
                            painter = painterResource(Res.drawable.seen),
                            contentDescription = null,
                            modifier = Modifier.height(20.dp)
                        )
                    }
                    AnimatedVisibility(!showConfirmPassword){
                        Icon(
                            painter = painterResource(Res.drawable.hide),
                            contentDescription = null,
                            modifier = Modifier.height(20.dp)
                        )
                    }
                }
            }
        )




    }

    Spacer(modifier = Modifier.height(20.dp))

    Button(
        onClick = {
            if(!isValidEmail(email)){
                emailError = true
            }
            if(userName.isEmpty()){
                userNameError = true
            }
            if(password.isEmpty()){
                passwordError = true
            }
            if(confirmPassword.isEmpty()){
                confirmPasswordError = true
            }
            if(!password.equals(confirmPassword)){
                passwordError = true
                confirmPasswordError = true
            }
        },
        modifier = Modifier.fillMaxWidth()
            .height(54.dp),
        colors = ButtonDefaults.buttonColors(Color.Black.copy(alpha = 0.9f)),
        shape = RoundedCornerShape(5.dp)
    ){
        Text(
            text = "Register",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        )
    }


}

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
