package soy.gabimoreno.androidxrexample.mode

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.xr.compose.platform.LocalSession
import androidx.xr.compose.spatial.EdgeOffset
import androidx.xr.compose.spatial.Orbiter
import androidx.xr.compose.spatial.OrbiterEdge
import androidx.xr.compose.spatial.Subspace
import androidx.xr.compose.subspace.SpatialLayoutSpacer
import androidx.xr.compose.subspace.SpatialRow
import androidx.xr.compose.subspace.Volume
import androidx.xr.compose.subspace.layout.SpatialRoundedCornerShape
import androidx.xr.compose.subspace.layout.SubspaceModifier
import androidx.xr.compose.subspace.layout.offset
import androidx.xr.compose.subspace.layout.width
import androidx.xr.scenecore.GltfModel
import androidx.xr.scenecore.GltfModelEntity
import androidx.xr.scenecore.MovableComponent
import androidx.xr.scenecore.SpatialCapabilities
import androidx.xr.scenecore.getSpatialCapabilities
import kotlinx.coroutines.guava.await
import kotlinx.coroutines.launch
import soy.gabimoreno.androidxrexample.ui.spatial.MySpatialPanel

@SuppressLint("RestrictedApi")
@Composable
fun FullSpaceMode(onRequestHomeSpaceMode: () -> Unit) {
    SpatialRow {
        Orbiter(
            position = OrbiterEdge.Start,
            offset = EdgeOffset.inner(8.dp),
            shape = SpatialRoundedCornerShape(size = CornerSize(50))
        ) {
            ObjectInAVolume(true)
        }
        SpatialLayoutSpacer(SubspaceModifier.width(48.dp))
        MySpatialPanel(onRequestHomeSpaceMode)
    }
}

@Composable
fun ObjectInAVolume(show3DObject: Boolean) {
    val xrCoreSession = checkNotNull(LocalSession.current)
    val scope = rememberCoroutineScope()
    if (show3DObject) {
        Subspace {
            Volume(
                modifier = SubspaceModifier
                    .offset(100.dp, 100.dp, 100.dp)
            ) { parent ->
                scope.launch {
                    val gltfModel = GltfModel.create(xrCoreSession, "models/cow.glb").await()

                    if (xrCoreSession.getSpatialCapabilities()
                            .hasCapability(SpatialCapabilities.SPATIAL_CAPABILITY_3D_CONTENT)
                    ) {
                        GltfModelEntity.create(xrCoreSession, gltfModel, ).apply {
                            val movableComponent = MovableComponent.create(
                                session = xrCoreSession,
                                systemMovable = true,
                                scaleInZ = false,
                            )
                            setScale(3f)
                            addComponent(movableComponent)
                            parent.addChild(this)
                        }
                    }
                }
            }
        }
    }
}
