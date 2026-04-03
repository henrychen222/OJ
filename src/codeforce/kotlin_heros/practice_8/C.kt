/**
 * 10/05/21 afternoon
 * https://codeforces.com/contest/1570/problem/C
 */
package codeforce.kotlin_heros.practice_8

import java.util.*
import java.io.*
import kotlin.collections.ArrayList

/**
 * 20 * 0 + 1 + 20 * 1 + 1  + 10 * 2 + 1
 *
 * 5 4 5 4 4 5
 *
 * 5 * 0 + 1 + 5 * 1 + 1 + 5 * 2 + 1 + (4 * 3 + 1 + 4 * 4 + 1 + 4 * 5 + 1)
 */
// Accepted
fun solve(n: Int, a: List<Int>) {
    // tr("$n $a")
    val tm: TreeMap<Int, ArrayList<Int>> = TreeMap(Collections.reverseOrder())
    for (i in 0 until n) {
        var x = a[i]
        if (!tm.containsKey(x)) tm.put(x, arrayListOf())
        tm.get(x)!!.add(i + 1)
    }
    // tr(tm)
    var sum = 0L
    var i = 0
    val pos: ArrayList<Int> = ArrayList()
    for ((x, b) in tm) {
        for (y in b) pos.add(y)
        var occ = b.size
        var end = i + occ - 1;
        // tr("each $x $b start $i end $end cal ${cal(i, end)}")
        sum += x * cal(i, end) + occ
        i += occ
    }
    pr(sum)
    for (x in pos) prt("$x ")
}

fun cal(start: Int, end: Int): Long {
    return (start + end).toLong() * (end - start + 1) / 2;
}

val cpw = PrintWriter(System.out)
fun main() {
    var n = ni()
    var a = nai()
    solve(n, a)
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
private fun prt(e: Any) = cpw.print(e)
private fun pr(e: Any) = cpw.println(e)
private fun tr(e: Any) = println(e)