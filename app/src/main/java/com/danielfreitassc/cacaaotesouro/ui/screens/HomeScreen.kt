package com.danielfreitassc.cacaaotesouro.ui.screens

import com.danielfreitassc.cacaaotesouro.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController) {
    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = "Imagem bonitinha para pagina home",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val buttonSizeHeight = 70.dp
        val cornerRadius = 8.dp

        Text("Caça ao Tesouro", fontSize = 32.sp, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("question/1") },
            modifier = Modifier
                .height(buttonSizeHeight),
            shape = RoundedCornerShape(cornerRadius)
        ) {
            Text("Iniciar", fontSize = 24.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultHomeScreen() {
    HomeScreen(navController = rememberNavController())
}