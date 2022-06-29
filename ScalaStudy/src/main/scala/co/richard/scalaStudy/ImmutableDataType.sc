/** Tuplas
 * Las tuplas te permitirán guardar información asociada con algunos
 * cambios muy interesantes: no tienen nombres asociados a cada campo.
 *
 * Las tuplas también puede ser utilizadas de forma dinámica, lo que significa
 * que no hay que hacer definiciones de tipo de la tupla, ya que la instanciación
 * de una tupla establece el número de sus elementos (aridad) y su correspondiente
 * tipo, cosa que no puedes asi con un registro o una clase.
 *
 * Las tuplas son inmutables, esta última característica es la que revisaremos con
 * más detalle en este curso en particular y observaremos las consecuencias directas
 * de utilizarlo a través de métodos de selección o coincidencia de patrones, la forma
 * de crearlo a partir del soporte que da el lenguaje o los objetos que nos permite otras
 * formas de creación.
 */

/** Transparencia referencial
 * Una expresion 'e' es transparentemente referencial, si para todos los
 * programas 'p', todas las ocurrencias de 'e' en 'p' pueden ser reemplazadas
 * por el resultado de evaluar 'e' sin afectar el significado 'p'.
 */

/** Funciones puras
 * Una funcion 'f' es pura si la expresion f(x) es transparentemente
 * referencial para todas las transparencias referenciales de 'x'.
 */

// Tuplas normalizadas

val t2e = (1,2.0)
val t3e = (1,(2.0,"Tres"))

// Tuplas objectuales

val t2o = new Tuple2[Int,Double](1,2.0)
val t3o = new Tuple3[Int,Double,String](1,2.0,"Tres")
val t4o = new Tuple4[Int,Double,String,Boolean](1,2.0,"Tres",true)
val t5o = new Tuple4[Int,Double,String,Tuple2[Boolean,Int]](1,2.0,"Tres",(true,4))

// Crear alias (se usa la palabra type)

type Tpl3Int = (Int,Int,Int)
def id2(a:Tpl3Int):Tpl3Int = a

/**
 * Las tuplas son inmutables, por ende, la unica manera de eliminarlas es
 * mediante el garbage colector. (Las tuplas no son colecciones)
 *
 * Al ser inmutables, no se pueden modificar, pero si podemos acceder a ellas
 */

// Acceso a tuplas

val tp3 = (1,"Dos",true)
tp3._1
tp3._2
tp3._3

def swap(a:(Int,Double)):(Double,Int) = (a._2,a._1)
swap(1,2.0)

type T3IID = (Int,Int,Double)
type T3IDI = (Int,Double,Int)

def aplicar(tpl1:T3IID,tpl2:T3IDI,f:(Int,Double) => Int):Int = f(tpl1._1,tpl2._2) + f(tpl2._3,tpl1._3)
aplicar((1,2,3.0),(1,3.0,2),(x:Int,_) => x * 2)

// Pattern matching (Coincidencia de patrones)
type T2ID = (Int,Double)
type T2DI = (Double,Int)
// Esta funcion corresponde al swap de tuplas binarias
def swap(tpl:T2ID):T2DI = tpl match {
  case (a,b) => (b,a)
}

/** Operador @
 * Sirve para mencionar el mismo elemento dentro del
 * pattern matching
 */

def obtTuplaBin(tpl:Tuple2[Any,Any]):(Any,Any) = tpl match {
  case (t @ (_,_),_) => t
  case (_,t @ (_,_)) => t
}

// Compuerta nand
def nand(b:(Boolean,Boolean)):Boolean = b match {
  case (true, true) => false
  case _            => true
}

// Compuerta nor
def nor(b:(Boolean,Boolean,Boolean)):Boolean = b match {
  case (false, false, false) => true
  case _                     => false
}

// Diferenciar tuplas
type Tp3 = (String,Int,Double)
type Tp2_3 = (Tp3,Tp3)

def obtExtr(u:Tp3,d:Tp3,t:Tp3):Tp2_3 =  if (u == d) (u,t)
else if (d == t) (u,t)
else if (u == t) (u,d)
else (u,d)

// Profundidad de un arbol binario
def profundidad(arbol:Any):Int = arbol match {
  case (l @ (_,_), r @ (_,_)) => 1 + math.max(profundidad(l),profundidad(r))
  case (l @ (_,_), _)         => 1 + profundidad(l)
  case (_, r @ (_,_))         => 1 + profundidad(r)
  case (_,_)                  => 1
  case _                      => 0
}

/** Manipulacion de tuplas
 * Al ser inmutables se debe crear una nueva tupla a partir de los valores
 * originales, entonces se pueden usar accediendo directamente a los valores
 * de la tupla (tp._1,..., tp._22) o mediante pattern matching
 */

val tpl = (4,5)
val tpl4 @ (x,y) = tpl match {
  case (a,b) => (a, b*2)
}
tpl4

// Copia de tuplas

tpl.copy()       // Copia directamente la tupla
tpl.copy(1)      // Copia la tupla pero cambia el primer valor
tpl.copy(_2 = 4) // Copia la tupla pero cambia el segundo valor

// Operador "->" Este operador sirve para crear tuplas

val a = 2 -> 5 // Genera una tupla (2,5)

// Tuplas como registros

type Notas = (Double,Double,Double)
type Estudiante = (String,Notas,Double)

