import java.util.*
import kotlin.collections.HashSet

fun sum(a: Double, b: Double): Double {
    return a + b
}

fun sub (a: Double, b: Double): Double {
    return a - b
}

fun prod(a: Double, b: Double): Double {
    return a * b
}

fun div(a: Double, b: Double): Double {
    if (b != 0.0) {
        return a / b
    }
    return 0.0
}

fun decision (zn: String, num1: Double, num2: Double) =
        when (zn) {
            "+" -> sum(num1, num2)
            "-" -> sub(num1, num2)
            "*" -> prod(num1, num2)
            "/" -> div(num1, num2)
            else -> num1
        }

fun main (args: Array<String>) {
    val znak = arrayOf("+", "-", "/", "*")
    val exp: List<String>
    var flag = false
    var answer: Double = 0.0
    val oper = Stack<String>()

    print("Enter excpretion: ")
    exp = readLine()!!.split(" ")
    println()

    for (symbol in exp) {
        val sym = symbol.trim()
        if (znak.contains(sym)) {
            oper.push(sym)
        }
        else {
            if (sym.toDoubleOrNull() != null) {
                if (flag) {
                    val zn = oper.pop()
                    answer = decision(zn, answer, sym.toDouble())
                } else {
                    answer = sym.toDouble()
                    flag = true
                }
            }
        }
    }

    println(answer)
}
