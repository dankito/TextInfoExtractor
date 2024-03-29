package net.dankito.text.extraction.info.model

import java.text.SimpleDateFormat
import java.util.*


open class DateData(val day: Int, val month: Int, val year: Int, val probableFourDigitYear: Int, val dateString: String, foundInLine: String) :
    SearchResult(foundInLine) {

    companion object {
        val DateFormatter = SimpleDateFormat("dd.MM.yyyy")
    }


    constructor(day: Int, month: Int, year: Int, dateString: String, foundInLine: String) : this(day, month, year, year, dateString, foundInLine)


    open fun toJavaUtilDate(): Date {
        return DateFormatter.parse(getDateAccordingToDateFormat())
    }

    protected open fun getDateAccordingToDateFormat() = "$day.$month.${ if (year < 1000) probableFourDigitYear else year }"



    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DateData) return false

        if (day != other.day) return false
        if (month != other.month) return false
        if (year != other.year) return false

        return true
    }

    override fun hashCode(): Int {
        var result = day
        result = 31 * result + month
        result = 31 * result + year
        return result
    }


    override fun toString(): String {
        return getDateAccordingToDateFormat()
    }

}