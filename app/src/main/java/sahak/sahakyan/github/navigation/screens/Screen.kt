package sahak.sahakyan.github.navigation.screens

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Welcome : Screen("welcome")
    data object Profile : Screen("profile")
}