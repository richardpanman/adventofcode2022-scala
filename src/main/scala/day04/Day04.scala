import scala.io.Source
import scala.io.Source.fromFile
import scala.util.Using

object Day04 {
  @main def solve_day04(filename: String): Unit =
    val input: String = Using(fromFile(filename))(_.mkString).get
    val answer1 = input
      .split("\n")
      .map(_.split("[,-]"))
      .map(x => x.map(_.toInt))
      .count(x =>
        (x(0) >= x(2) && x(1) <= x(3)) || (x(2) >= x(0) && x(3) <= x(1))
      )
    println(s"Part 1: $answer1")

    val answer2 = input
      .split("\n")
      .map(_.split("[,-]"))
      .map(x => x.map(_.toInt))
      .count(x =>
        (Range.inclusive(x(0), x(1)) intersect Range
          .inclusive(x(2), x(3))).size > 0
      )
    println(s"Part 2: $answer2")
}
