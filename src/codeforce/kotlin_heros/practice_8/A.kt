/**
 * 10/04/21 night
 * https://codeforces.com/contest/1570/problem/A
 */

package codeforce.kotlin_heros.practice_8

import java.util.*
import java.io.*

// Accepted
fun solve(a: Int, b: Int) {
    pr(a + b);
}

val pw = PrintWriter(System.out)
fun main() {
    var t = ni();
    repeat(t) {
        var a = nai();
        solve(a[0], a[1]);
    }
    pw.close()
}

private fun line() = readLine()!!
private fun ni() = line().toInt()
private fun nl() = line().toLong()
private fun nd() = line().toDouble()
private fun nas() = line().split(" ")
private fun nai() = nas().map { it.toInt() }
private fun nal() = nas().map { it.toLong() }
private fun nad() = nas().map { it.toDouble() }
private fun prt(e: Any) = pw.print(e)
private fun pr(e: Any) = pw.println(e)
private fun tr(e: IntArray) = println(Arrays.toString(e))
private fun tr(e: LongArray) = println(Arrays.toString(e))
private fun tr(e: DoubleArray) = println(Arrays.toString(e))
private fun tr(e: BooleanArray) = println(Arrays.toString(e))
private fun tr(e: CharArray) = println(Arrays.toString(e))
private fun tr(e: Array<String>) = println(Arrays.toString(e))