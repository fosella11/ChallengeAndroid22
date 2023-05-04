# DATA
### SOLID:
S: El principio de responsabilidad única (Single Responsibility Principle, en inglés) dice que 
cada clase o función debe tener una sola responsabilidad. Esto significa que si estás escribiendo 
una clase para manejar la lógica de negocio de tu aplicación, no debería también ser responsable 
de manejar la entrada y salida de datos.

O: El principio de abierto/cerrado (Open/Closed Principle, en inglés) dice que una clase debe 
estar abierta para extensiones pero cerrada para modificaciones. Esto significa que si necesitas 
agregar una nueva funcionalidad a tu aplicación, debes hacerlo agregando nuevas clases o funciones 
en lugar de modificar las existentes.

L: El principio de sustitución de Liskov (Liskov Substitution Principle, en inglés) dice que una 
instancia de una clase debe ser reemplazable por cualquier subclase de esa clase sin 
afectar la corrección del programa. Esto significa que si tienes una clase que se espera 
que tenga ciertas propiedades o comportamientos, cualquier subclase de esa clase también 
debe tener esas mismas propiedades o comportamientos.

I: El principio de segregación de interfaces (Interface Segregation Principle, en inglés) dice 
que una clase no debe ser forzada a implementar interfaces que no necesita. Esto significa que 
si tienes una clase que solo necesita implementar algunas de las funcionalidades de una interfaz, 
deberías dividir esa interfaz en interfaces más pequeñas y específicas.

D: El principio de inversión de dependencia (Dependency Inversion Principle, en inglés) dice 
que los módulos de alto nivel no deben depender de los módulos de bajo nivel. En su lugar, 
ambos deberían depender de abstracciones. Esto significa que si tienes una clase que depende 
de otra clase, deberías hacer que la primera dependa de una interfaz en lugar de la segunda 
clase concreta.




### MVVM significa Modelo-Vista-ViewModel (Model-View-ViewModel, en inglés)
Es una arquitectura de software que se utiliza comúnmente para desarrollar aplicaciones de Android.
En la arquitectura MVVM, el Modelo representa los datos y la lógica de negocio de la aplicación, 
la Vista es la interfaz de usuario y el ViewModel es un intermediario que se encarga de comunicar 
la Vista con el Modelo.

#### Cada uno de ellos en detalle:

Modelo: El Modelo es la capa de la aplicación que se encarga de manejar los datos y la lógica de 
negocio. Esto puede incluir la obtención de datos desde una base de datos, una API o cualquier 
otra fuente de datos, y procesarlos según las reglas de negocio de la aplicación.

Vista: La Vista es la capa de la aplicación que se encarga de mostrar la información al usuario 
y recibir las interacciones del usuario. En Android, esto puede ser una actividad, un fragmento, 
una vista personalizada, etc.

ViewModel: El ViewModel es el intermediario entre la Vista y el Modelo. Se encarga de exponer los 
datos y la lógica de negocio del Modelo a la Vista en un formato que la Vista pueda entender. 
Además, también maneja las interacciones del usuario y realiza las acciones correspondientes 
en el Modelo.

En MVVM, la comunicación entre la Vista y el ViewModel se realiza a través de un patrón llamado 
"enlace de datos" (data binding, en inglés), que permite que los cambios en los datos del 
ViewModel se reflejen automáticamente en la Vista y viceversa, sin necesidad de escribir 
código adicional.
En resumen, MVVM es una arquitectura de software que separa claramente las responsabilidades 
de la aplicación en tres capas diferentes: Modelo, Vista y ViewModel. Esto permite una mejor 
organización del código y una mayor facilidad para mantener y ampliar la aplicación en el futuro.

### Algunas preguntas que se pueden hacer sobre la arquitectura MVVM:

¿Qué significa MVVM y cuáles son sus principales componentes?

¿Por qué se utiliza MVVM en el desarrollo de aplicaciones de Android?

¿Cuál es la ventaja de utilizar enlace de datos en MVVM?

¿Cómo se comunica la Vista con el ViewModel en MVVM?

¿Qué ventajas tiene la separación de responsabilidades en MVVM?

¿Qué desventajas tiene MVVM en comparación con otras arquitecturas de software?

¿Cómo se implementa MVVM en una aplicación de Android?

¿Cómo se realiza la prueba de una aplicación desarrollada con MVVM?

