package screenRoutes

sealed class Routes (
    val route : String
){
    object LoginRegister : Routes(
        route = "start_screen"
    )
    object WelcomeScreen : Routes(
        route = "welcome_screen"
    )
    object LoginScreen : Routes(
        route = "login_screen"
    )
    object RegisterScreen : Routes(
        route = "register_screen"
    )
    object ForgotPasswordScreen : Routes(
        route = "forgot_password_screen"
    )
    object NewPasswordScreen : Routes(
        route = "new_password_screen"
    )
    object OTPVerificationScreen : Routes(
        route = "otp_verificationn_screen"
    )
    object PasswordChangedScreen  : Routes(
        route = "password_changed_screen"
    )
    // end of all start screen


    //main screens
    object UserWork : Routes(
        route = "users_work"
    )


}