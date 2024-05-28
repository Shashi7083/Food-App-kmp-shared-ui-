package components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.wojciechosak.calendar.config.rememberCalendarState
import io.wojciechosak.calendar.utils.copy
import io.wojciechosak.calendar.utils.today
import io.wojciechosak.calendar.view.CalendarView
import io.wojciechosak.calendar.view.HorizontalCalendarView
import io.wojciechosak.calendar.view.MonthPicker
import io.wojciechosak.calendar.view.YearPicker
import kotlinx.datetime.LocalDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyCalendar(
    modifier: Modifier = Modifier.fillMaxSize().background(Color.Red).height(100.dp),

    ) {

    var startDate = LocalDate.today()
    var tiffinDates = emptyList<LocalDate>()
    var currentMonthOffset by remember { mutableStateOf(0) }

    var mode by remember { mutableStateOf(DatePickerMode.DAY) }



    when(mode){
        DatePickerMode.YEAR -> {
            YearPicker(
                onYearSelected = {
                    startDate = startDate.copy(year = it)
                    mode = DatePickerMode.DAY
                },
            )
        }

        DatePickerMode.MONTH -> {
            MonthPicker(onMonthSelected = {
                startDate = startDate.copy(month = it)
                mode = DatePickerMode.YEAR
            }) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.aspectRatio(1f),
                ) {
                    androidx.compose.material3.Text(
                        text = it.name.substring(IntRange(0, 2)).capitalize(),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }

        DatePickerMode.DAY -> {
            Column(
                modifier = Modifier.height(340.dp)
                    .border(
                        BorderStroke(
                            width = 1.dp,
                            color = Color(0xffbbbbbb)
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                //HorizontalCalendarView(startDate = startDate)
                HorizontalCalendarView(
                    startDate = startDate,
                    modifier = Modifier
                        .padding(
                            start=12.dp  ,
                            end = 12.dp, top = 12.dp ,
                            bottom = 12.dp))
                { monthOffset ->
                    CalendarView(
                        day = { dayState ->
                            CalendarDayView(
                                dayState.date,
                                tiffinDates = tiffinDates )
                        },
                        config = rememberCalendarState(
                            startDate = startDate,
                            monthOffset = monthOffset
                        ),
                        header = {month, year ->
                            Row(
                                modifier = Modifier.fillMaxWidth()
                                    .padding(
                                        top = 12.dp,
                                        start = 12.dp ,
                                        bottom = 15.dp,
                                        end = 12.dp)
                                    .clickable {
                                        mode = DatePickerMode.MONTH
                                    },
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row (
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Text(
                                        text = ""+month +" " + year,
                                        style = TextStyle(
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xff000000)
                                        )
                                    )

                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = null,
                                tint = Color(0xff0038ff),
                                modifier = Modifier.size(30.dp)
                            )
                                }

                                Row (
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowLeft,
                                        contentDescription = null,
                                        tint = Color(0xff0038ff),
                                        modifier = Modifier.size(30.dp)
                                            .clickable {
                                                currentMonthOffset--
                                            }
                                    )
                                    Spacer(modifier = Modifier.width(15.dp))
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowRight,
                                        contentDescription = null,
                                        tint = Color(0xff0038ff),
                                        modifier = Modifier.size(30.dp)
                                            .clickable {
                                                currentMonthOffset++
                                            }
                                    )
                                }
                            }
                        },
                        onDateSelected = {
                            it.firstOrNull()?.let { startDate = it }
                        }
                    )
                }
            }
        }
    }










}

private enum class DatePickerMode {
    YEAR,
    MONTH,
    DAY,
}