¿Qué bibliotecas y herramientas se pueden utilizar para desarrollar aplicaciones 
con MVVM en Android?

¿Cómo se pueden solucionar problemas comunes en la implementación de MVVM en una 
aplicación de Android?






### RESPUESTAS




ES

Claro, aquí tienes las respuestas a las preguntas sobre MVVM:

MVVM significa Modelo-Vista-ViewModel y sus principales componentes son el Modelo, la Vista 
y el ViewModel.

MVVM se utiliza en el desarrollo de aplicaciones de Android porque permite separar las 
responsabilidades de la aplicación de manera clara y eficiente, lo que hace que el código 
sea más fácil de mantener y escalar.

La principal ventaja del enlace de datos en MVVM es que permite que los cambios en el ViewModel 
se reflejen automáticamente en la Vista, lo que reduce la cantidad de código que se necesita 
escribir para mantener la sincronización de los datos.

La Vista se comunica con el ViewModel a través del enlace de datos y los comandos, que son métodos 
que se definen en el ViewModel y que se ejecutan en respuesta a las interacciones del usuario.

La separación de responsabilidades en MVVM tiene varias ventajas, como la reducción de la 
complejidad del código, la facilidad para realizar pruebas y la capacidad para reutilizar 
el código en diferentes partes de la aplicación.

Una de las desventajas de MVVM es que puede requerir una mayor cantidad de código en comparación 
con otras arquitecturas, ya que se debe escribir código adicional para conectar la Vista 
y el ViewModel.

MVVM se implementa en una aplicación de Android definiendo el Modelo, la Vista y el ViewModel 
como clases separadas, y utilizando enlace de datos y comandos para conectar la Vista 
y el ViewModel.

Para realizar la prueba de una aplicación desarrollada con MVVM, se puede utilizar un 
marco de pruebas unitarias como JUnit y un marco de pruebas de UI como Espresso.

Algunas bibliotecas y herramientas que se pueden utilizar para desarrollar aplicaciones con MVVM 
en Android son LiveData, ViewModel, Data Binding y Room.

Algunos problemas comunes en la implementación de MVVM en una aplicación de Android son la falta 
de entendimiento de cómo se comunican la Vista y el ViewModel, el exceso de complejidad en el 
código y la falta de separación de responsabilidades. Estos problemas se pueden solucionar 
utilizando una buena arquitectura de software, haciendo uso de patrones de diseño y siguiendo 
las mejores prácticas de programación en Android.


## What is functional programming with Arrow?

ES

Arrow es una biblioteca de Kotlin que proporciona herramientas para implementar programación 
funcional en código. La programación funcional es un paradigma de programación 
que se centra en componer funciones puras para crear programas.

En programación funcional, una función se considera pura si devuelve el mismo 
resultado dado el mismo conjunto de entradas, sin efectos secundarios en el 
estado del programa o en el mundo exterior. Además, las funciones puras son 
componibles, lo que significa que se pueden combinar para formar funciones más grandes.

Arrow ofrece varias herramientas para ayudar a implementar programación funcional en Kotlin, como:

Tipos de datos inmutables: Arrow proporciona tipos de datos inmutables, 
como Option, Either, Try, Validated, IO, Task, entre otros, que se utilizan para trabajar 
con valores que pueden o no estar presentes, o para representar resultados exitosos o errores.

Funciones de orden superior: Arrow proporciona funciones de orden superior como 
map, flatMap, fold, reduce, entre otras, que permiten trabajar con estructuras de 
datos inmutables y componer funciones de manera más fácil y eficiente.

Efectos secundarios controlados: Arrow proporciona tipos de datos que permiten 
controlar los efectos secundarios, como IO, Task, entre otros, que permiten manejar 
operaciones que realizan acciones en el mundo exterior de manera segura y controlada.

Validación de datos: Arrow proporciona herramientas para validar datos y hacer que las 
validaciones sean más explícitas y declarativas.

Procesamiento paralelo: Arrow proporciona herramientas para manejar el procesamiento paralelo,
como parMap, parTraverse, sequence, entre otros, que permiten mejorar el rendimiento en 
aplicaciones que manejan grandes cantidades de datos.

EN

Arrow is a Kotlin library that provides tools for implementing functional programming in code.
Functional programming is a programming paradigm that focuses on composing pure
functions to create programs.

