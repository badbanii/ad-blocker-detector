package com.abetterandroid.adblockerdetector.ui.mainscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen() {
  //  val hasAdBlocker by viewModel.hasAdBlocker.observeAsState(initial = null)
val hasAdBlocker=true
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (hasAdBlocker == true) {
            Text(text = "An ad blocker is installed on this device.")
        } else if (hasAdBlocker == false) {
            Text(text = "No ad blocker detected.")
        } else {
            // Placeholder text while the ad blocker check is in progress
            Text(text = "Checking for ad blockers...")
        }
    }
}