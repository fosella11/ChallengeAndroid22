package com.caxstudio.challengeandroid.data.repository

import android.content.SharedPreferences
import com.caxstudio.challengeandroid.data.ApiService
import com.caxstudio.challengeandroid.data.model.auth.User
import com.caxstudio.challengeandroid.utils.ConstantsApp
import com.caxstudio.challengeandroid.utils.UiProgress
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import javax.inject.Inject

class AuthRepositoryImp @Inject constructor(
    private val apiServiceDataSource: ApiService,
    private val auth: FirebaseAuth,
    private val database: FirebaseFirestore,
    private val appPreferences: SharedPreferences,
    private val gson: Gson
) : AuthRepository {

    override fun logout(result: () -> Unit) {
        auth.signOut()
        appPreferences.edit().putString(ConstantsApp.USER_SESSION, null).apply()
        result.invoke()
    }

    override fun loginUser(
        email: String,
        password: String,
        result: (UiProgress<String>) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    saveSession(id = task.result.user?.uid ?: "") { userSaved ->
                        if (userSaved != null) {
                            result.invoke(UiProgress.Success("Login OK"))
                        } else {
                            result.invoke(UiProgress.Failure("Fail login"))
                        }
                    }
                }
            }
            .addOnFailureListener {
                result.invoke(UiProgress.Failure("Error, check pass and email"))
            }
    }

    override fun saveSession(id: String, result: (User?) -> Unit) {
        database.collection(ConstantsApp.USER).document(id)
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val user = it.result.toObject(User::class.java)
                    appPreferences.edit().putString(ConstantsApp.USER_SESSION, gson.toJson(user))
                        .apply()
                    result.invoke(user)
                } else {
                    result.invoke(null)
                }
            }
            .addOnFailureListener {
                result.invoke(null)
            }
    }

    override fun getSession(result: (User?) -> Unit) {
        val userFromShared = appPreferences.getString(ConstantsApp.USER_SESSION, null)
        if (userFromShared == null) {
            result.invoke(null)
        } else {
            val user = gson.fromJson(userFromShared, User::class.java)
            result.invoke(user)
        }
    }

    override fun updateUserInfo(user: User, result: (UiProgress<String>) -> Unit) {
        val dataDocument = database.collection(ConstantsApp.USER).document(user.id)
        dataDocument
            .set(user)
            .addOnSuccessListener {
                result.invoke(
                    UiProgress.Success("Data updated - OK")
                )
            }
            .addOnFailureListener {
                result.invoke(
                    UiProgress.Failure("Error update")
                )
            }
    }

    override fun registerUser(
        email: String,
        password: String,
        user: User,
        result: (UiProgress<String>) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    user.id = it.result.user?.uid ?: ""
                    updateUserInfo(user) { progress ->
                        when (progress) {
                            is UiProgress.Success -> {
                                saveSession(id = it.result.user?.uid ?: "") { user ->
                                    if (user == null) {
                                        result.invoke(UiProgress.Failure("User register : OK - Session : Fail"))
                                    } else {
                                        result.invoke(UiProgress.Success("User register OK"))
                                    }
                                }
                            }
                            is UiProgress.Failure -> {
                                result.invoke(UiProgress.Failure("Error create an user"))
                            }
                            else -> {}
                        }
                    }
                } else {
                    try {
                        throw it.exception ?: java.lang.Exception("Invalid auth")
                    } catch (e: FirebaseAuthWeakPasswordException) {
                        result.invoke(UiProgress.Failure("La pass debe tener mas de 6 caractares"))
                    } catch (e: FirebaseAuthInvalidCredentialsException) {
                        result.invoke(UiProgress.Failure("El email no existe"))
                    } catch (e: FirebaseAuthUserCollisionException) {
                        result.invoke(UiProgress.Failure("Ya existe el email"))
                    } catch (e: Exception) {
                        result.invoke(UiProgress.Failure(e.message.toString()))
                    }
                }
            }

    }

}