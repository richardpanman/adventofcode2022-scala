import scala.io.Source
import scala.io.Source.fromFile
import scala.util.Using

object Day01 {
  @main def solve_day01(filename: String): Unit =
    val input = Using(fromFile(filename))(_.mkString).get
    val calories = input.split("\n\n").map(_.split("\n").map(_.toInt))
    val top3 = calories.map(_.sum).sorted.reverse.take(3)
    println(s"Part 1: ${top3(0)}")
    println(s"Part 2: ${top3.sum}")
}
