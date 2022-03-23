import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestCalculatorV3 {
    @Test
    fun testCalculate() {
        val calculatorV3 = CalculatorV3()
        assertEquals("11111111111111111112", calculatorV3.calculate("11111111111111111111+1"), null)
    }
}