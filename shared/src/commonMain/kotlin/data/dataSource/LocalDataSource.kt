package data.dataSource

import model.Answer
import model.Question

class QuestionsLocalDataSource() {

   suspend fun getAllQuestions() : List<Question> = questions

    private val simpleQuestions = listOf(
        Question(
            1,
            "Android is a great platform ?",
            1,
            listOf(Answer(1, "YES"), Answer(2, "NO"))
        ),
        Question(
            1,
            "Android is a bad platform ?",
            2,
            listOf(Answer(1, "YES"), Answer(2, "NO"))
        )
    )
    private val questions = listOf(
        Question(
            id = 1,
            label = "What does KMP stand for in mobile and cross-platform development?",
            correctAnswerId = 1,
            answers = listOf(
                Answer(id = 1, label = "Kotlin Multiplatform"),
                Answer(id = 2, label = "Knowledge Management Platform"),
                Answer(id = 3, label = "Key Messaging Protocol")
            )
        ),
        Question(
            id = 2,
            label = "Which platforms can Kotlin Multiplatform (KMP) target?",
            correctAnswerId = 1,
            answers = listOf(
                Answer(id = 1, label = "iOS, Android, JVM, Web, and more"),
                Answer(id = 2, label = "Android only"),
                Answer(id = 3, label = "Web browsers exclusively")
            )
        ),
        Question(
            id = 3,
            label = "What is the `expect/actual` mechanism used for in KMP?",
            correctAnswerId = 3,
            answers = listOf(
                Answer(id = 1, label = "Error handling in common code"),
                Answer(id = 2, label = "Defining platform-specific UI elements"),
                Answer(
                    id = 3,
                    label = "Specifying multiplatform contracts with platform-specific implementations"
                )
            )
        ),
        Question(
            id = 4,
            label = "What is Jetpack Compose used for?",
            correctAnswerId = 2,
            answers = listOf(
                Answer(id = 1, label = "Data storage in multiplatform applications"),
                Answer(id = 2, label = "Building modern UI for Android and Desktop applications"),
                Answer(id = 3, label = "Cloud-based service integrations")
            )
        ),
        Question(
            id = 5,
            label = "How does Jetpack Compose implement UI components?",
            correctAnswerId = 1,
            answers = listOf(
                Answer(id = 1, label = "Declarative UI"),
                Answer(id = 2, label = "Imperative UI"),
                Answer(id = 3, label = "Functional UI")
            )
        )
    )
}