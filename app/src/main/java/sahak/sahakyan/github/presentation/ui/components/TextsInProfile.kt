package sahak.sahakyan.github.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import sahak.sahakyan.github.presentation.ui.theme.Gray
import sahak.sahakyan.github.presentation.ui.theme.Roboto

@Composable
fun TextsInProfileScreen(
    modifier: Modifier = Modifier,
    title: String = "",
    text: String = "",
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
        ,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            modifier = Modifier,
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontFamily = Roboto,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = text,
            modifier = Modifier,
            color = Gray,
            fontWeight = FontWeight.Light,
            fontFamily = Roboto,
            style = MaterialTheme.typography.titleSmall
        )
    }
}