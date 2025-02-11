package soy.gabimoreno.androidxrexample.ui.classic

import android.graphics.Color
import android.view.Gravity
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun ClassicTextView(text: String) {
    AndroidView(
        factory = { context ->
            TextView(context).apply {
                textSize = 24f
                setTextColor(Color.BLACK)
                gravity = Gravity.CENTER
            }
        },
        update = { textView ->
            textView.text = text
        },
    )
}