In functional programming, a function is considered pure if it returns the same result
given the same set of inputs, without side effects on the program state or the outside world.
Furthermore, pure functions are composable, meaning that they can be combined to form
larger functions.

Arrow offers several tools to help implement functional programming in Kotlin, such as:

- Immutable data types: Arrow provides immutable data types, such as
  `Option`, `Either`, `Try`, `Validated`, `IO`, `Task`, among others,
  that are used to work with values that may or may not be present, or to
  represent successful results or errors.
- Higher-order functions: Arrow provides higher-order functions such as
  `map`, `flatMap`, `fold`, `reduce`, among others, that allow working with immutable data
  structures and composing functions more easily and efficiently.
- Controlled side effects: Arrow provides data types that allow controlling side effects,
  such as `IO`, `Task`, among others, that allow handling operations that perform actions
  in the outside world in a safe and controlled way.
- Data validation: Arrow provides tools for validating data and making validations more
  explicit and declarative.
- Parallel processing: Arrow provides tools for handling parallel processing, such as
  `parMap`, `parTraverse`, `sequence`, among others, that allow improving performance in
  applications that handle large amounts of data.
 
## Either example

ES

"Either es un tipo de dato utilizado en programación funcional que representa un valor que 
puede ser uno de dos posibles tipos: un resultado exitoso o un resultado fallido. 

A menudo se utiliza para representar el resultado de un cálculo que puede fallar.

En Kotlin, el tipo Either es proporcionado por la biblioteca Arrow. Un valor Either se puede 
crear utilizando las funciones Either.Left o Either.Right. La función Left crea un valor 
Either que representa un fallo, mientras que la función Right crea un valor Either que 
representa un resultado exitoso.

Por ejemplo, así es como se crea un valor Either que representa un resultado exitoso o fallido:

EN 

`Either` is a data type used in functional programming that represents a value that can be one of 
two possible types: a successful result or a failure result. It is often used to represent the 
result of a computation that may fail.

In Kotlin, the `Either` type is provided by the Arrow library. An `Either` value can be created 
using the `Either.Left` or `Either.Right` functions. The `Left` function creates an `Either` value 
that represents a failure, while the `Right` function creates an `Either` value that represents 
a successful result.

For example, here's how to create an `Either` value that represents either a 
successful result or a failure:

```kotlin
fun divide(a: Int, b: Int): Either<String, Int> {
    return if (b == 0) {
        Either.Left("Cannot divide by zero")
    } else {
        Either.Right(a / b)
    }
}
```


### Class data/di/DataModule.kt explanation

ES

Este código es un ejemplo de cómo utilizar Dagger Hilt, una biblioteca de inyección de 
dependencias para Android, para proveer instancias de objetos necesarios en una aplicación. 

El objetivo de Dagger Hilt es reducir la cantidad de código necesario para proveer dependencias y 
manejar la estructura de la aplicación.

El código define dos módulos, DataModule y RepositoryModule, ambos anotados con @Module y 
@InstallIn(SingletonComponent::class). La anotación @InstallIn indica en qué componente de 
Hilt deben instalarse los módulos, en este caso el SingletonComponent, que es un componente 
predefinido por Hilt que proporciona instancias únicas de objetos a lo largo de toda la aplicación.

Dentro de DataModule, se definen cuatro métodos anotados con @Provides, que indican a Hilt 
cómo proveer instancias de los objetos necesarios. El método provideLoggingInterceptor() 
provee una instancia de Interceptor para loguear las llamadas a una API. El método provideHttpClient() 
provee una instancia de OkHttpClient con el Interceptor anteriormente proporcionado. 

El método provideRetrofit() provee una instancia de Retrofit para interactuar con una API remota, 
utilizando el OkHttpClient previamente proporcionado. Y finalmente, el método provideEndPoint() 
provee una instancia de la interfaz ApiEndPoint, que es una interfaz definida en otro archivo 
de código, que define los endpoints de la API a consumir.

En RepositoryModule, se define una clase abstracta RepositoryModule anotada con @Binds y 
@Singleton, que indica que la clase Repository implementa la interfaz IRepository y que 
debe ser una instancia única en la aplicación. En lugar de usar un método @Provides, 
se usa el método @Binds para indicar que Dagger Hilt debe proporcionar una instancia de 
la implementación de IRepository.

