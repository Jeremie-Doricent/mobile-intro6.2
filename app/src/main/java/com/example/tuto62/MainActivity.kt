package com.example.tuto62

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tuto62.ui.theme.Tuto62Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tuto62Theme(darkTheme = false, dynamicColor = false) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Tape le lapin") },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                    }
                ) { innerPadding ->
                    EcranPrincipal(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun EcranPrincipal(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        AffichageScores(modifier = Modifier.fillMaxWidth().weight(1f))
        TitreApplication(modifier = Modifier.fillMaxWidth().weight(1f))
        GrilleTuiles(modifier = Modifier.fillMaxWidth().weight(5f))
    }
}

@Composable
private fun TitreApplication(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Tape le lapin",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun AffichageScores(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.background(
            Brush.verticalGradient(
                listOf(Color(0xFFC9C9CF), MaterialTheme.colorScheme.background)
            )
        ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "0 Pafs",
                color = Color(0xFF00AA00),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "0 Flops",
                color = Color(0xFFCC1100),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun GrilleTuiles(modifier: Modifier = Modifier) {
    val positionLapin = remember { Random.nextInt(9) }

    Column(modifier = modifier) {
        for (i in 0..2) {
            Row(modifier = Modifier.fillMaxWidth().weight(1f)) {
                for (j in 0..2) {
                    val indexTuile = i * 3 + j
                    Tuile(
                        estLapin = positionLapin == indexTuile,
                        modifier = Modifier.padding(6.dp).fillMaxSize().weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun Tuile(estLapin: Boolean, modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        modifier = modifier
    ) {
        Text(
            text = if (estLapin) "Lapin" else "Taupe",
            fontSize = 25.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tuto62Theme(darkTheme = false, dynamicColor = false) {
        EcranPrincipal()
    }
}