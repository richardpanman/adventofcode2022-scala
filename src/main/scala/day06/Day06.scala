import scala.io.Source
import scala.io.Source.fromFile
import scala.util.Using

object Day06 {
  @main def solve_day06(filename: String): Unit =
    val input: String = Using(fromFile(filename))(_.mkString).get
    val stream = input.split("\n")(0)
    println(s"Part 1: ${find_repeat(stream, 4)}")
    println(s"Part 2: ${find_repeat(stream, 14)}")

  def find_repeat(input: String, size: Int): Int =
    return input
      .sliding(size)
      .indexWhere(x => { x.toSet.size == size }) + size
}
