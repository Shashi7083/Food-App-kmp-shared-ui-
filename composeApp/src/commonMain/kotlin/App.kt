import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import components.HomeHeader
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import screenRoutes.Routes
import screenRoutes.ScreenNavGraph
import screens.ForgotPasswordScreen
import screens.NewPasswordScreen
import screens.OTPVerificationScreen
import screens.PasswordChangedScreen
import screens.RegisterScreen
import screens.WelcomeScreen


@Composable
@Preview
fun App() {
    MaterialTheme {

        var startDestination = Routes.UserWork.route
        ScreenNavGraph(
            startDestination = startDestination
        )


    }
}

