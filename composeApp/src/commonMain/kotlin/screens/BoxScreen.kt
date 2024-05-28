package screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import components.BottomBar
import components.BoxScreenHeader

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.CalendarDayView
import components.CalendarWithPicker
import components.MyCalendar
import io.wojciechosak.calendar.animation.CalendarAnimator
import io.wojciechosak.calendar.config.MonthYear
import io.wojciechosak.calendar.config.SelectionMode
import io.wojciechosak.calendar.config.rememberCalendarState
import io.wojciechosak.calendar.config.toLocalDate
import io.wojciechosak.calendar.range.RangeConfig
import io.wojciechosak.calendar.range.RoundedRangeIllustrator
import io.wojciechosak.calendar.utils.Pallete
import io.wojciechosak.calendar.utils.today
import io.wojciechosak.calendar.view.CalendarView
import io.wojciechosak.calendar.view.HorizontalCalendarView
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import screenRoutes.Routes
import kotlin.random.Random

@Composable
fun BoxScreen(
    navController : NavHostController
){

    Scaffold(
        bottomBar = {
            BottomBar(navController =  navController)
        }
    ) {

        Column(
            modifier =  Modifier.fillMaxSize()
                .padding(it)

        ) {
            BoxScreenHeader()
            Column (
                modifier = Modifier.fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(start = 20.dp , end = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)

            ){

                Spacer(modifier = Modifier.height(20.dp))



                Text(
                    text = "Your overall attendance this month",
                    style = TextStyle(fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )


//                MyCalendar()
                    CalendarWithPicker()

               PayforNextMonth(navController = navController, "20")
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

    }
}


@Composable
fun PayforNextMonth(
    navController: NavHostController,
    days : String
){
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text(
            text = days+" Days till now",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xff000000)
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                //navigate from here

            },
            modifier = Modifier
                .height(54.dp),
            colors = androidx.compose.material.ButtonDefaults.buttonColors(Color.Black.copy(alpha = 0.9f)),
            shape = RoundedCornerShape(5.dp)
        ){
            Text(
                text = "Pay for next month",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xffffffff),
                    fontSize = 20.sp
                )
            )
        }
    }
}




