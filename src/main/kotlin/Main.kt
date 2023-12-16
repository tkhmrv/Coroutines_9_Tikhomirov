import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        // Запуск корутины для часов "tick" с длительностью 5 секунд
        val job1 = launch {
            clock(5, "tick")
        }
        // Запуск корутины для часов "tack" с длительностью 7 секунд
        val job2 = launch {
            clock(7, "tack")
        }
        // Запуск корутины для часов "tuck" с длительностью 10 секунд
        val job3 = launch {
            clock(10, "tuck")
        }

        // Ждем завершения всех корутин
        job1.join()
        job2.join()
        job3.join()
    }
}

suspend fun clock(seconds: Int, sound: String) {
    for (i in 0 until seconds - 1) {
        delay(1000L)
        println("$sound (${i + 1})\t")
    }
    delay(1000)
    println("$sound ($seconds) = BOOM")
}
