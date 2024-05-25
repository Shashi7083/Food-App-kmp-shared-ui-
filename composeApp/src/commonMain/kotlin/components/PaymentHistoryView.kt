package components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
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
import org.example.project.resources.Res
import org.example.project.resources.copy
import org.jetbrains.compose.resources.painterResource
import screens.PaymentHistory

@Composable
fun PaymentHistoryView(
    navController : NavHostController,
    payment : PaymentHistory
){
    Box(
        modifier =  Modifier.fillMaxWidth()
            .padding(start = 20.dp , end = 20.dp)
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = Color(0xffe6e6e6)
                ),
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp , bottom = 15.dp , start = 15.dp , end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = payment.date,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xff1e232c)
                    )
                )

                Text(
                    text = payment.time,
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xff1e232c)
                    )
                )
            }

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(35.dp)
                        .width(35.dp)
                        .background(
                            color = Color(0xff3556bf),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painter = painterResource(Res.drawable.copy),
                        contentDescription = "copy",
                        tint = Color.Unspecified,
                        modifier = Modifier.height(15.dp)
                            .width(15.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .background(
                            color = Color(0xff1e232c),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clickable {

                        },
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "+"+ payment.amount+" INR",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xff80ff00)
                        ),
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                    )
                }
            }



        }
    }

}