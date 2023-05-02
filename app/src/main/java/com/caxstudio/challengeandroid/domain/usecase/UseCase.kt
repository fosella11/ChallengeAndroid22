package com.caxstudio.challengeandroid.domain.usecase

import arrow.core.Either
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// This is an abstract class defining a use case for a specific functionality
// Params: the input parameters required for the use case
// Response: the output response from the use case
// Error: the possible errors that can occur during the execution of the use case
abstract class UseCase<Params, Response, Error> {

    // This is the main function that will be implemented by each specific use case
    // It takes a Params object as input and returns an Either object with either an Error or a Response
    protected abstract suspend fun run(params: Params): Either<Error, Response>

    // This operator function takes in the Params object, a dispatcher (which defaults to IO), and a callback function onResult
    // It executes the run() function with the given params, and returns the Either object through the callback function
    // The execution of run() is done in the given dispatcher context
    suspend operator fun invoke(
        params: Params,
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        onResult: (Either<Error, Response>) -> Unit
    ) {
        withContext(dispatcher) {
            onResult(run(params))
        }
    }

    // This operator function takes in the Params object and executes the run() function with the given params
    // It is used when we just want to execute the use case without returning the result to a callback function
    suspend operator fun invoke(params: Params) = run(params)
}