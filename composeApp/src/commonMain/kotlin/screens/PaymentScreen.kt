package screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import components.BottomBar
import components.HomeHeader
import components.PaymentHeader
import components.PaymentHistoryView
import org.example.project.resources.Res
import org.example.project.resources.copy
import org.jetbrains.compose.resources.painterResource

@Composable
fun PaymentScreen(
    navController : NavHostController
){

    val sidePadding = 20.dp

    Scaffold(
        bottomBar = {
            BottomBar(navController =  navController)
        }
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            PaymentHeader(
                navController = navController,
                dueTotal = "-2500 INR"
            )


            LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = it.calculateTopPadding(), bottom = it.calculateBottomPadding() + 20.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {

            item {
                Text(
                    modifier = Modifier.padding(top= 20.dp, start = sidePadding, end = sidePadding),
                    text = "Payment History",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xff000000)
                    )
                )
            }
            itemsIndexed(paymentHistoryList) { index, payment ->
                PaymentHistoryView(
                    navController = navController,
                    payment = payment
                )
            }
        }
        }

    }
}



data class PaymentHistory(
    val date : String,
    val time : String,
    val amount :String = "2500"
)

val paymentHistoryList = listOf(
    PaymentHistory("27 May 2024", "4:33 PM", "3000"),
    PaymentHistory("28 June 2024", "5:45 PM", "2300"),
    PaymentHistory("29 July 2024", "6:30 PM", "4500"),
    PaymentHistory("30 July 2024", "7:15 PM", "5000"),
    PaymentHistory("01 August 2024", "8:00 PM", "1400"),
    PaymentHistory("02 September 2024", "9:10 PM", "2100"),
    PaymentHistory("03 October 2024", "10:05 PM", "2300"),
    PaymentHistory("04 November 2024", "11:20 PM", "3100"),
    PaymentHistory("05 December 2024", "12:35 PM", "4200"),
    PaymentHistory("06 January 2025", "1:50 PM", "1200")
)

