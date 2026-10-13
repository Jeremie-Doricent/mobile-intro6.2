 package com.example.tuto62

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            Tuto62Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {Text(text = "tape le lapin")},
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer)

                        )
                    }
                ) { innerPadding ->
                    EcranPrincipal(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun EcranPrincipal( modifier: Modifier = Modifier) {
    Column(
        modifier=modifier.fillMaxSize()
    ) {
        AffichageScores(
            modifier = Modifier.fillMaxWidth()
        )
        TitreApplication(modifier= Modifier.fillMaxWidth())

    }


}

 @Composable
 private fun TitreApplication( modifier: Modifier = Modifier) {

     Box(
         modifier = modifier,
            contentAlignment = Alignment.Center
     ) {
         Text(

             text = "Tape le Lapin"
         )
     }

     GrilleTuiles(modifier = Modifier)
 }

 @Composable
 private fun AffichageScores(modifier: Modifier = Modifier) {
     Row(
         modifier = modifier,
         horizontalArrangement = Arrangement.Center,
         verticalAlignment = Alignment.CenterVertically

     ) {
         Box(
             modifier = Modifier.fillMaxWidth().weight(1f),
             contentAlignment = Alignment.Center
         ) {
             Text(
                 text = "0 pafs"
             )
         }
         Box(
             modifier = Modifier.fillMaxWidth().weight(1f),
             contentAlignment = Alignment.Center
         ){
             Text(
                 text = "0 flops"
             )
         }


     }
 }

 @Composable
 private fun GrilleTuiles(modifier: Modifier) {
    var positionLapin = Random.nextInt(9)

     Column(
         modifier = modifier
     ) {
         for (i in 0..2) {
             Row(
                 modifier = Modifier
             ) {
                 for (j in 0..2) {
                   var indexthuile = i*3 +j
                     Thuile(
                         estlapin = positionLapin ==indexthuile,
                         modifier = Modifier.padding((6.dp))
                     )
                 }
             }
         }
     }
 }

 @Composable
 private fun Thuile(

     estlapin : Boolean, modifier: Modifier) {
     Button(
         onClick = {},
         modifier = modifier
     ) {

         Text(
             text = if (estlapin)"Lapin" else"Taupe",
             fontSize = 25.sp

         )
     }
 }

 @Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tuto62Theme {

    }
}