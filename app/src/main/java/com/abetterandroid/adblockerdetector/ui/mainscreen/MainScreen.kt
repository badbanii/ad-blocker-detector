package com.abetterandroid.adblockerdetector.ui.mainscreen

import android.os.Process
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val hasAdBlocker by viewModel.hasAdBlocker.observeAsState(initial = false)
    val adBlockName by viewModel.adBlockerName.observeAsState(initial = "")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier =
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .padding(horizontal = 20.dp),
            horizontalArrangement =
            Arrangement.SpaceBetween
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Menu")
            }
            Button(
                onClick = { Process.killProcess(Process.myPid())}) {
                Text(text = "Quit")
            }
        }
        Column(modifier = Modifier.padding(horizontal = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .background(Color.Magenta, RoundedCornerShape(40.dp))
            )
            {
                Text(
                    text = if (hasAdBlocker) "Adblocker is active! \n<$adBlockName>" else "Couldn't find any adblockers using package manager. If you see ads, no adblocker is enabled.",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(all = 20.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
                .padding(top=20.dp)) {
                Text(text = "Test random ad")
            }
        }

        Box(modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(bottom = 20.dp)
            .fillMaxWidth()
            .background(Color.Magenta, RoundedCornerShape(40.dp))
        )
        {
            Text(
                text = "Banner placeholder",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(all = 20.dp),
                textAlign = TextAlign.Center,
            )
        }
    }
}
