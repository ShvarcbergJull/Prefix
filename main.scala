import scala.collection.mutable

object main extends App{


  val oper = Array("+", "-", "/", "*")
  val op = new mutable.Stack[String]()
  var flag = false
  val exp = (scala.io.StdIn.readLine()).split(" ")

  for (sym <- exp) {
    if (oper.contains(sym)) {
      op.push(sym)
    }
    else {
      if (sym.toDoubleOption != None) {
        if (flag) {
          val zn = op.pop()
          print(zn + " " + sym + " ")
        }
        else {
          print(sym + " ")
          flag = true
        }
      }
    }
  }
}