Estos módulos se utilizan en otros lugares de la aplicación para obtener instancias de 
los objetos proporcionados. Por ejemplo, en una clase que necesita la instancia de la 
interfaz ApiEndPoint, se puede usar la anotación @Inject para obtener una instancia de 
la clase ApiEndPoint proporcionada por DataModule.

EN

This code is an example of how to use Dagger Hilt, a dependency injection library for Android, 
to provide instances of necessary objects in an application. The goal of Dagger Hilt is to reduce 
the amount of code necessary to provide dependencies and manage application structure.

The code defines two modules, DataModule and RepositoryModule, both annotated with @Module and 
@InstallIn(SingletonComponent::class). The @InstallIn annotation indicates which Hilt component 
the modules should be installed in, in this case the SingletonComponent, which is a pre-defined 
component by Hilt that provides unique object instances throughout the application.

Within DataModule, four methods annotated with @Provides are defined, which indicate to Hilt how 
to provide instances of necessary objects. The provideLoggingInterceptor() method provides an 
instance of Interceptor for logging API calls. 

The provideHttpClient() method provides an instance of OkHttpClient with the previously 
provided Interceptor. The provideRetrofit() method provides 
an instance of Retrofit for interacting with a remote API, using the previously provided 
OkHttpClient. And finally, the provideEndPoint() method provides an instance 
of the ApiEndPoint interface, which is an interface defined in another code file, 
defining the API endpoints to consume.

In RepositoryModule, an abstract class RepositoryModule is defined, 
annotated with @Binds and @Singleton, indicating that the Repository class implements 
the IRepository interface and should be a unique instance in the application. 
Instead of using a @Provides method, the @Binds method is used to indicate that 
Dagger Hilt should provide an instance of the implementation of IRepository.

These modules are used elsewhere in the application to obtain instances of provided 
objects. 
For example, in a class that needs an instance of the ApiEndPoint interface, 
the @Inject annotation can be used to obtain an instance of the ApiEndPoint class 
provided by DataModule.


## higher-order functions KOTLIN

let: ejecuta un bloque de código en el contexto de un objeto y devuelve el resultado del bloque.

run: ejecuta un bloque de código en el contexto de un objeto y devuelve el resultado del bloque.

also: ejecuta un bloque de código en el contexto de un objeto y devuelve el objeto original.

apply: ejecuta un bloque de código en el contexto de un objeto y devuelve el objeto modificado.

with: ejecuta un bloque de código en el contexto de un objeto y devuelve el resultado del bloque.

forEach: itera sobre una colección de objetos y ejecuta un bloque de código para cada elemento.

map: itera sobre una colección de objetos y devuelve una nueva colección con los resultados 
de ejecutar un bloque de código en cada elemento.

filter: itera sobre una colección de objetos y devuelve una nueva colección con los elementos 
que cumplen una condición dada por un bloque de código.

reduce: itera sobre una colección de objetos y devuelve un único resultado que se obtiene al 
combinar todos los elementos con una operación dada por un bloque de código.

fold: itera sobre una colección de objetos y devuelve un único resultado que se obtiene al 
combinar todos los elementos con una operación dada por un bloque de código, y que también 
toma un valor inicial.

### En Kotlin, también existen las siguientes funciones de orden superior que son similares a run, also y let:

- apply: Ejecuta un bloque de código en un objeto y devuelve el mismo objeto. Es similar a 
run pero en lugar de devolver el resultado del bloque, devuelve el objeto original.

- with: Ejecuta un bloque de código en un objeto sin necesidad de llamar a una función de 
extensión. Es similar a run, pero el objeto se especifica como un argumento en lugar de 
como receptor.

- use: Permite usar un recurso y asegurarse de que se cierre o libere adecuadamente 
después de su uso. Es comúnmente usado con try-with-resources en Java.

- forEach: Itera sobre una colección y ejecuta un bloque de código en cada elemento. 
Es similar a un bucle for-each en Java.


EN

let: executes a code block in the context of an object and returns the result of the block.

run: executes a code block in the context of an object and returns the result of the block.

also: executes a code block in the context of an object and returns the original object.

apply: executes a code block in the context of an object and returns the modified object.

with: executes a code block in the context of an object and returns the result of the block.

forEach: iterates over a collection of objects and executes a code block for each element.

