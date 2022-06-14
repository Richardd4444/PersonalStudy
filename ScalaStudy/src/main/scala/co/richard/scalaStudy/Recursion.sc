import java.util.Scanner

/** Funciones puras
 * Retornan un solo resultado
 * Su resultado se basa unicamente en los parametros de entrada
 * No modifica o muta un valor existente dentro de una funcion
 */

/** Problema del estado mutable compartido
 * Es un estado porque es una variable conocida
 * Puede ser modificado
 * Cualquier funcion o procedimiento lo puede manipular
 */

/** Recursividad
 * 1. Funciones : Directas e inmersas
 * 2. Datos
 */

def potencia(a:Double,n:Int):Double = n match {
  case 0 => 1
  case n => a * potencia(a,n-1)
}

//potencia(2,3)

/** Conclusiones
 * El diseño recursivo es más compacto
 * El diseño recursivo se adapta mejor a la PF
 * El diseño recursivo no es tan eficiente
 */

def factorial(n:Int):Double = n match {
  case 0 => 1
  case n => n * factorial(n-1)
}

factorial(5)

def incr(n: Int): Int = n + 1
def decr(n: Int): Int = n - 1

def sumaRecursiva(a:Int,b:Int):Int = (a,b) match {
  case (a,0) => a
  case (0,b) => b
  case (a,b) => sumaRecursiva(incr(a),decr(b))
}

sumaRecursiva(4,4)

/** Funciones inmersas
 * Funciones delegadas para poder crear la recursividad
 */

def raizEntera(n:Int):Int = {
  def iraiz(n:Int, a:Int):Int = {
    val a2 = a * a
    if(a2 > n) 0
    else{
      val r = iraiz(n,2*a)
      val ra = r + a
      val ra2 = ra * ra
      if(n<ra2) r else ra
    }
  }
  iraiz(n,1)
}

raizEntera(9)

def expoNat(x:Double):Double = {
  def iExpoNat(x:Double, n:Int, acum:Double):Double = n match {
    case 11 => acum
    case n => iExpoNat(x, n+1, acum + (potencia(x,n) / factorial(n).toDouble))
  }
  iExpoNat(x, 0, 0.0)
}

expoNat(1)

def potencia2(a:Double, n:Int):Double = n match {
  case 1 => a
  case n if (n%2 == 0) => {
    val an2 = potencia2(a, n/2)
    an2 * an2
  }
  case n => a * potencia2(a, n-1)
}

potencia2(2.2,3)

/** Posicion de cola
 * Cuando todos los puntos de retorno de una funcion son llamadas de cola
 * o el retorno de un valor literal se dice qur esta fimcopm tienne posicion
 * de cola
 */

def potenciaC(a:Double,n:Int):Double = {
  def iPotencia(a:Double, n:Int, r:Double):Double = n match {
    case 0 => r
    case n => iPotencia(a,n-1, r * a)
  }
  iPotencia(a,n,1.0)
}

potenciaC(2,3)

def fibRecCola(n:Int):Int = {
  def iFib(n:Int, t:(Int,Int)):Int = n match {
    case 0 => t._1
    case 1 => t._2
    case n => iFib(n-1,(t._2,t._1 + t._2))
  }
  iFib(n,(0,1))
}

// Valores como funciones

val suma = (a:Int,b:Int) => a+b

suma(1,2)

// Funciones compuestas

def composicion(f:Int => Int, g:Int =>Int):Int => Int = (x:Int) => f(g(x))
val funcion = composicion(_+1,_*2)
funcion(3)

/** Comodines
 * Es un simbolo dentro de un lenguaje de programacion, que en un contexto
 * determinado tiene un significado diferente
 */

/** Clausulas
 * Variable libre = No se encuentran ligadas al parametro (No definida en el contexto)
 * Variable ligada = Esta ligada a los parametros de la funcion (Definida en el contexto)
 * Una Clausura es una funcion cuyo valor de retorno depende de una o mas variables
 * declaradas fuera de la funcion, es decir, depende de variables libres
 */

object Clausura {
  val mas = 10
  val sumaMas = new Function1[Int,Int]{
    def apply(x: Int): Int = x + mas
  }
}

/** Transparencia referencial
 * Una misma expresion denota siempre el mismo valor sea el punto dentro de un
 * programa donde esta aparezca
 *
 * Si aplico los mismos parametros a una funcion en cualquier parte del
 * programa, obtendre siempre los mismos resultados
 */

