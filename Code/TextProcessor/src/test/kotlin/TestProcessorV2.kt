import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestProcessorV2 {
   private val text="Kotlin is my favorite language. I love Kotlin!"
    @Test
    fun testProcessorV2(){
        val processorV2=TextProcessorV2()
        val result = processorV2.processText(text)
        assertEquals(2,result[0].frequency)
        assertEquals("Kotlin",result[0].word)
    }
}