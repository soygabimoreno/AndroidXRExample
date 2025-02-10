package soy.gabimoreno.androidxrexample.content

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainContent(mode: String, modifier: Modifier = Modifier) {
    Text(text = "Mode: $mode", modifier = modifier)
}
