package screenRoutes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import screens.ForgotPasswordScreen
import screens.LoginScreen
import screens.NewPasswordScreen
import screens.OTPVerificationScreen
import screens.PasswordChangedScreen
import screens.RegisterScreen
import screens.WelcomeScreen

@Composable
fun ScreenNavGraph(
    startDestination : String
){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        navigation(
            route = Routes.LoginRegister.route,
            startDestination = Routes.WelcomeScreen.route
        ){
            composable(
                route = Routes.WelcomeScreen.route
            ){
                WelcomeScreen(navController = navController)
            }

            composable(
                route = Routes.LoginScreen.route
            ){
                LoginScreen(navController = navController)
            }

            composable(
                route = Routes.RegisterScreen.route
            ){
                RegisterScreen(navController = navController)
            }

            composable(
                route = Routes.ForgotPasswordScreen.route
            ){
                ForgotPasswordScreen(navController = navController)
            }

            composable(
                route = Routes.NewPasswordScreen.route
            ){
                NewPasswordScreen(navController = navController)
            }

            composable(
                route = Routes.OTPVerificationScreen.route
            ){
                OTPVerificationScreen(navController = navController)
            }

            composable(
                route = Routes.PasswordChangedScreen.route
            ){
                PasswordChangedScreen(navController = navController)
            }

        }
    }
}
