package com.tenhenry.baism51778

object PasswordValidator {
    fun hasMinLength(p: String) = p.length >= 8
    fun hasUppercase(p: String) = p.any { it.isUpperCase() }
    fun hasLowercase(p: String) = p.any { it.isLowerCase() }
    fun hasDigit(p: String) = p.any { it.isDigit() }
    fun hasSpecialChar(p: String) = p.any { !it.isLetterOrDigit() }

    fun isValid(p: String): Boolean =
        hasMinLength(p) && hasUppercase(p) && hasLowercase(p) &&
                hasDigit(p) && hasSpecialChar(p)
}