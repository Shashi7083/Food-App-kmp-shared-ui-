package components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.LocalDate

@Composable
fun CalendarDayView(
    date: LocalDate,
    tiffinDates : List<LocalDate>
) {
    val isTiffinProvided = if(tiffinDates.contains(date)) true else false
    var dateMonth by remember { mutableStateOf(date.monthNumber) }
    var tiffinMonth  = if(tiffinDates.isEmpty()) -1 else tiffinDates.get(0).monthNumber
    var isSameMonth by remember { mutableStateOf(dateMonth == tiffinMonth) }
    var backgroundColor = if(isSameMonth){
        if(isTiffinProvided) Color(0xffbaff8f) else Color(0xfffabdae)
    }else{
        Color(0xffffffff)
    }
    var dateColor = if(isSameMonth){
        Color(0xff000000)
    }else{
        Color(0xff808080)
    }


    Column(
        modifier =
        Modifier
            .aspectRatio(1f)
            .padding(7.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(4.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            "${date.dayOfMonth}",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = dateColor,
        )
    }
}
