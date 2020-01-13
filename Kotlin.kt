import java.util.*
import kotlin.collections.HashSet

fun main (args: Array<String>) {
    val znak = arrayOf("+", "-", "/", "*")
    val exp: List<String>
    var flag = false
    val oper = Stack<String>()

    print("Enter excpretion: ")
    exp = readLine()!!.split(" ")

    for (symbol in exp) {
        val sym = symbol.trim()
        if (znak.contains(sym)) {
            oper.push(sym)
        }
        else {
            if (sym.toDoubleOrNull() != null) {
                if (flag) {
                    val zn = oper.pop()
                    print(zn + " " + sym + " ")
                } else {
                    print(sym + " ")
                    flag = true
                }
            }
        }
    }
}
