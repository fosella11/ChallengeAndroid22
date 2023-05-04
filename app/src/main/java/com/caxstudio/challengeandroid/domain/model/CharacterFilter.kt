package com.caxstudio.challengeandroid.domain.model

// Interface for filtering characters
interface CharacterFilter {
    val value: String // Value of the filter
}

// Sealed class for character status filter
sealed class Status(override val value: String) : CharacterFilter {
    object Alive : Status(ALIVE) // Alive status
    object Dead : Status(DEAD) // Dead status
    object Unknown : Status(UNKNOWN) // Unknown status

    companion object {
        const val ALIVE = "Alive"
        const val DEAD = "Dead"
        const val UNKNOWN = "Unknown"

        // Returns the Status based on the status string
        fun getStatus(status: String): Status {
            return when (status) {
                ALIVE -> Alive
                DEAD -> Dead
                UNKNOWN -> Unknown
                else -> Unknown
            }
        }
    }
}

// Sealed class for character gender filter
sealed class Gender private constructor(override val value: String) : CharacterFilter {
    object Female : Gender(FEMALE) // Female gender
    object Male : Gender(MALE) // Male gender
    object Genderless : Gender(GENDERLESS) // Genderless
    object Unknown : Gender(UNKNOWN) // Unknown gender

    companion object {
        private const val FEMALE = "Female"
        private const val MALE = "Male"
        private const val GENDERLESS = "Genderless"
        private const val UNKNOWN = "Unknown"

        // Returns the Gender based on the gender string
        fun getGender(gender: String): Gender {
            return when (gender) {
                FEMALE -> Female
                MALE -> Male
                GENDERLESS -> Genderless
                UNKNOWN -> Unknown
                else -> Unknown
            }
        }
    }

}