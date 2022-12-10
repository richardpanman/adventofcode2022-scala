import scala.io.Source
import scala.io.Source.fromFile
import scala.util.Using

object Day03 {
  def score_for_letter(letter: Char): Int =
    // A = 65, Z=90, a=97, z = 122
    val letter_decimal_value = letter.toInt
    val capital_letter = letter_decimal_value <= 90
    if (capital_letter) {
      return letter_decimal_value - 64 + 26
    }
    return letter_decimal_value - 96

  @main def solve_day03(filename: String): Unit =
    val input: String = Using(fromFile(filename))(_.mkString).get
    val answer1 = input
      .split("\n")
      .map(x => x.splitAt(x.length() / 2))
      .map((p1, p2) => p1 intersect p2)
      .map(letter => score_for_letter(letter.charAt(0)))
      .sum
    println(s"Part 1: $answer1")

    val answer2 =
      input
        .split("\n")
        .sliding(3, 3)
        .toList
        .map(x => x(0) intersect x(1) intersect x(2))
        .map(letter => score_for_letter(letter.charAt(0)))
        .sum
    println(s"Part 2: $answer2")
}
