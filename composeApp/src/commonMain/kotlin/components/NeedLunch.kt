package components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NeedLunch(
    onClick:(Boolean)->Unit
){

    var needLunch by remember { mutableStateOf(true) }

    Column (
        modifier = Modifier.fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ){

        Text(
            text ="Need lunch tomorrow?",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xff000000)
            )
        )

        Spacer(modifier = Modifier.height(25.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clickable (
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {
                            needLunch = true
                        }
                    )
                    .height(70.dp)
                    .width(70.dp)
                    .clip(CircleShape)
                    .background(
                        color = Color(0xffffffff),
                        shape = CircleShape
                    )
                ,
                contentAlignment = Alignment.Center
            ){

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AnimatedVisibility(needLunch){
                        Box(
                            modifier = Modifier
                                .height(70.dp)
                                .width(70.dp)
                                .clip(CircleShape)
                                .background(
                                    color = Color(0xffff3d00) ,
                                    shape = CircleShape
                                )

                        )
                    }
                }
                Text(
                    text = "Yupp!",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if(needLunch) Color(0xffffffff) else Color(0xff000000)
                )
            }

            Box(
                modifier = Modifier
                    .clickable (
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {
                            needLunch = false
                        }
                    )
                    .height(70.dp)
                    .width(70.dp)
                    .clip(CircleShape)
                    .background(
                        color =  Color(0xffffffff),
                        shape = CircleShape
                    )

                ,
                contentAlignment = Alignment.Center
            ){
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AnimatedVisibility(!needLunch){
                        Box(
                            modifier = Modifier
                                .height(70.dp)
                                .width(70.dp)
                                .clip(CircleShape)
                                .background(
                                    color = Color(0xffff3d00) ,
                                    shape = CircleShape
                                )

                        )
                    }
                }




                Text(
                    text = "Naah",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if(!needLunch) Color(0xffffffff) else Color(0xff000000)
                )
            }
        }

    }
}