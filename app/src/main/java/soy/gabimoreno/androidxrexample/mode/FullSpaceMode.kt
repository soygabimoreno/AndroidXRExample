package soy.gabimoreno.androidxrexample.mode

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.xr.compose.platform.LocalSession
import androidx.xr.compose.spatial.Subspace
import androidx.xr.compose.subspace.SpatialLayoutSpacer
import androidx.xr.compose.subspace.SpatialRow
import androidx.xr.compose.subspace.Volume
import androidx.xr.compose.subspace.layout.SubspaceModifier
import androidx.xr.compose.subspace.layout.offset
import androidx.xr.compose.subspace.layout.scale
import androidx.xr.compose.subspace.layout.width
import androidx.xr.scenecore.GltfModelEntity
import androidx.xr.scenecore.SpatialCapabilities
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.guava.await
import kotlinx.coroutines.launch
import soy.gabimoreno.androidxrexample.ui.spatial.MySpatialPanel

@SuppressLint("RestrictedApi")
@Composable
fun FullSpaceMode(onRequestHomeSpaceMode: () -> Unit) {
    val session = requireNotNull(LocalSession.current)
    val scope = rememberCoroutineScope()
    Subspace {
        Volume(
            modifier = SubspaceModifier
                .offset(0.dp, 0.dp, 0.dp)
                .scale(1.2f),

            ) { parent ->
            scope.launch {
                val gltfModel = session.createGltfResourceAsync(
                    "models/saturn_rings.glb",
                ).await()

                if (session.getSpatialCapabilities()
                        .hasCapability(SpatialCapabilities.SPATIAL_CAPABILITY_3D_CONTENT)
                ) {
                    // create the gltf entity using the gltf file from the previous snippet
                    val gltfEntity = GltfModelEntity.create(session, gltfModel)
                }
            }
        }
    }



    LaunchedEffect(Unit) {
        scope.launch(Dispatchers.Main) {

        }
    }

    SpatialRow {
        MySpatialPanel(onRequestHomeSpaceMode)
        SpatialLayoutSpacer(SubspaceModifier.width(48.dp))
        MySpatialPanel(onRequestHomeSpaceMode)
    }
}
