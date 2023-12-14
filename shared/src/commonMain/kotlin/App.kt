import androidx.compose.animation.AnimatedVisibility
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import data.dataSource.QuestionsLocalDataSource
import data.repository.QuizRepository
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.questionScreen


private val repository = QuizRepository()
@Composable
fun App() {
    MaterialTheme {
        val questions = repository.questionScope.collectAsState()
        if(questions.value.isNotEmpty()) {
            questionScreen(questions.value)
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun defaultComposable() {
    var greetingText by remember { mutableStateOf("Hello, World!") }
    var showImage by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            greetingText = "Hello, ${getPlatformName()}"
            showImage = !showImage
        }) {
            Text(greetingText)
        }
        AnimatedVisibility(showImage) {
            Image(
                painterResource("compose-multiplatform.xml"),
                contentDescription = "Compose Multiplatform icon"
            )
        }
    }
}

expect fun getPlatformName(): String

@Preview
@Composable
fun AppPreview() {
    App()
}
