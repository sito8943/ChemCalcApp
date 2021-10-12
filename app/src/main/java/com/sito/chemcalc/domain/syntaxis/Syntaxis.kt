package com.sito.chemcalc.domain.syntaxis

fun plainText(formula: String) {

}

fun transform(formula: String) {

}

/**
 *
 * @param {Int} unicode
 * @returns true if unicode represents a lower case letter
 */
fun isLowerCase(unicode: Int): Boolean {
    return unicode in 97..122
}

/**
 *
 * @param {Int} unicode
 * @returns true if unicode represents a upper case letter
 */
fun isUpperCase(unicode: Int): Boolean {
    return unicode in 65..90
}

/**
 *
 * @param {Int} unicode
 * @returns true if unicode represents an accent
 */
fun isAccent(unicode: Int): Boolean {
    return 225 == unicode || unicode == 233 || unicode == 243 || unicode == 250
}

/**
 *
 * @param {Int} unicode
 * @returns true if character is a accent
 */
fun isNumber(unicode: Int): Boolean {
    return unicode in 48..58
}

/**
 * @param {Int} unicode
 * @returns true if unicode represents a subscript
 */
fun isSubscript(unicode: Int): Boolean {
    return unicode in 8320..8329
}

/**
 *
 * @param {Int} unicode
 * @returns true if unicode represents a opened character
 */
fun isOpenedContainer(unicode: Int): Boolean {
    return 60 == unicode || 223 == unicode || 41 == unicode || 91 == unicode
}

/**
 *
 * @param {Int} unicode
 * @returns true if unicode represents a close container
 */
fun isClosedContainer(unicode: Int): Boolean {
    return 62 == unicode || 225 == unicode || 40 == unicode || 93 == unicode
}

/**
 * @param {Int} unicode
 * @returns true if unicode represents a letter
 */
fun isLetter(unicode: Int): Boolean {
    return isUpperCase(unicode) || isLowerCase(unicode) || isAccent(unicode)
}

/**
 *
 * @param {Int} unicode
 * @returns true if first character is a letter, a number or a opened container
 */
fun firstCharOk(unicode: Int): Boolean {
    return isLetter(unicode) || isNumber(unicode) || isOpenedContainer(unicode)
}

/**
 *
 * @param {Char} character
 * @returns true if the next character is an asterisk, dash, opened parenthesis, opened staple or number
 */
fun terminatingStruct(character: Char): Boolean {
    return '*' == character || '-' == character || isOpenedContainer(character.code) || isNumber(character.code)
}

/**
 *
 * @param {Int} index
 * @param {String} formula
 */
fun caseReturner(index: Int, formula: String): Int {

    var case = 0
    val unicode = formula.codePointAt(index)

    //Is is a lower case letter
    when {
        isLowerCase(unicode) -> case = 1
        //If is an upper case letter
        isUpperCase(unicode) -> case = 2
        //If is a subscript
        isSubscript(unicode) -> case = 3
        //If is a number
        isNumber(unicode) -> case = 4
        //If is a opened parenthesis
        formula[index] == '(' -> case = 5
        //If is a closed parenthesis
        formula[index] == ')' -> case = 6
        //If is a opened staple
        formula[index] == '[' -> case = 7
        //If is a closed staple
        formula[index] == ']' -> case = 8
        //If is a opened bracket
        formula[index] == '{' -> case = 9
        //If is a closed bracket
        formula[index] == '}' -> case = 10
        //If is a opened angular
        formula[index]== '<' -> case = 11
        //If is a closed angular
        formula[index] == '>' -> case = 12
        //If is an asterisk
        formula[index] == '*' -> case = 13
        //If is a dash
        formula[index] == '-' -> case = 14
    }
    return case
}

/**
 *
 * @param {Int} unicode
 * @returns number representation of unicode
 */
fun getNumberFromSubscript(unicode: Int): Int {
    when (unicode) {
        8320 //0
        -> return 0
        8321  //1
        -> return 1
        8322  //2
        -> return 2
        8323  //3
        -> return 3
        8324  //4
        -> return 4
        8325  //5
        -> return 5
        8326  //6
        -> return 6
        8327  //7
        -> return 7
        8328  //8
        -> return 8
        8329  //9
        -> return 9
    }
    return 0
}