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