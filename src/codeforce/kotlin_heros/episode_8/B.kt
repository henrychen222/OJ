/**
 * 10/07/21 morning
 * https://codeforces.com/contest/1570/problem/B
 */

package codeforce.kotlin_heros.episode_8

import java.io.*
import kotlin.math.floor

/**
 * 10 1
 * 16 x
 * 20 4
 *
 * (x - 1) / (16 - 10) = (4 - x) / (20 - 16)
 *
 * (x - va) / (b - a) = (vc - x) / (c - b)
 *
 * (b - a) * (vc - x) = (x - va) * (c - b)
 *  b * vc - b * x - a * vc + a * x = x * c - x * b - va * c + va * b
 *
 *  a * x - b * x - c * x + b * x = va * b - va * c - b * vc + a * vc
 *  (a - b - c + b) * x = va * b - va * c - b * vc + a * vc
 */
fun solve(n: Int, a: Int, va: Int, c: Int, vc: Int, b: Int) {
    // tr("$n $a $va $c $vc $b")
    var x = (va * b - va * c - b * vc + a * vc).toDouble() / (a - c).toDouble()
    // tr(x)
    pr(floor(x).toInt())
}

val bpw = PrintWriter(System.out)
fun main() {
    var t = ni();
    repeat(t) {
        var n = ni()
        var tmp = nai()
        var a = tmp[0]
        var va = tmp[1]
        tmp = nai()
        var c = tmp[0]
        var vc = tmp[1]
        var b = ni()
        solve(n, a, va, c, vc, b)
    }
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
private fun prt(e: Any) = bpw.print(e)
private fun pr(e: Any) = bpw.println(e)
private fun tr(e: Any) = println(e)