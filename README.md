# ChallengeAndroid22

## Construir una app Android que cumpla con los siguientes requisitos:

### Tener una pantalla con un listado de ítems

La información del listado se debe obtener desde algún servicio en cloud
(por ejemplo: https://rickandmortyapi.com/).

### Tener una pantalla con el detalle del ítem

Cuando se selecciona un item desde el listado, entra a la pantalla del detalle.

### Opcional: integrar Firebase

Integrar con 1 o más de sus herramientas (ejemplo: Authentication, Firestore, etc.).

### Subir codigo a un Repositorio

La app se debe subir a algún repositorio para que los desarrolladores de Betterfly
puedan ver el código (y compilarlo si quieren).

## API

[Rickandmortyapi Document](https://rickandmortyapi.com/documentation/#get-all-episodes)

[POSTMAN Project](https://www.postman.com/fosella/workspace/challenge-android)

```json lines
{
  "info": {
    "count": 51,
    "pages": 3,
    "next": "https://rickandmortyapi.com/api/episode?page=2",
    "prev": null
  },
  "results": [
    {
      "id": 1,
      "name": "Pilot",
      "air_date": "December 2, 2013",
      "episode": "S01E01",
      "characters": [
        "https://rickandmortyapi.com/api/character/1",
        "https://rickandmortyapi.com/api/character/2",
        //...
      ],
      "url": "https://rickandmortyapi.com/api/episode/1",
      "created": "2017-11-10T12:56:33.798Z"
    },
    // ...
  ]
}
```

[Conventions code](https://kotlinlang.org/docs/coding-conventions.html#documentation-comments) 

### Comments
Utilizado : MVVM, Dagger hilt, Coroutines, Retrofit, Google Play Services, Glide 
(Firebase, Firestore, Firebase-analytics).
Pruebas unitarias

Pendiente :
Modularizar
Agregar Paging library
Agregar Test de Instrumentacion
Completar la covertura de Tests
Mejorar Comentarios en el codigo

- Agregar 


## User to test 
 email: test@test.com
 password: test1234
 
## Either example

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

## What is functional programming with Arrow?

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


