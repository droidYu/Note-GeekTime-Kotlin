import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestProcessorV1 {
   private val text="Kotlin is my favorite language. I love Kotlin!"
    @Test
    fun testProcessorV1(){
        val processorV1=TextProcessorV1()
        val result = processorV1.processText(text)
        assertEquals(2,result[0].frequency)
        assertEquals("Kotlin",result[0].word)
    }
}