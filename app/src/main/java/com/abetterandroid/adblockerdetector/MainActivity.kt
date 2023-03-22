package com.abetterandroid.adblockerdetector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.abetterandroid.adblockerdetector.ui.mainscreen.MainScreen
import com.abetterandroid.adblockerdetector.ui.mainscreen.MainViewModel
import com.abetterandroid.adblockerdetector.ui.theme.AdBlockerDetectorTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkForAdBlockers()
        setBarColors()
        setContent {
            MyApp {
                MainScreen(viewModel)
            }
        }
    }
    private fun checkForAdBlockers()
    {
        viewModel.checkForAdBlocker(this.baseContext)
    }
    private fun setBarColors()
    {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        window.statusBarColor = resources.getColor(R.color.black)
        window.navigationBarColor=resources.getColor(R.color.black)
    }
    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        MaterialTheme {
            content()
        }
    }
}