package com.example.core.util


import android.util.Log
import java.time.DateTimeException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

private const val TAG = "DateTimeProvider"

interface DateTimeProvider {

    fun now(): LocalDate

    fun parseDate(date: String, pattern: DateTimePattern): LocalDate?

    fun formatDate(date: LocalDate, pattern: DateTimePattern): String?

    fun parseDateTime(dateTime: String, pattern: DateTimePattern): LocalDateTime?

    fun formatDateTime(dateTime: LocalDateTime, pattern: DateTimePattern): String?

}


enum class DateTimePattern(val value: String) {
    DD_MMM_YYYY("dd MMM yyyy")
}

class DateTimeProviderImp() : DateTimeProvider {
    override fun now(): LocalDate {
        return LocalDate.now()
    }

    override fun parseDate(date: String, pattern: DateTimePattern): LocalDate? {
        return try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern.value))
        } catch (e: DateTimeParseException) {
            Log.e(TAG, "parseDate: failed to parse date $date")
            null
        }
    }

    override fun formatDate(date: LocalDate, pattern: DateTimePattern): String? {
        return try {
            date.format(DateTimeFormatter.ofPattern(pattern.value))
        } catch (e: DateTimeException) {
            Log.e(TAG, "parseDate: failed to format date $date")
            null
        }

    }

    override fun parseDateTime(dateTime: String, pattern: DateTimePattern): LocalDateTime? {
        return try {
            LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(pattern.value))
        } catch (e: DateTimeParseException) {
            Log.e(TAG, "parseDateTime: failed to parse dateTime $dateTime")
            null
        }
    }

    override fun formatDateTime(dateTime: LocalDateTime, pattern: DateTimePattern): String? {
        return try {
            dateTime.format(DateTimeFormatter.ofPattern(pattern.value))
        } catch (e: DateTimeException) {
            Log.e(TAG, "formatDateTime: failed to format dateTime $dateTime")
            null
        }
    }
}
