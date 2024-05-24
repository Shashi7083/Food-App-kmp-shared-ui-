package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun OrderForFriend(
    navController: NavHostController
){
    Column (
        modifier = Modifier.fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ) {

        Text(
            text = "Order for a friend ?",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xff000000)
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Button(
                onClick = {
                    //navigate from here
                },
                modifier = Modifier.fillMaxWidth(0.6f)
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(Color.Black.copy(alpha = 0.9f)),
                shape = RoundedCornerShape(5.dp)
            ){
                Text(
                    text = "+1 for my friend",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xffffffff),
                        fontSize = 20.sp
                    )
                )
            }
        }
    }
}