map: iterates over a collection of objects and returns a new collection with the results 
of executing a code block on each element.

filter: iterates over a collection of objects and returns a new collection with the elements 
that satisfy a condition given by a code block.

reduce: iterates over a collection of objects and returns a single result obtained by combining 
all elements with an operation given by a code block.

fold: iterates over a collection of objects and returns a single result obtained by combining 
all elements with an operation given by a code block, and also takes an initial value.

### In Kotlin, there are also the following higher-order functions that are similar to run, also, and let:

apply: Executes a block of code on an object and returns the same object. It's similar to run 
but instead of returning the result of the block, it returns the original object.

with: Executes a block of code on an object without the need to call an extension function. 
It's similar to run, but the object is specified as an argument instead of a receiver.

use: Allows using a resource and ensures it's properly closed or released after its use. 
It's commonly used with try-with-resources in Java.

forEach: Iterates over a collection and executes a block of code on each element. 
It's similar to a for-each loop in Java.


## Ejemplos 

```kotlin
// let: ejecuta un bloque de código en el contexto de un objeto y devuelve el resultado del bloque.
val text: String? = "Hello World"
val resultLet = text?.let {
"Length of string is ${it.length}"
}

// run: ejecuta un bloque de código en el contexto de un objeto y devuelve el resultado del bloque.
val resultRun = text?.run {
"Length of string is ${this.length}"
}

// also: ejecuta un bloque de código en el contexto de un objeto y devuelve el objeto original.
val resultAlso = text?.also {
println("Length of string is ${it.length}")
}

// apply: ejecuta un bloque de código en el contexto de un objeto y devuelve el objeto modificado.
val stringBuilder = StringBuilder().apply {
append("Kotlin")
append(" is")
append(" awesome!")
}
val resultApply = stringBuilder.toString()

// with: ejecuta un bloque de código en el contexto de un objeto y devuelve el resultado del bloque.
val resultWith = with(stringBuilder) {
append(" It's true!")
toString()
}

// forEach: itera sobre una colección de objetos y ejecuta un bloque de código para cada elemento.
val fruits = listOf("Apple", "Banana", "Cherry")
fruits.forEach {
println(it)
}

// map: itera sobre una colección de objetos y devuelve una nueva colección con los 
// resultados de ejecutar un bloque de código en cada elemento.
val fruitLengths = fruits.map {
it.length
}

// filter: itera sobre una colección de objetos y devuelve una nueva colección con los elementos 
// que cumplen una condición dada por un bloque de código.
val longFruits = fruits.filter {
it.length > 5
}

// reduce: itera sobre una colección de objetos y devuelve un único resultado que se obtiene al 
// combinar todos los elementos con una operación dada por un bloque de código.
val numbers = listOf(1, 2, 3, 4, 5)
val sum = numbers.reduce { acc, n ->
acc + n
}

// fold: itera sobre una colección de objetos y devuelve un único resultado que se obtiene al 
// combinar todos los elementos con una operación dada por un bloque de código, y que también 
// toma un valor inicial.
val product = numbers.fold(1) { acc, n ->
acc * n
}
```

