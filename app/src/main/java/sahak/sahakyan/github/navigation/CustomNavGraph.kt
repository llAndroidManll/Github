package sahak.sahakyan.github.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.delay
import sahak.sahakyan.bankpick.navigation.screens.Screen
import sahak.sahakyan.github.R

@Composable
fun CustomNavGraph(
    navController: NavHostController
) {

    val lifecycleScope = LocalLifecycleOwner.current.lifecycleScope

    NavHost(navController = navController, startDestination = Screen.Loading.route) {
        composable(Screen.Home.route) {

        }
    }
}