object Uncurry {
  // Borrowed from Exercise 2.3
  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
   (a: A) => (b: B) => f(a, b)

  def uncurry[A,B,C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b) 

  // Any good way to test a Uncurrying function?
  def main(args: Array[String]): Unit = {
    var g = curry((a: Int, b: String) => b.toInt == a)
    var h = uncurry(g)
    println(h(2, "2"))
  }
}