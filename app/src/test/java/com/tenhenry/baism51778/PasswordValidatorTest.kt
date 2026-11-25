package com.tenhenry.baism51778

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {

    @Test
    fun strongPassword_isValid() {
        assertTrue(PasswordValidator.isValid("Haslo#2024"))
    }

    @Test
    fun tooShort_isInvalid() {
        assertFalse(PasswordValidator.isValid("Ha#1"))
    }

    @Test
    fun noDigit_isInvalid() {
        assertFalse(PasswordValidator.isValid("Haslo#abc"))
    }

    @Test
    fun noSpecialChar_isInvalid() {
        assertFalse(PasswordValidator.isValid("Haslo2024"))
    }

    @Test
    fun noUppercase_isInvalid() {
        assertFalse(PasswordValidator.isValid("haslo#2024"))
    }

    @Test
    fun minLength_exactly8_isOk() {
        assertTrue(PasswordValidator.hasMinLength("12345678"))
    }

    @Test
    fun emptyPassword_isInvalid() {
        assertFalse(PasswordValidator.isValid(""))
    }
}