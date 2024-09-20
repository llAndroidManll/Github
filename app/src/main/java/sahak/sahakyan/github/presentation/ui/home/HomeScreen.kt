package sahak.sahakyan.github.presentation.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sahak.sahakyan.github.data.model.User
import sahak.sahakyan.github.presentation.state.UserState
import sahak.sahakyan.github.presentation.ui.components.UserView
import sahak.sahakyan.github.presentation.ui.theme.LightGray
import sahak.sahakyan.github.presentation.ui.theme.Purple40
import sahak.sahakyan.github.presentation.ui.theme.dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: State<UserState?>? = null,
    onProfileClick: (String) -> Unit = {},
) {

    val users: List<User> = state!!.value!!.userResponse

//    Log.d("User Info", users.size.toString())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "GitHub",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = MaterialTheme.dimens.small1)
                            .wrapContentSize(Alignment.TopCenter)
                    )

                },
                modifier = Modifier
                    .fillMaxWidth()
                ,
                colors = TopAppBarColors(
                    containerColor = Purple40,
                    scrolledContainerColor = Color.White,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White,
                ),
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = it.calculateTopPadding(),
                        bottom = it.calculateBottomPadding()
                    )
                ,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(users.subList(0, 29)) { user ->
                    UserView(
                        user = user,
                        onProfileClick = {
//                            Log.d(LOG_TAG, "HomeScreen: ${user.login}")
                            onProfileClick(user.login.toString())
                        }
                    )
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(LightGray)
                    )
                }
            }
        }
    )
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}