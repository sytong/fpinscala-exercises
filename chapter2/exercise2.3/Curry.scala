object Curry {
  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
   (a: A) => (b: B) => f(a, b)

  // Any good way to test a Currying function?
  def main(args: Array[String]): Unit = {
    var g = curry((a: Int, b: String) => b.toInt == a)
    var h = g(123445)
    println(h("123445"))
  }
}