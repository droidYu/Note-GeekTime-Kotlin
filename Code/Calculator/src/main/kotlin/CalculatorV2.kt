import kotlin.system.exitProcess

fun main() {
    val calculatorV2 = CalculatorV2()
    calculatorV2.start()
}

class CalculatorV2 {
    fun start() {
        while (true) {
            println(help)
            val input = readLine() ?: continue
            val result = calculate(input)
            if (result == null) {
                println("Error")
                continue
            } else {
                println("$input = $result")
            }
        }
    }

    private fun calculate(input: String): Int? {
        if (shouldExit(input)) exitProcess(0)
        val exp = parseExp(input) ?: return null
        val left = exp.left
        val operation = exp.operation
        val right = exp.right

        return when (operation) {
            Operation.ADD -> add(left, right)
            Operation.MINUS -> minus(left, right)
            Operation.MULTI -> multi(left, right)
            Operation.DIVIDE -> divide(left, right)
        }

    }


    private fun parseExp(input: String): Exp? {
        val operation = parseOperation(input) ?: return null
        val list = input.split(operation.value)
        if (list.size != 2) return null
        val left = list[0].trim()
        val right = list[1].trim()
        return Exp(left, operation, right)
    }

    private fun parseOperation(input: String): Operation? {
        Operation.values().forEach {
            if (input.contains(it.value))
                return it
        }
        return null
    }

    private fun shouldExit(input: String) = input == "exit"

    private fun add(left: String, right: String) = left.toInt() + right.toInt()
    private fun minus(left: String, right: String) = left.toInt() - right.toInt()
    private fun multi(left: String, right: String) = left.toInt() * right.toInt()
    private fun divide(left: String, right: String) = left.toInt() / right.toInt()

    class Exp(val left: String, val operation: Operation, val right: String)
}