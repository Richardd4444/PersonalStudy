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

// Funciones anonimas

