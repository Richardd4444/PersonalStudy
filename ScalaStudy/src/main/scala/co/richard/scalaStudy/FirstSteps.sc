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

/*
Square Dance!
Define an object called calc with a method square that accepts a Double
as an argument and… you guessed it… squares its input. Add a method called
cube that cubes its input calling square as part of its result calculation.
*/

object calc{
  def square(n:Double):Double = {
    n*n
  }
  def cube(n:Double):Double = {
    square(n)*n
  }
}

/*
Precise Square Dance!
Copy and paste calc from the previous exercise to create a calc2 that is
generalized to work with Ints as well as Doubles. If you have Java experience,
this should be fairly straightforward. If not, read the solution below.
*/

object calc2{
  def square(n:Double):Double = {
    n*n
  }
  def cube(n:Double):Double = {
    square(n)*n
  }

  def square(n:Int):Int = {
    n*n
  }
  def cube(n:Int): Int = {
    square(n) * n
  }
}

/*
Order of evaluation
When entered on the console, what does the following program output, and
what is the type and value of the final expression? Think carefully about the
types, dependencies, and evaluation behaviour of each field and method.
*/
object argh {
  def a = {
    println("a")
    1
  }
  val b = {
    println("b")
    a + 2
  }
  def c = {
    println("c")
    a
    b + "c"
  }
}

argh.c + argh.b + argh.a

/*
Greetings, human
Define an object called person that contains fields called firstName and
lastName. Define a second object called alien containing a method called
greet that takes your person as a parameter and returns a greeting using their
firstName.
What is the type of the greet method? Can we use this method to greet other
objects?
*/

object person{
  val firstName: String = "Richard"
  val lastName: String = "Mendoza"
}

object alien{
  def greet(p: person.type): String = {
    "Greetings, " + p.firstName + " " + p.lastName
  }
}

alien.greet(person)

// Test Cases

assert(calc2.square(2.0) == 4.0)
assert(calc2.square(3.0) == 9.0)
assert(calc2.square(-2.0) == 4.0)

// Declaration

def square(in: Double): Double = in * in

/* We can use ??? when we don't know the body of the method and
continue with the code */

// Compound expressions

{
  println("This is a side-effect")
  println("This is a side-effect as well")
  3
}