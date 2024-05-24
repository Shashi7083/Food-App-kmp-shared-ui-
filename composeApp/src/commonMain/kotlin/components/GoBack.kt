package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GoBack(){
    Box(
        modifier = Modifier
            .border(width = 1.dp, shape = RoundedCornerShape(5.dp), color = Color(0xffe8ecf4))
            .padding(5.dp),
        contentAlignment = Alignment.Center
    ){
        Image(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "arrow back",
        )
    }
}