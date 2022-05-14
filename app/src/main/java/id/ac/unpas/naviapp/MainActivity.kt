package id.ac.unpas.naviapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import id.ac.unpas.naviapp.ui.theme.NaviAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NaviAppTheme {
                // A surface container using the 'background' color from the theme
                Main()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NaviAppTheme {
        Main()
    }
}