def actualizarNotas(est:Estudiante,nroNota:Int,nuevaNota:Double):Estudiante = {
  def cambiarNota(notas:Notas):Notas = nroNota match {
    case 1 => notas.copy(_1 = nuevaNota)
    case 2 => notas.copy(_2 = nuevaNota)
    case 3 => notas.copy(_3 = nuevaNota)
  }
  def promNotas(n:Notas):Double = {
    (n._1 + n._2 + n._3) / 3
  }
  val nuevaNotas = cambiarNota(est._2)
  est.copy(_2 = nuevaNotas, _3 = promNotas(nuevaNotas))
}

val unEst = ("Un estudiante", (0.0,0.0,0.0), 0.0)
val nuevoUnEst = actualizarNotas(unEst,1,1.0)
val nuevo2UnEst = actualizarNotas(nuevoUnEst,2,2.0)
val nuevo3UnEst = actualizarNotas(nuevo2UnEst,3,3.0)

nuevo3UnEst._3 == 2.0

/** Tipos de datos algebraicos (Definiendo traits por sumas)
 * Al crear un hilo sellado, indicamos que todos los tipos de datos deben estar
 * definidos en el documento que se definio (Usualmente es un documento
 * separado de los demas donde se define con sus subtipos)
 */
sealed trait State

final case object On extends State
final case object Off extends State

val state:State = On
def conmutar(s:State):State = if (s == On) Off else On
conmutar(state)

/** Tipos de datos algebraicos (Definiendo traits por producto)
 * Una case class es una clase pero el compilador se encarga de cargar
 * metodos como .equals, .toString, etc. e inicia un constructor con los
 * parametros
 */

sealed trait Coord
final case class Punto2D(x:Double, y:Double) extends Coord

/** Tipo de dato algebraico (Definiendo traits por producto y suma)
 * Usa un case class que nos devuelve un resultado cuando sea posible
 * y un case object que retorna nada cuando no se puede realizar el calculo
 */

sealed trait Resultado

final case class RInt(int:Int) extends Resultado
final case object RNada extends Resultado

def division(a:Int,b:Int):Resultado = if (b == 0) RNada else RInt(a / b)

// Operaciones sobre tipos de datos algebraicos

def esCero(r:Resultado):Boolean = r match {
  case RInt(0) => true
  case _       => false
}

esCero(RInt(0))

val uno:Resultado = RInt(1)

def incr(r:Resultado):Resultado = r match {
  case RInt(i) => RInt(i+1)
  case RNada   => RNada
}

/** Otra manera de escribir incr
 * def incr(r:Resultado):Resultado = r match{
 *  case rp @ RInt(i) => rp.copy(int = i+1)
 *  case j            => j
 * }
 */

incr(RInt(1))

val ri:Resultado = RInt(10)
val rn:Resultado = RNada

division(4,2)

/** Jerarquia
 * Se denomina jerarquia si un tipo pertence a un tipo determinado debe tener
 * el comportamiento de las clases de las que depende de la parte alta de la
 * jerarquía. Este mecanismo, permite la sobercarga de operadores y que cuando
 * pertenece a una claseparticular, la instanciación permite la invocación del método correspondiente.
 */

/** Variante [+A], Covariante [-A] e invariante [A]
 * Cuando se trabaja con variables de tipos y en particular con la jerarquía
 * de clases que un sistema orientado a objetos como Scala, la pregunta que
 * debes estar haciéndote es que pasa con dicha jerarquía. Para hacerlo muy
 * simple (puesto que más adelante hablaremos con más detalle de estos temas),
 * si una Clase X tiene subclases a Y y Z, si tenemos algo genérico G[A] que
 * pasa con la relación anteriormente descrita, pues bueno, Scala tiene los
 * términos variante para indica que si creo una clase de G[X], la relación
 * de subclases se mantedrá con G[Y] y G[Z] definiendo a G[+A], donde el +
 * indica que la relación se mantendrá (variante). Si la relación se mantiene
 * como G[A] esta es llamada invariante, no importa relación alguna. Y, si el
 * valor es G[-A] este indica que el orden de la relación se cambia, si X es
 * una superclase de Y y Z, con G[-X] la relación se invierte y esta se
 * convierte en una subclase de G[Y] y como también de G[Z], esta se llama
 * covariante.
 */

// Tipo identidad (Ejercicio)

sealed trait ID[+A]

final case class IdE[+A](value:A) extends ID[A]

def getValue[A](id:ID[A]):A = id match {
  case IdE(a) => a
}

// Tipo resultado general (Ejercicio)

sealed trait Resultado[+A]

final case class Algun[+A](value:A) extends Resultado[A]
final case object Ningun extends Resultado[Nothing]

def dividir(a:Int,b:Int):Resultado[Int] = b match {
  case 0 => Ningun
  case n => Algun(a/n)
}

dividir(4,2)

// Un par de valores (Ejercicio)

sealed trait Par[+A]
final case class UnPar[+A](p:A, s:A) extends Par[A]

def swap[A](par:Par[A]):Par[A] = par match {
  case UnPar(p,s) => UnPar(s,p)
}

val unPar1:Par[Int] = UnPar(1,2)
val unPar2:Par[Int] = UnPar(2,1)
val unPar3:Par[Double] = UnPar(2.3,3.4)
val unPar4:Par[Double] = UnPar(3.4,2.3)

swap(unPar1) == unPar2
swap(unPar3) == unPar4