/**
 * 10/05/21 afternoon
 * https://codeforces.com/contest/1570/problem/E
 */
package codeforce.kotlin_heros.practice_8

import java.util.*
import java.io.*
import kotlin.collections.ArrayList

// Accepted
fun solve(s: String) {
    var n = s.length
    var pre = 0
    var res = 0
    var pos: ArrayList<Int> = ArrayList()
    for (i in 0 until n) {
        if (s[i] == '1') pos.add(i)
    }
    // tr(pos)
    var pn = pos.size
    for (i in 1 until pn) {
        var add = pos[i] - pos[i - 1] - 1
        res += add
        // tr("add $add")
    }
    pr(res)
}

val epw = PrintWriter(System.out)
fun main() {
    var t = ni()
    repeat(t) {
        var s = line()
        solve(s)
    }
    epw.close()
}

private fun line() = readLine()!!
private fun ni() = line().toInt()
private fun nl() = line().toLong()
private fun nd() = line().toDouble()
private fun nas() = line().split(" ")
private fun nai() = nas().map { it.toInt() }
private fun nal() = nas().map { it.toLong() }
private fun nad() = nas().map { it.toDouble() }
private fun prt(e: Any) = epw.print(e)
private fun pr(e: Any) = epw.println(e)
private fun tr(e: Any) = println(e)