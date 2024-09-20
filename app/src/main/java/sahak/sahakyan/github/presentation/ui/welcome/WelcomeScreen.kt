package sahak.sahakyan.github.presentation.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import sahak.sahakyan.github.R
import sahak.sahakyan.github.presentation.ui.components.TypewriterText
import sahak.sahakyan.github.presentation.ui.theme.dimens

@Composable
fun WelcomeScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(
            painter = painterResource(R.drawable.logo),
            "",
            modifier = Modifier
                .size(MaterialTheme.dimens.large)
            ,
        )
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.small1))
        TypewriterText(listOf("BY SAHAK SAHAKYAN"))
    }
}

@Composable
@Preview(showBackground = true)
fun WelcomeScreenPreview() {
    WelcomeScreen()
}