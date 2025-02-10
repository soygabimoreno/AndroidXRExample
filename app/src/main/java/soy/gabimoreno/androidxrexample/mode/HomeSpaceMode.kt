package soy.gabimoreno.androidxrexample.mode

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.xr.compose.platform.LocalHasXrSpatialFeature
import soy.gabimoreno.androidxrexample.content.MainContent
import soy.gabimoreno.androidxrexample.ui.button.FullSpaceModeIconButton
import soy.gabimoreno.androidxrexample.ui.theme.AndroidXRExampleTheme

@SuppressLint("RestrictedApi")
@Composable
fun HomeSpaceMode(onRequestFullSpaceMode: () -> Unit) {
    Surface {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MainContent(mode = "2D", modifier = Modifier.padding(48.dp))
            if (LocalHasXrSpatialFeature.current) {
                FullSpaceModeIconButton(
                    onClick = onRequestFullSpaceMode,
                    modifier = Modifier.padding(32.dp)
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun Preview() {
    AndroidXRExampleTheme {
        HomeSpaceMode(onRequestFullSpaceMode = {})
    }
}
