import scala.io.Source
import scala.io.Source.fromFile
import scala.util.Using

object Day02 {
  val scoring: Map[String, Int] = Map(
    "A X" -> 4, // R R - R draw
    "A Y" -> 8, // R P - P win
    "A Z" -> 3, // R S - S loss
    "B X" -> 1, // P R - R loss
    "B Y" -> 5, // P P - P draw
    "B Z" -> 9, // P S - S win
    "C X" -> 7, // S R - R win
    "C Y" -> 2, // S P - P loss
    "C Z" -> 6 // S S - S draw
  )

  // X  lose, Y draw, Z win
  val map_strategy_change: Map[String, String] = Map(
    "A X" -> "A Z", // R lose - S
    "A Y" -> "A X", // R draw - R
    "A Z" -> "A Y", // R win - P
    "B X" -> "B X", // P lose - R
    "B Y" -> "B Y", // P draw - P
    "B Z" -> "B Z", // P win - S
    "C X" -> "C Y", // S lose - P
    "C Y" -> "C Z", // S draw - S
    "C Z" -> "C X" // S win - R
  )

  @main def solve_day02(filename: String): Unit =
    val input = Using(fromFile(filename))(_.mkString).get
    val answer1 = input.split("\n").map(scoring.getOrElse(_, 0)).sum
    val answer2 =
      input
        .split("\n")
        .map(map_strategy_change.getOrElse(_, ""))
        .map(scoring.getOrElse(_, 0))
        .sum
    println(s"Part 1: $answer1")
    println(s"Part 2: $answer2")
}
