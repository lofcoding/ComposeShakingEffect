package com.example.composeshakingalert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeshakingalert.ui.theme.ComposeShakingAlertTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeShakingAlertTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    val shakeState = rememberShakingState(
                        strength = ShakingState.Strength.Strong,
                        direction = ShakingState.Direction.LEFT_THEN_RIGHT
                    )
                    val scope = rememberCoroutineScope()

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        TextButton(
                            modifier = Modifier.shakable(shakeState),
                            onClick = {
                                scope.launch {
                                    shakeState.shake(
                                        animationDuration = 40
                                    )
                                }
                            }
                        ) {
                            Text(text = "Shake Me", fontSize = 22.sp)
                        }
                    }
                }
            }
        }
    }
}