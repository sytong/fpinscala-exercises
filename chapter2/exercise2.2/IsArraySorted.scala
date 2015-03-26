object IsArraySorted {
  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n: Int, r: Boolean): Boolean = 
      if (n > as.length - 2) r
      else loop(n+1, ordered(as(n), as(n+1)) && r)

    loop(0, true)
  }

  def main(args: Array[String]): Unit = {
    assert(isSorted(Array(1,2,3,4,5), (a: Int, b: Int) => a <= b), 
      "Failed to recognize an Int array sorted in ascending order")
    assert(isSorted(Array(5,4,3,2,1), (a: Int, b: Int) => b <= a), 
      "Failed to recognize an Int array sorted in ascending order")
    assert(isSorted(Array(2,1,3,4,5), (a: Int, b: Int) => a <= b) == false, 
      "Failed to recognize an Int array with 2 incorrectly sorted elements at the head")
    assert(isSorted(Array(1,2,3,5,4), (a: Int, b: Int) => a <= b) == false, 
      "Failed to recognize an Int array with 2 incorrectly sorted elements at the tail")
    assert(isSorted(Array(1,1,1,1,1), (a: Int, b: Int) => a <= b), 
      "Failed to recognize an Int array with all identical elements as sorted") 
    assert(isSorted(Array(1), (a: Int, b: Int) => a <= b), 
      "Failed to recognize an Int array with just one element as sorted")
    assert(isSorted(Array(1, 2), (a: Int, b: Int) => a <= b), 
      "Failed to recognize an Int array with 2 elements sorted in ascending order")

    println("All tests passed. All is well!!")
  }
}