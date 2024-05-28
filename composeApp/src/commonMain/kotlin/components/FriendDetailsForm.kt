package components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun FriendDetailsForm(
    navController: NavHostController
){
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var mobNumber by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    var switch by remember { mutableStateOf(false) }



    var firstNameError by remember { mutableStateOf(false) }
    var lastNameError by remember { mutableStateOf(false) }
    var mobNumberError by remember { mutableStateOf(false) }

    var numberOfTiffins by remember { mutableStateOf(1) }
    val TIFFIN_MAX_LIMIT = 10

    val switchColors = SwitchColors(
        checkedThumbColor = Color(0xffffffff),
        checkedTrackColor = Color(0xff1e232c),
        checkedBorderColor = Color(0xff1e232c),
        checkedIconColor = Color(0xffffffff),
        uncheckedThumbColor = Color(0xffffffff),
        uncheckedTrackColor = Color(0xff1e232c),
        uncheckedBorderColor = Color(0xff1e232c),
        uncheckedIconColor = Color(0xffffffff),
        disabledCheckedThumbColor = Color(0xffffffff),
        disabledCheckedTrackColor = Color(0xff1e232c),
        disabledCheckedBorderColor = Color(0xff1e232c),
        disabledCheckedIconColor = Color(0xffffffff),
        disabledUncheckedThumbColor = Color(0xffffffff),
        disabledUncheckedTrackColor = Color(0xff1e232c),
        disabledUncheckedBorderColor = Color(0xff1e232c),
        disabledUncheckedIconColor = Color(0xffffffff),
    )



    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ){
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Friend Details",
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color(0xff000000)
            )
        )

        //first name
        OutlinedTextField(
            value = firstName,
            onValueChange = {
                firstName = it
                if(!firstName.isEmpty()){
                    firstNameError = false
                }
            },
            label = {
                Text(
                    text = "First Name"
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = if(firstNameError) Color.Red else Color(0xffe8ecf4),
                focusedBorderColor = if(firstNameError) Color.Red else Color(0xff7356bf)
            ),
            placeholder = {
                Text(
                    text = "Enter your first name"
                )
            },
            trailingIcon = {
                if(firstNameError){
                    Icon(
                        imageVector = Icons.Default.Warning,
                        tint = Color(0xffff1c1c),
                        contentDescription = "warning"
                    )
                }
            },
            singleLine = true
        )

        //last name
        OutlinedTextField(
            value = lastName,
            onValueChange = {
                lastName = it
                if(!lastName.isEmpty()){
                    lastNameError = false
                }
            },
            label = {
                Text(
                    text = "Last Name"
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = if(lastNameError) Color.Red else Color(0xffe8ecf4),
                focusedBorderColor = if(lastNameError) Color.Red else Color(0xff7356bf)
            ),
            placeholder = {
                Text(
                    text = "Enter your last name"
                )
            },
            trailingIcon = {
                if(firstNameError){
                    Icon(
                        imageVector = Icons.Default.Warning,
                        tint = Color(0xffff1c1c),
                        contentDescription = "warning"
                    )
                }
            },
            singleLine = true
        )



        //mobile number
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){

            Text(
                text = "+91"
            )

            OutlinedTextField(
                value = mobNumber,
                onValueChange = {
                    if(mobNumber.length<10){
                        mobNumber = it

                    }

                    if(!mobNumber.isEmpty() && mobNumber.length==10){
                        mobNumberError = false
                    }
                },
                label = {
                    Text(
                        text = "Mobile Number"
                    )
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = if(mobNumberError) Color.Red else Color(0xffe8ecf4),
                    focusedBorderColor = if(mobNumberError) Color.Red else Color(0xff7356bf)
                ),
                placeholder = {
                    Text(
                        text = "Enter mobile number here"
                    )
                },
                trailingIcon = {
                    if(firstNameError){
                        Icon(
                            imageVector = Icons.Default.Warning,
                            tint = Color(0xffff1c1c),
                            contentDescription = "warning"
                        )
                    }
                },
                singleLine = true
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Type",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xff545454)
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Dining",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xff1d232c)
                    )
                )
                Spacer(modifier = Modifier.width(15.dp))

                Switch(
                    checked = switch,
                    onCheckedChange = {
                        switch = it
                        type = if(switch)  "Home Delivery" else  "Dining"
                    },
                    colors = switchColors

                )
                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    text = "Home Delivery",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xff1d232c)
                    )
                )

            }
        }

        // Number of tiffins
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Number of tiffins",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xff545454)
                )
            )

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Box(
                    modifier = Modifier
                        .height(35.dp)
                        .width(35.dp)
                        .background(Color(0xffebebeb), shape = RoundedCornerShape(5.dp))
                        .clickable {
                            if(numberOfTiffins >1){
                                numberOfTiffins  = numberOfTiffins -1
                            }

                        },
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "-",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }
                Spacer(modifier = Modifier.width(5.dp))
                Box(
                    modifier = Modifier
                        .height(35.dp)
                        .width(35.dp)
                        .background(Color(0xffebebeb), shape = RoundedCornerShape(5.dp)),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = numberOfTiffins.toString(),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }

                Spacer(modifier = Modifier.width(5.dp))
                Box(
                    modifier = Modifier
                        .height(35.dp)
                        .width(35.dp)
                        .background(Color(0xffebebeb), shape = RoundedCornerShape(5.dp))
                        .clickable {
                            if(numberOfTiffins <TIFFIN_MAX_LIMIT){
                                numberOfTiffins = numberOfTiffins +1
                            }

                        },
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "+",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }
            }
        }


        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(
                onClick = {

                },
                modifier = Modifier
                    .height(45.dp)
                    .width(121.dp)
                    .background(
                        color = Color(0xff80ff00),
                        shape = RoundedCornerShape(8.dp)
                    ),
                colors = ButtonDefaults.buttonColors(Color(0xff80ff00))
            ){
                Text(
                    text="Pay Now",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 17.sp,
                        color = Color(0xff000000)
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

    }
}