package screenRoutes

import org.example.project.resources.Res
import org.example.project.resources.briefcaseselected
import org.example.project.resources.briefcaseunselected
import org.example.project.resources.homeselected
import org.example.project.resources.homeunselected
import org.example.project.resources.selectedwallet
import org.example.project.resources.unselectedwallet
import org.jetbrains.compose.resources.DrawableResource

sealed class BottomNavScreen(
    val route: String,
    val name: String,
    val selectedIcon: DrawableResource,
    val unselectedIcon: DrawableResource
){
    object HomeScreen : BottomNavScreen(
        route = "home_screen",
        name = "Home",
        selectedIcon = Res.drawable.homeselected,
        unselectedIcon = Res.drawable.homeunselected
    )

    object BoxScreen : BottomNavScreen(
        route = "box_screen",
        name = "Box",
        selectedIcon = Res.drawable.briefcaseselected,
        unselectedIcon = Res.drawable.briefcaseunselected
    )

    object PaymentScreen : BottomNavScreen(
        route = "payment_screen",
        name = "Payment",
        selectedIcon = Res.drawable.selectedwallet,
        unselectedIcon = Res.drawable.unselectedwallet
    )
}