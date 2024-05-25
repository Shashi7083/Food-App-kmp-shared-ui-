package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.datetime.*
import org.example.project.resources.Res
import org.example.project.resources.person
import org.example.project.resources.tiffinbox
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeHeader(){


    var todayMealStatus by remember { mutableStateOf("Your todays meal is on the way") }


        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(235.dp)
        ) {
            val (box1, box2) = createRefs()

            Box(
                modifier = Modifier
                    .constrainAs(box1){
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
                    .height(184.dp)
                    .background(Color(0xffff3d00)),
            ){
                Row (
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 25.dp),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "Tiffin food",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xffffffff)
                        )
                    )
                }
            }

            Box(
                modifier = Modifier
                    .constrainAs(box2){
                        start.linkTo(box1.start)
                        end.linkTo(box1.end)
                        top.linkTo(box1.top, margin = 98.dp)
                    }
                    .height(138.dp)
                    .fillMaxWidth(0.88f)
                    .background(Color(0xff1e232c), shape = RoundedCornerShape(8.dp))
            ){
                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(top = 15.dp , bottom = 15.dp , start = 20.dp, end = 20.dp)
                ) {
                    Text(
                        text = "4 May 2024",
                        color = Color(0xffffffff),
                        fontSize = 10.sp
                    )
                    Row (
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 20.dp)
                            .fillMaxHeight(0.78f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){

                        Row (
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ){
                            Image(
                                painter = painterResource(Res.drawable.person),
                                contentDescription = "person",
                                modifier = Modifier.height(40.dp)
                                    .width(40.dp)
                                    .clip(CircleShape)
                            )

                            Text(
                                text = "Welcome\nShashi Ranjan Kumar",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xffffffff)
                                )
                            )
                        }



                        Image(
                            painter = painterResource(Res.drawable.tiffinbox),
                            contentDescription = "person",
                            modifier = Modifier.height(75.dp)
                                .width(75.dp)
                        )


                    }

                    Text(
                        text = todayMealStatus,
                        fontSize = 11.sp,
                        color = Color(0xffffffff),
                        modifier = Modifier.padding(start = 20.dp)
                    )

                }
            }
        }
}

