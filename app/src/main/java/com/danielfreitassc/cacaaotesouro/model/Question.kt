package com.danielfreitassc.cacaaotesouro.model

data class Question(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correctAnswer: String
)