# Notes as I go along

Because I'm using this to learn Scala, I need to write down stuff as I go along :smile:

## Functions don't necessarily have brackets

It looks like if a function has no arguements then it doesn't need brackets.

```scala
println(s"Part 2: ${top3.sum}")
```

## Map is useful on lists

`_` is used to denote the current item

```scala
val top3 = calories.map(_.sum).sorted.reverse.take(3)
```

## The function to run when a class is called is marked by @main

```scala
object Day01 {
  @main def solve_day01(filename: String): Unit =
    ...
}
```

The main function can be run from sbt on the command line like this:

```bash
sbt "runMain day01.Main src/main/scala/day01/puzzle_input.txt"
```
