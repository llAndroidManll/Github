package sahak.sahakyan.github.presentation.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun TypewriterText(
    texts: List<String>,
) {
    var textIndex by remember {
        mutableStateOf(0)
    }
    var textToDisplay by remember {
        mutableStateOf("")
    }

    LaunchedEffect(
        key1 = texts,
    ) {
        while (textIndex < texts.size) {
            texts[textIndex].forEachIndexed { charIndex, _ ->
                textToDisplay = texts[textIndex]
                    .substring(
                        startIndex = 0,
                        endIndex = charIndex + 1,
                    )
                delay(160)
            }
            textIndex = (textIndex + 1) % texts.size
            delay(1500)
        }
    }

    Text(
        text = textToDisplay,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
    )
}