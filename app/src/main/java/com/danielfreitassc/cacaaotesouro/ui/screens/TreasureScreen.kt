package com.danielfreitassc.cacaaotesouro.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.danielfreitassc.cacaaotesouro.R

@Composable
fun TreasureScreen(navController: NavController) {

    Image(
        painter = painterResource(id = R.drawable.tesouro),
        contentDescription = "Imagem de fundo",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val buttonSizeHeight = 60.dp
        val cornerRadius = 8.dp

        Text("Você encontrou o Tesouro", color = MaterialTheme.colorScheme.primary, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.popBackStack("home", false)
        },
            modifier = Modifier
                .height(buttonSizeHeight),
            shape = RoundedCornerShape(cornerRadius)
        ) {
            Text("Voltar para Home", fontSize = 24.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultTreasureScreen() {
    TreasureScreen(navController = rememberNavController())
}