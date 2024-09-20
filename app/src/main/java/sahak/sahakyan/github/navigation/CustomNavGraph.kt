package sahak.sahakyan.github.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.delay
import sahak.sahakyan.github.data.model.UserInfo
import sahak.sahakyan.github.navigation.screens.Screen
import sahak.sahakyan.github.presentation.ui.components.IndeterminateCircularIndicator
import sahak.sahakyan.github.presentation.ui.home.HomeScreen
import sahak.sahakyan.github.presentation.ui.profile.ProfileScreen
import sahak.sahakyan.github.presentation.ui.welcome.WelcomeScreen
import sahak.sahakyan.github.presentation.viewmodel.UserInfoViewModel
import sahak.sahakyan.github.presentation.viewmodel.UserViewModel

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun CustomNavGraph(
    navController: NavHostController
) {

    val lifecycleScope = LocalLifecycleOwner.current.lifecycleScope

    val userViewModel: UserViewModel = hiltViewModel()
    val userInfoViewModel: UserInfoViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            WelcomeScreen()
            LaunchedEffect(
                key1 = lifecycleScope
            ) {
                delay(3000)
                navController.navigate(Screen.Home.route)
            }
        }
        composable(Screen.Home.route) {
            HomeScreen(
                state = userViewModel.userResponse.observeAsState(),
                onProfileClick = { login ->
//                    Log.d(Constants.LOG_TAG, "CustomNavGraph: Home Screen: user $login")

                    navController.navigate(Screen.Profile.route + "/$login")
                }
            )
        }

        composable(Screen.Profile.route + "/{login}") { backStackEntry ->

            val login = backStackEntry.arguments?.getString("login") ?: ""
//            Log.d(Constants.COROUTINE_TAG, "CustomNavGraph: Profile Screen for $login")

            LaunchedEffect(login) {
//                Log.d(Constants.COROUTINE_TAG, "LaunchedEffect for $login")
                userInfoViewModel.getUserInfo(login)
            }

            val userInfoState by userInfoViewModel.userInfoState.collectAsState()

            when {
                userInfoState.loading -> {
//                    Log.d(Constants.COROUTINE_TAG, "Loading user info...")
                    IndeterminateCircularIndicator()
                }
                userInfoState.error != null -> {
//                    Log.e(Constants.COROUTINE_TAG, "Error fetching user info: ${userInfoState.error}")
                }
                userInfoState.userResponse != UserInfo() -> {
//                    Log.d(Constants.COROUTINE_TAG, "User info loaded successfully")
                    ProfileScreen(
                        userInfo = userInfoState.userResponse,
                        onArrowClick = {
                            navController.navigate(Screen.Home.route)
                        }
                    )
                }
            }
        }
    }
}