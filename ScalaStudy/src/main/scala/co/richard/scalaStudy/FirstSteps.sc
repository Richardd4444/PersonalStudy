object FirstSteps {
  println("Welcome to the Scala worksheet")

  1+1

  if(20>10) "left" else "right"

  println("The ultimate answer is " + 42)

  1 + 2

  "3".toInt

  //"foo".toInt

  "hello".toUpperCase

  "abcdef".take(3)

  "abcdef".take(2)

  "hello".toUpperCase.toLowerCase

  "the quick brown fox" split " "

  "the quick brown fox".split(" ")

}

// Object declaration

object Test2{
  def name: String = "Probably the best object ever"
}

Test2.name

// An object with params

object Test3{
  def hello(name: String) = "Hello " + name
}

Test3.hello("Richard")

/*
Cat-o-matique
The table below shows the names, colour, and favourite foods of three cats.
Define an object for each cat. (For experienced programmers: we haven’t
covered classes yet.)
*/

object Oswald{
  val colour:String = "Black"
  val food:String = "Milk"
}

object Henderson{
  val colour:String = "Ginger"
  val food:String = "Chips"
}

object Quentin{
  val colour:String = "Tabby and white"
  val food:String = "Curry"
}

