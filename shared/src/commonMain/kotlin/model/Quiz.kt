package model

import kotlinx.serialization.Serializable

@Serializable
data class Quiz(val questions: List<Question>)

