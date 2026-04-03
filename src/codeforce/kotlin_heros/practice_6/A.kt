/**
 * 03/25/21 night
 * https://codeforces.com/contest/1489/problem/A
 */

package codeforce.kotlin_heros.practice_6

fun solve(n: Int, a: List<Int>) {
    var se = mutableSetOf<Int>()
    for (i in n - 1 downTo 0) {
        se.add(a[i])
    }
    var len = se.size
    var s = ""
    for (i in len - 1 downTo 0) {
        s += se.elementAt(i)
        if (i != 0) s += " "
    }
    pr(len)
    pr(s)
}

fun pr(e: Any) {
    println(e)
}

fun main() {
    var n = ni()
    var a = nai()
    solve(n, a)
}

private fun line() = readLine()!!
private fun ni() = line().toInt()
private fun nl() = line().toLong()
private fun nd() = line().toDouble()
private fun nas() = line().split(" ")
private fun nai() = nas().map { it.toInt() }
private fun nal() = nas().map { it.toLong() }
private fun nad() = nas().map { it.toDouble() }

