/**
 * 02/22/22 afternoon
 * https://codeforces.com/contest/1645/problem/C
 */
package codeforce.kotlin_heros.practice_9;

import java.io.*
import java.util.*

// Accepted  02:12pm
fun go(n: Int, a: List<Int>) {
    var b = a.sorted()
    var res = 0L
    for (i in 1 until n step 2) res += b[i] - b[i - 1]
    pr(res)
}

val cpw = PrintWriter(System.out)
fun main() {
    var n = ni()
    var a = nai()
    go(n, a)
    cpw.close()
}

private fun line() = readLine()!!
private fun ni() = line().toInt()
private fun nl() = line().toLong()
private fun nd() = line().toDouble()
private fun nas() = line().split(" ")
private fun nai() = nas().map { it.toInt() }
private fun nal() = nas().map { it.toLong() }
private fun nad() = nas().map { it.toDouble() }
private fun pr(e: Any) = cpw.println(e)
private fun tr(vararg x: Any) = System.out.println(Arrays.deepToString(x))