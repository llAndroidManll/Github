package sahak.sahakyan.bankpick.navigation.screens

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Loading : Screen("loading")
    data object Onboarding1 : Screen("Onboarding1")
    data object Onboarding2 : Screen("Onboarding2")
    data object Onboarding3 : Screen("Onboarding3")



    data object SignUp : Screen("sign_up")
    data object SignIn : Screen("sign_in")
    data object ForgotPassword : Screen("forgot_password")
}