/**
 * 02/22/22 afternoon
 * https://codeforces.com/contest/1645/problem/D
 */
package codeforce.kotlin_heros.practice_9

import java.io.*
import java.util.*
import kotlin.collections.ArrayList

// Accepted   02:38pm
fun Solve(n: Int, a: List<Int>) {
    var m = counter(a)
    // tr(n, m)
    var l: ArrayList<Int> = ArrayList()
    var r: ArrayList<Int> = ArrayList()
    for (x in m.keys) {
        var occ = m[x]
        if (occ!! > 2) {
            pr("NO")
            return
        }
        if (occ == 1) {
            l.add(x)
        } else if (occ == 2) {
            l.add(x)
            r.add(x)
        }
    }
    // tr(l, r)
    pr("YES")
    pr(l.size)
    outputL(l)
    pr(r.size)
    outputL(r.reversed())
}

fun outputL(l: List<Int>) {
    for (e in l) dpw.print("$e ")
    pr("")
}

fun counter(a: List<Int>): TreeMap<Int, Int> {
    val m: TreeMap<Int, Int> = TreeMap()
    for (x in a) m[x] = m.getOrDefault(x, 0) + 1
    return m
}

val dpw = PrintWriter(System.out)
fun main() {
    var n = ni()
    var a = nai()
    Solve(n, a)
    dpw.close()
}

private fun line() = readLine()!!
private fun ni() = line().toInt()
private fun nl() = line().toLong()
private fun nd() = line().toDouble()
private fun nas() = line().split(" ")
private fun nai() = nas().map { it.toInt() }
private fun nal() = nas().map { it.toLong() }
private fun nad() = nas().map { it.toDouble() }
private fun pr(e: Any) = dpw.println(e)
private fun tr(vararg x: Any) = System.out.println(Arrays.deepToString(x))