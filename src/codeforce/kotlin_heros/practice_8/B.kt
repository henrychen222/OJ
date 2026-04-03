/**
 * 10/04/21 night
 * https://codeforces.com/contest/1570/problem/A
 */
package codeforce.kotlin_heros.practice_8

import java.util.*
import java.io.*

// Accepted
fun solve(a1: Int, a2: Int, k1: Int, k2: Int, n: Int) {
    var min = n - a1 * (k1 - 1) - a2 * (k2 - 1)
    if (min < 0) min = 0;
    prt("$min ")
    if (k1 <= k2) {
        pr(cal(k1, k2, a1, a2, n))
    } else {
        pr(cal(k2, k1, a2, a1, n))
    }
}

fun cal(k_s: Int, k_l: Int, a_s: Int, a_l: Int, n: Int): Int {
    var max = 0
    var p_s = a_s * k_s
    if (n <= p_s) {
        max += Math.ceil((n / k_s).toDouble()).toInt()
    } else {
        max += a_s
        var rest = n - p_s
        var p_l = a_l * k_l
        // tr("max $max rest $rest large $p_l")
        if (rest <= p_l) {
            max += Math.ceil((rest / k_l).toDouble()).toInt()
        } else {
            max += a_l;
        }
    }
    return max
}

val bpw = PrintWriter(System.out)
fun main() {
    var a1 = ni()
    var a2 = ni()
    var k1 = ni()
    var k2 = ni()
    var n = ni()
    solve(a1, a2, k1, k2, n)
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
private fun tr(e: IntArray) = println(Arrays.toString(e))
private fun tr(e: LongArray) = println(Arrays.toString(e))
private fun tr(e: DoubleArray) = println(Arrays.toString(e))
private fun tr(e: BooleanArray) = println(Arrays.toString(e))
private fun tr(e: CharArray) = println(Arrays.toString(e))
private fun tr(e: Array<String>) = println(Arrays.toString(e))