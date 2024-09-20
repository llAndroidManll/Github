package sahak.sahakyan.github.presentation.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import sahak.sahakyan.github.R
import sahak.sahakyan.github.data.model.UserInfo
import sahak.sahakyan.github.presentation.ui.components.TextsInProfileScreen
import sahak.sahakyan.github.presentation.ui.theme.Gray
import sahak.sahakyan.github.presentation.ui.theme.LightBlack
import sahak.sahakyan.github.presentation.ui.theme.Purple40
import sahak.sahakyan.github.presentation.ui.theme.Roboto
import sahak.sahakyan.github.presentation.ui.theme.White
import sahak.sahakyan.github.presentation.ui.theme.dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    userInfo: UserInfo,
    onArrowClick: () -> Unit = {},
) {

    Scaffold(
        containerColor = White,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Profile",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp)
                            .wrapContentSize(Alignment.Center)
                            .absoluteOffset((-8).dp, 0.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TopAppBarColors(
                    containerColor = Purple40,
                    scrolledContainerColor = Color.White,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White,
                ),
                navigationIcon = {
                    Row {
                        Spacer(modifier = Modifier.width(16.dp))
                        Image(
                            painter = painterResource(R.drawable.arrow_left),
                            contentDescription = "",
                            modifier = Modifier.clickable {
                                onArrowClick()
                            }
                        )
                    }
                },
            )
        },

        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = it.calculateTopPadding() + MaterialTheme.dimens.small1,
                        bottom = it.calculateBottomPadding(),
                        start = MaterialTheme.dimens.small1,
                        end = MaterialTheme.dimens.small1,
                    )
                    .shadow(
                        elevation = (1).dp,
                        spotColor = Color.Black,
                        clip = true,
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = MaterialTheme.dimens.small1),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AsyncImage(
                        model = userInfo.avatar_url,
                        contentDescription = "User Avatar",
                        modifier = Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(100))
                    )
                    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small1))
                    Text(
                        text = userInfo.name.toString(),
                        modifier = Modifier,
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        fontFamily = Roboto,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small1))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.location),
                            contentDescription = "Location",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = userInfo.location.toString(),
                            modifier = Modifier,
                            color = Gray,
                            fontWeight = FontWeight.Light,
                            fontFamily = Roboto,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium1))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = MaterialTheme.dimens.small3),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = userInfo.followers.toString()
                                .plus(" Followers"),
                            modifier = Modifier,
                            color = LightBlack,
                            fontWeight = FontWeight.Medium,
                            fontFamily = Roboto,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.width(MaterialTheme.dimens.small3))
                        Text(
                            text = "|",
                            modifier = Modifier,
                            color = Gray,
                            fontWeight = FontWeight.Normal,
                            fontFamily = Roboto,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.width(MaterialTheme.dimens.small3))
                        Text(
                            text = userInfo.following.toString()
                                .plus(" Following"),
                            modifier = Modifier,
                            color = LightBlack,
                            fontWeight = FontWeight.Medium,
                            fontFamily = Roboto,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }



                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(MaterialTheme.dimens.small3)
                        .border(1.dp, Color.White),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    TextsInProfileScreen(
                        modifier = Modifier,
                        title = "Bio:",
                        text = userInfo.bio.toString()
                    )
                    TextsInProfileScreen(
                        modifier = Modifier,
                        title = "Public Repository:",
                        text = userInfo.public_repos.toString()
                    )
                    TextsInProfileScreen(
                        modifier = Modifier,
                        title = "Public Gists:",
                        text = userInfo.public_gists.toString()
                    )
                    TextsInProfileScreen(
                        modifier = Modifier,
                        title = "Updated At:",
                        text = userInfo.updated_at.toString()
                    )
                }
            }
        },
    )

}