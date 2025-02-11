package soy.gabimoreno.androidxrexample.ui.button

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import soy.gabimoreno.androidxrexample.R
import soy.gabimoreno.androidxrexample.ui.theme.AndroidXRExampleTheme

@Composable
fun FullSpaceModeIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            painter = painterResource(id = R.drawable.ic_full_space_mode_switch),
            contentDescription = stringResource(R.string.switch_to_full_space_mode),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AndroidXRExampleTheme {
        FullSpaceModeIconButton(onClick = {})
    }
}
