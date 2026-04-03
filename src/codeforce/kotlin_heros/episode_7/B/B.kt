/**
 * 06/29/21 morning
 * https://codeforces.com/contest/1533/problem/B
 */

import java.util.*

// Accepted
fun solve(n: Int, a: List<Int>) {
    // pr("$n $a")
    for (i in 1 until n) {
        var diff = a[i] - a[i - 1]
        if (diff % 2 == 0) {
            return pr("YES")
        }
    }
    pr("NO")
}

fun main() {
    var t = ni()
    while (t-- > 0) {
        var n = ni()
        var a = nai()
        solve(n, a)
    }
}

private fun line() = readLine()!!
private fun ni() = line().toInt()
private fun nl() = line().toLong()
private fun nd() = line().toDouble()
private fun nas() = line().split(" ")
private fun nai() = nas().map { it.toInt() }
private fun nal() = nas().map { it.toLong() }
private fun nad() = nas().map { it.toDouble() }
private fun prt(e: Any) = print(e)
private fun pr(e: Any) = println(e)
private fun tr(e: IntArray) = println(Arrays.toString(e))
private fun tr(e: LongArray) = println(Arrays.toString(e))
private fun tr(e: DoubleArray) = println(Arrays.toString(e))
private fun tr(e: BooleanArray) = println(Arrays.toString(e))
private fun tr(e: CharArray) = println(Arrays.toString(e))
private fun tr(e: Array<String>) = println(Arrays.toString(e))