package components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun OffersAndMenu(
    navController: NavHostController
){

    Button(
        onClick = {

        },
        modifier = Modifier.fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
            .height(83.dp),
        colors = ButtonDefaults.buttonColors(Color(0xffff6601)),
        shape = RoundedCornerShape(8.dp)
    ){
        Text(
            text = "Offers and Menu",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 25.sp
            )
        )
    }
}
