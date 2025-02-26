package soy.gabimoreno.androidxrexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.xr.compose.spatial.SpatialDialog
import soy.gabimoreno.androidxrexample.ui.classic.ClassicTextView

@Composable
fun MainContent(
    mode: String,
    modifier: Modifier = Modifier,
) {
    var showDialog by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxWidth(BOX_SIZE)
            .fillMaxHeight(BOX_SIZE),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Mode: $mode",
            fontSize = FONT_SIZE,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(64.dp))
        Button(
            onClick = {
                showDialog = true
            },
        ) {
            Text(
                text = "Go!",
                fontSize = FONT_SIZE,
                modifier = Modifier.padding(16.dp),
            )
        }
        if (showDialog) {
            SpatialDialog(
                onDismissRequest = {
                    showDialog = false
                },
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(Color.White)
                        .padding(64.dp),
                ) {
                    Text(
                        text = "I'm a Dialog!",
                        color = Color.Black,
                        fontSize = FONT_SIZE,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    ClassicTextView("I'm a classic TextView.")
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = {
                            showDialog = false
                        },
                    ) {
                        Text(
                            text = "Close",
                            fontSize = FONT_SIZE,
                            modifier = Modifier.padding(16.dp),
                        )
                    }
                }
            }
        }
    }
}

private const val BOX_SIZE = 0.9f
private val FONT_SIZE = 64.sp
