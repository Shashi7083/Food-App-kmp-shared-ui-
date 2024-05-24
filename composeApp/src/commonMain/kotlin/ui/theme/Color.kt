package ui.theme

import androidx.compose.foundation.isSystemInDarkTheme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

//Light

val primary = Color(0xffff3d00)
val secondary = Color(0xff1e232c)
val onPrimaryColor = Color(0xffffffff)
val onSecondaryText = Color(0xffffffff)
val onSecondaryGreen = Color(0xff80ff00)
val purple = Color(0xff3556bf)
val borderColor  = Color(0xffe8ecf4)
val surfaceColorLight  = Color(0xfff7f8f9)
val surfaceColor  = Color(0xffffffff)
val onSurfaceColor = Color(0xff000000)
val backgroundColor  = Color(0xffffffff)
val textColor = Color(0xff1e232c)
val textColorLight = Color(0xff8391a1)
val errorColor = Color(0xffff1c1c)


////example
//val colors = darkColors(
//    primary = Color(0xFF3F51B5),
//    primaryVariant = Color(0xFF303F9F),
//    onPrimary = Color.White,
//    secondary = Color(0xFF0097A7),
//    secondaryVariant = Color(0xFF00798C),
//    onSecondary = Color.White,
//    background = Color(0xFF424242),
//    onBackground = Color.White,
//    surface = Color(0xFF424242),
//    onSurface = Color.White,
//    error = Color(0xFFB00020),
//    onError = Color.White,
//    isLight = false
//)







//val primary
//    @Composable
//    get() = if( isSystemInDarkTheme()) Color.Black
//    else
//        Color.Red