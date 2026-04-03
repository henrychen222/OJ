/**
 * 10/07/21 morning
 * https://codeforces.com/contest/1570/problem/A
 */

package codeforce.kotlin_heros.episode_8

import java.io.*

// Accepted
fun solve(s: String) {
    var small = false
    var large = false
    for (c in s) {
        if (c == '<') {
            small = true
        } else if (c == '>') {
            large = true
        }
    }
    // tr("$small $large")
    if (small) {
        if (large) {
            pr('?')
        } else {
            pr('<')
        }
    } else {
        if (large) {
            pr('>')
        } else {
            pr('=')
        }
    }
}

val pw = PrintWriter(System.out)
fun main() {
    var t = ni();
    repeat(t) {
        var s = line()
        solve(s)
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
private fun tr(e: Any) = println(e)