### MAS SOBRE -> let | run | also | apply | with
```kotlin


// let: La función let se utiliza para ejecutar un bloque de código en el contexto de un objeto 
// y devolver el resultado de ese bloque. Por lo general, se utiliza para procesar o transformar 
// un objeto de alguna manera. El objeto se especifica antes de la llamada a la función let y se 
// referencia dentro del bloque de código utilizando la palabra clave "it". 
// 
// Ejemplo de uso:

val nombre: String? = "Juan"
val resultado = nombre?.let {
 "Hola, $it"
} ?: "Nombre no disponible"
println(resultado)
// Output: "Hola, Juan"


//run: La función run es similar a let, pero en lugar de devolver el resultado del bloque de 
// código, devuelve el objeto en sí mismo. Es útil para realizar varias operaciones en un 
// objeto sin tener que llamar varias veces al objeto en sí mismo. 
//
// Ejemplo de uso

val lista = mutableListOf(1, 2, 3)
val resultado = lista.run {
 add(4)
 remove(1)
 this
}
println(resultado)
// Output: [2, 3, 4]


//also: La función also se utiliza para ejecutar un bloque de código en el contexto de un objeto 
// y luego devolver el objeto original. Es útil cuando se quiere hacer algo con un objeto, como 
// imprimirlo o registrar una acción, pero no se desea modificar el objeto en sí. 
//
// Ejemplo de uso

val lista = mutableListOf(1, 2, 3)
val resultado = lista.also {
 println("Lista original: $it")
 it.add(4)
 it.remove(1)
}
println(resultado)
// Output:
// Lista original: [1, 2, 3]
// [2, 3, 4]


//apply: La función apply se utiliza para ejecutar un bloque de código en el contexto de un objeto 
// y devolver el mismo objeto. Es similar a run, pero en lugar de devolver el resultado del bloque, 
// devuelve el objeto original. Es útil cuando se quiere configurar o inicializar un objeto. 
// 
// Ejemplo de uso:

val persona = Persona().apply {
 nombre = "Juan"
 edad = 30
}
println(persona)
// Output: Persona(nombre=Juan, edad=30)


//with: La función with se utiliza para ejecutar un bloque de código en el contexto de un objeto
// sin tener que llamar a una función de extensión. Es similar a run, pero el objeto se especifica
// como un argumento en lugar de como receptor. Es útil cuando se quiere realizar varias 
// operaciones en un objeto sin tener que llamar varias veces al objeto en sí mismo. 
// 
// Ejemplo de uso:


val lista = mutableListOf(1, 2, 3)
val resultado = with(lista) {
 add(4)
 remove(1)
 this
}
println(resultado)
// Output: [2, 3, 4]

```


Either y Nel son tipos de datos que forman parte de la biblioteca Arrow de Kotlin, que es 
una biblioteca de programación funcional para Kotlin.

Either es un tipo de datos que representa un valor que puede ser de dos tipos diferentes, 
a menudo utilizado para modelar el resultado de una operación que puede tener éxito o fallar. 
El valor Either puede ser Either.Left o Either.Right, donde Left representa el valor de error 
y Right representa el valor correcto.

Nel es un tipo de datos que representa una lista no vacía, lo que significa que siempre 
tendrá al menos un elemento. Es una alternativa al tipo de datos List de Kotlin, que puede ser 
vacía. Al utilizar una lista no vacía, se puede garantizar que siempre haya al menos un elemento 
en la lista, lo que puede simplificar el manejo de errores y la validación de datos.

Aquí te comparto una manera mnemotécnica para recordar qué es Either y qué es Nel:

- Either: piensa en la palabra "either" en inglés, que significa "cualquiera de los dos". 
- En programación, Either es un tipo de datos que puede contener cualquiera de dos posibles 
- valores: un resultado exitoso o un resultado de error.
- Nel: piensa en la abreviatura de "non-empty list" (lista no vacía). En programación, Nel 
- es un tipo de datos que representa una lista que no puede estar vacía. Esto significa que 
- siempre tiene al menos un elemento.

override fun getCharacterFilters(): Either<FilterError, Nel<GroupCharacterFilter>> {

nonEmptyListOf se utiliza para crear una lista no vacía en Kotlin. Una lista no vacía es 
una lista que siempre tiene al menos un elemento, lo que significa que nunca será nula y 
no se puede modificar para convertirse en una lista vacía.

El uso de una lista no vacía es útil porque permite garantizar que siempre haya al menos 
un elemento en la lista. Esto evita errores en tiempo de ejecución que pueden ocurrir al 
intentar acceder a un elemento inexistente en una lista vacía.

val gender = nonEmptyListOf(Gender.Female, Gender.Male, Gender.Genderless, Gender.Unknown)
val status = nonEmptyListOf(Status.Alive, Status.Dead, Status.Unknown)
return Either.Right(
nonEmptyListOf(
GroupCharacterFilter("Gender:", gender),
GroupCharacterFilter("Status:", status)
)
)

orNull() es una función proporcionada por la biblioteca Arrow de Kotlin que se puede 
llamar en una instancia de Option. Esta función devuelve el valor de la instancia Option 
si existe, o null si la instancia Option es una instancia None.

Option es un tipo de datos utilizado en programación funcional que representa un valor 
que puede o no existir. La idea detrás de Option es evitar el uso de valores nulos (null) 
en la programación, lo que puede llevar a errores y excepciones no controladas.

Por ejemplo, si tienes una instancia Option<String> que puede contener un valor String o 
no tener ninguno, puedes usar orNull() para obtener el valor como un String o null.



