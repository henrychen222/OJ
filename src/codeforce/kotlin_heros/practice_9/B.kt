/**
 * 02/22/22 noon
 * https://codeforces.com/contest/1645/problem/B
 */
package codeforce.kotlin_heros.practice_9;

import java.io.*
import java.util.*

// Accepted
fun solve(n: Int, s: String) {
    var res = ""
    var n = s.length
    var i = 0
    var t = 1
    while (i < n) {
        res += s[i]
        t++
        i += t
    }
    pr(res)
}

val bpw = PrintWriter(System.out)
fun main() {
    var n = ni();
    var s = line()
    solve(n, s)
    bpw.close()
}

private fun line() = readLine()!!
private fun ni() = line().toInt()
private fun nl() = line().toLong()
private fun nd() = line().toDouble()
private fun nas() = line().split(" ")
private fun nai() = nas().map { it.toInt() }
private fun nal() = nas().map { it.toLong() }
private fun nad() = nas().map { it.toDouble() }
private fun pr(e: Any) = bpw.println(e)
private fun tr(vararg x: Any) = System.out.println(Arrays.deepToString(x))