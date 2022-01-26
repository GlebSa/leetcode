import kotlin.math.min

fun longestPalindrome(s: String): String {
    if (s.length < 2) {
        return s
    }

    var maxPalindrome = ""
    for (i in 0..s.length - 2) {
        maxPalindrome = maxOf(maxPalindrome, getPalindrome(s, i, i + 1), getPalindrome(s, i, i + 2), compareBy { it.length })
    }

    return maxPalindrome
}

fun getPalindrome(s: String, left: Int, right: Int): String {
    val limit = min(left, s.length - right - 1)
    var l = -1
    var r = -1
    for (i in 0..limit) {
        if (s[left - i] == s[right + i]) {
            l = left - i
            r = right + i
        } else {
            break
        }
    }
    if (l > -1 && r > -1) {
        return s.substring(l, r + 1)
    } else {
        return s[left].toString()
    }
}