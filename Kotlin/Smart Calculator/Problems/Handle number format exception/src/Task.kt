fun parseCardNumber(cardNumber: String): Long {
    // TODO
    if (cardNumber.length != 19) throw Exception()
    for (i in cardNumber.indices) {
        when (i) {
            4, 9, 14 -> {
                if (cardNumber[i] != ' ') throw Exception()
            }
            else -> {
                if (!cardNumber[i].isDigit()) throw Exception()
            }
        }
    }
    var rtn = 0L
    for (token in cardNumber.split(" ")) {
        rtn = rtn * 10_000 + token.toLong()
    }
    return rtn
}