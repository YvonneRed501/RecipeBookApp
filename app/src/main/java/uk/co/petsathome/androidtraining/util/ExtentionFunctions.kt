package uk.co.petsathome.androidtraining.util


fun String.capitaliseFirstChar() : String = this.first().uppercase()

fun String.limitChar(maxLength: Int): String {
    return if (this.length > maxLength) {
        this.take(maxLength) + "..."
    }
    else this
}