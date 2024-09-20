package sahak.sahakyan.github.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import sahak.sahakyan.github.R
import sahak.sahakyan.github.data.model.User
import sahak.sahakyan.github.presentation.ui.theme.Gray
import sahak.sahakyan.github.presentation.ui.theme.Poppins
import sahak.sahakyan.github.presentation.ui.theme.Roboto

@Composable
fun UserView(
    user: User = User(),
    onProfileClick: (String) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 13.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(100))

            ) {
                AsyncImage(
                    model = user.avatar_url,
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            Column(
                modifier = Modifier
                ,
                verticalArrangement = Arrangement.spacedBy(3.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = user.login.toString(),
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Black
                )
                Row(

                ) {
                    Text(
                        text = "Id:",
                        fontFamily = Roboto,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Gray
                    )
                    Spacer(modifier = Modifier.size(2.dp))
                    Text(
                        text = user.id.toString(),
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light,
                        style = MaterialTheme.typography.titleSmall,
                        color = Gray
                    )
                }

            }

        }

        IconButton(
            onClick = {
                onProfileClick(user.login.toString())
            },
            modifier = Modifier
                .size(24.dp)
            ,
        ) {
            Image(
                painter = painterResource(R.drawable.arrow),
                contentDescription = "Arrow Right",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserViewPreview() {
    UserView(
        user = User(
            id = 1,
            login = "mojombo",
            avatar_url = "https://avatars.githubusercontent.com/u/1?v=4",
        )
    )
}