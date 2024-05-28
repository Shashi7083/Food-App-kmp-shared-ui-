package components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Text
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
import io.wojciechosak.calendar.config.SelectionMode
import io.wojciechosak.calendar.config.rememberCalendarState
import io.wojciechosak.calendar.utils.copy
import io.wojciechosak.calendar.utils.today
import io.wojciechosak.calendar.view.CalendarView
import io.wojciechosak.calendar.view.HorizontalCalendarView
import io.wojciechosak.calendar.view.MonthHeader
import io.wojciechosak.calendar.view.MonthPicker
import io.wojciechosak.calendar.view.YearPicker
import kotlinx.datetime.LocalDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalendarWithPicker(){
    var mode by remember { mutableStateOf(DatePickerM.DAY) }
    var date by remember { mutableStateOf(LocalDate.today()) }
    var tiffinDates = listOf(
        LocalDate.parse("2024-05-28"),
        LocalDate.parse("2024-05-25"),
        LocalDate.parse("2024-05-31"),
        LocalDate.parse("2024-05-23"),
        LocalDate.parse("2024-05-29"),
        LocalDate.parse("2024-05-27"),
        LocalDate.parse("2024-05-18"),
        LocalDate.parse("2024-05-16"),
        LocalDate.parse("2024-05-15"),
        LocalDate.parse("2024-05-14"),
        LocalDate.parse("2024-05-13"),
        LocalDate.parse("2024-05-09"),  // Corrected
        LocalDate.parse("2024-05-07"),  // Corrected
        LocalDate.parse("2024-05-06"),
        LocalDate.parse("2024-05-04"),
        LocalDate.parse("2024-05-05"),
        LocalDate.parse("2024-05-03"),
        LocalDate.parse("2024-05-02"),
        LocalDate.parse("2024-05-01"),
        LocalDate.parse("2024-05-11"),
    )


    println(date)

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
        when (mode) {
            DatePickerM.YEAR -> {
                YearPicker(
                    onYearSelected = {
                        date = date.copy(year = it)
                        mode = DatePickerM.DAY
                    },
                    columns = 5,
                    rows = 5,
                    yearView = {year ->
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = year.toString(),
                                modifier = Modifier.padding(start = 15.dp , end = 15.dp , top = 20.dp, bottom = 20.dp)
                            )
                        }
                    }
                )
            }

            DatePickerM.MONTH -> {
                MonthPicker(onMonthSelected = {
                    date = date.copy(month = it)
                    mode = DatePickerM.YEAR
                }) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.aspectRatio(1f),
                    ) {
                        Text(
                            text = it.name.substring(IntRange(0, 2)).capitalize(),
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }

            DatePickerM.DAY -> {
                HorizontalCalendarView(
                    startDate = date,
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
                            startDate = date,
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
                                        mode = DatePickerM.MONTH
                                    },
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row (
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    androidx.compose.material.Text(
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

                                            }
                                    )
                                    Spacer(modifier = Modifier.width(15.dp))
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowRight,
                                        contentDescription = null,
                                        tint = Color(0xff0038ff),
                                        modifier = Modifier.size(30.dp)
                                            .clickable {

                                            }
                                    )
                                }
                            }
                        },
                        onDateSelected = {
                            it.firstOrNull()?.let { date = it }
                        }
                    )
                }
            }
        }
    }

}


enum class DatePickerM {
    YEAR,
    MONTH,
    DAY,
}
