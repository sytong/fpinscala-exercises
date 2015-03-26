object Compose {
  def compose[A,B,C](f: B => C, g: A => B): A => C =
    (a: A) => f(g(a))

  // Will write better test cases for this later
  def main(args: Array[String]): Unit = {
    var g = (a: String) => a.toInt
    var f = (b: Int) => b > 100
    var h = compose(f, g)
    println(h("200"))
    println(h("20"))
  }
}