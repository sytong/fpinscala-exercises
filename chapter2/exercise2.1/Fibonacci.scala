object Fibonacci {
  // The non tail-recursive implementation
  def fib_non_tailrec(n: Int): Int = {
    def go(n: Int): Int =
      if (n == 0) 0
      else if (n == 1) 1
      else go(n-1) + go(n-2)

    go(n)
  }

  // The tail-recursive implementation
  def fib(n: Int): Int = {
    @annotation.tailrec
    def go(n1: Int, n2: Int, i: Int): Int =
    if (i > n) n1+n2
      else if (i == 0) go(0, 0, i+1)
      else if (i == 1) go(0, 1, i+1)
      else go(n1+n2, n1, i+1)

    go(0, 0, 0) 
  }

  // Pretty print!
  private def formatFib(x: Int) = {
    val msg = "The %d-th Fibonacci number is %d."
    msg.format(x, fib(x))
  }

  // I have no idea if it is the right way to do so...
  private def test() {
    var x = 0
    for (x <- 0 to 11) {
      assert(fib_non_tailrec(x) == fib(x), "Calculation of Fibonacci(" + x + ") failed.")
    }
  }

  def main(args: Array[String]): Unit = {
    println(formatFib(args(0).toInt))
  }
}