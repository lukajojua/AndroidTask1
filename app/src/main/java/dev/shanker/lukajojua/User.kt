package dev.shanker.lukajojua

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val email: String,
    val password: String,
    val phoneNumber: String
) : Parcelable