val funcion = (a:Int, b:Double, c:Int, d:Double) => (a*b)/(c*d)
val nuevaFuncion = funcion(_,0.3,_,0.4)
nuevaFuncion(2,1)

/** Tipos de llamadas
 * Llamado por valor: Pasa una copia, no el valor original
 * Llamado por referencia: Es una direccion conocida del objeto a pasar
 * Llamado por nombre: Cada que se llama se vuelve a evaluar
 * Llamado por necesidad: Solo se evalua una vez pero se debe indicar cuando se utiliza
 * la evaluacion, se usa anteponiendo "lazy" para que luego sea evaluado al
 * momento de ser invocado
 */

// Paso por referencia
def comp1(x:Int):Array[Int] = Array(x,x,x)

// Paso por nombre
def comp2(x: => Int):Array[Int] = Array(x,x,x)

// Paso por necesidad
def comp3(x: => Int):Array[Int] = {
  lazy val y = x
  Array(y,y,y)
}

/** Currificacion
 * La idea consiste en aplicar un argumentoa a la vez y obtener una funcion
 * hasta que finalmente no existan argumentos y obtendremos el valor.
 * La currificación se hace un argumento a la vez y en orden de izquierda a
 * derecha.
 */

// Firma original
val valOrtoedro = (a:Double,b:Double,c:Double) => a * b * c

// Firma de valor currificado
val valOrtoedroCur = (a:Double) => (b:Double) => (c:Double) => a * b * c

// Firma de funcion currificada
def valOrtoedroCurrf(a:Double)(b:Double)(c:Double):Double = a * b * c

// Funcion currificada y llamada por nombre, loop
def loop(times:Int)(body: => Unit):Unit =
  if (times > 0){body; loop(times-1)(body)} else ()

// Uso de la funcion loop para sumar dos enteros
def loopExample():Unit = {
  val scan = new Scanner(System.in)
  loop(5){
    println("Digite dos valores")
    val a = scan.nextInt()
    val b = scan.nextInt()
    println("El resultado es: " + (a+b))
  }
}

// if_then_else usando currificacion y llamado por nombre
def if_then_else(pred:Boolean, thenPart: => Unit, elsePart: => Unit) = if (pred) thenPart else elsePart

def notOkAction = { println("Not OK")}
def okAction    = { println("OK") }

if_then_else(true,  okAction, notOkAction)
if_then_else(false, okAction, notOkAction)

// Inversion de parametros mediante currificacion
val sumaID = (a:Int) => (b:Double) => a + b
val multID = (a:Int) => (b:Double) => a * b

def inversaID2DI(f:Int => Double => Double):Double => Int => Double = (b:Double) => (a:Int) => f(a)(b)

val sumaDI:Double => Int => Double = inversaID2DI(sumaID)
val multDI:Double => Int => Double = inversaID2DI(multID)

sumaID(3)(4.0) == sumaDI(4.0)(3)
multID(9)(5.0) == multDI(5.0)(9)

// Currificar funciones no currificadas
val sumaNC = (a:Int,b:Double) => a + b
val multNC = (a:Int,b:Double) => a * b

def convertirACurry(f:(Int,Double) => Double):Int => Double => Double = (a:Int) => (b:Double) => f(a,b)

val sumaC:Int => Double => Double = convertirACurry(sumaNC)
val multC:Int => Double => Double = convertirACurry(multNC)

sumaNC(5,4.0) == sumaC(5)(4.0)
multNC(3,8.1) == multC(3)(8.1)

// Currificacion por propiedad de FunctionN
val sumaNC = (a:Int,b:Double) => a + b
val multNC = (a:Int,b:Double) => a * b

val sumaC:Int => Double => Double = sumaNC.curried
val multC:Int => Double => Double = multNC.curried

sumaNC(3,9.3) == sumaC(3)(9.3)
multNC(2,5.7) == multC(2)(5.7)

/**
 * Como se ha dicho anteriormente, una de las ventajas de la currificación en conjunto con el paso por
 * nombres y pasar bloques de instrucciones como argumentos,
 * es que nos permite ampliar el lenguaje con nuevos constructores.
 *
 * Vamos a retomar el ejercicio usando los anteriores elementos
 */

def if_then_else(pred: Boolean)(tp: => Unit)(ep: => Unit):Unit = if (pred) tp else ep

val a = 20
if_then_else(a > 10) {
  println("This is then part")
} {
  println("This is else part")
}

val b = 10
if_then_else(b != 10)  {
  println("This is then part")
} {
  println("This is else part")
}

