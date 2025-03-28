package com.danielfreitassc.cacaaotesouro.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
import com.danielfreitassc.cacaaotesouro.R
import com.danielfreitassc.cacaaotesouro.model.Question

@Composable
fun QuestionScreen(navController: NavController, attempt: Int) {
    var answer by remember { mutableStateOf("") }
    var feedback by remember { mutableStateOf("") }

    val questions = listOf(
        Question(1, "Qual a próxima letra após 'B'?", listOf("A", "B", "C"), "C"),
        Question(2, "Qual número vem depois do 2?", listOf("1", "2", "3"), "3"),
        Question(3, "Qual é a cor do céu?", listOf("Azul", "Verde", "Vermelho"), "Azul")
    )

    val question = questions.getOrElse(attempt - 1) {
        Question(0, "Pergunta desconhecida", listOf("A", "B", "C"), "A")
    }

    val backgroundRes = when (attempt) {
        1 -> R.drawable.background1
        2 -> R.drawable.background2
        3 -> R.drawable.background3
        else -> R.drawable.background1
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = backgroundRes),
            contentDescription = "Imagem de fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Pergunta $attempt: ${question.question}", color = MaterialTheme.colorScheme.primary, fontSize = 19.sp)
            Spacer(modifier = Modifier.height(16.dp))

            val buttonSize = Modifier
                .height(50.dp)
                .width(200.dp)

            question.options.forEach { option ->
                Button(
                    onClick = {
                        answer = option
                        feedback = if (option == question.correctAnswer) {
                            "Você acertou!"
                        } else {
                            "Resposta errada, tente novamente!"
                        }
                    },
                    modifier = buttonSize,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(option)
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Sua resposta: $answer", color = MaterialTheme.colorScheme.primary, fontSize = 19.sp)
            Text(feedback, color = if (feedback == "Você acertou!") Color.Green else Color.Red, fontSize = 32.sp)

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("Voltar")
            }

            if (feedback == "Você acertou!") {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if (attempt < 3) {
                            navController.navigate("question/${attempt + 1}")
                        } else {
                            navController.navigate("treasure")
                        }
                    }
                ) {
                    Text(if (attempt < 3) "Próxima Pergunta" else "Você encontrou o Tesouro!")
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultQuestionScreen() {
    QuestionScreen(navController = rememberNavController(), attempt = 1)
}
