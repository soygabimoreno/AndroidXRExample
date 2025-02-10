package soy.gabimoreno.androidxrexample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.xr.compose.platform.LocalSession
import androidx.xr.compose.platform.LocalSpatialCapabilities
import androidx.xr.compose.spatial.Subspace
import soy.gabimoreno.androidxrexample.mode.HomeSpaceMode
import soy.gabimoreno.androidxrexample.mode.FullSpaceMode
import soy.gabimoreno.androidxrexample.ui.theme.AndroidXRExampleTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidXRExampleTheme {
                val session = LocalSession.current
                if (LocalSpatialCapabilities.current.isSpatialUiEnabled) {
                    Subspace {
                        FullSpaceMode(onRequestHomeSpaceMode = { session?.requestHomeSpaceMode() })
                    }
                } else {
                    HomeSpaceMode(onRequestFullSpaceMode = { session?.requestFullSpaceMode() })
                }
            }
        }
    }
}
