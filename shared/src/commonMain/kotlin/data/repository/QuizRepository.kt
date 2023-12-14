package data.repository

import data.QuizApi
import data.dataSource.QuestionsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import model.Question

class QuizRepository() {
    private val quizApi = QuizApi()
    private val mockQuestionApi = QuestionsLocalDataSource()
    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    private var _questionState = MutableStateFlow(listOf<Question>())
    val questionScope = _questionState

    init{
        updateQuiz()
    }

    private suspend fun fetchQuestions() = quizApi.getAllQuestions().questions

    private fun updateQuiz() {
        coroutineScope.launch {
            _questionState.value = fetchQuestions()
        }
    }
}