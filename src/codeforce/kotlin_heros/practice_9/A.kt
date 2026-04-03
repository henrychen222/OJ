/**
 * 02/22/22 noon
 * https://codeforces.com/contest/1645/problem/A
 */
package codeforce.kotlin_heros.practice_9;

import java.io.*
import java.util.*
import kotlin.collections.ArrayList

// Accepted
fun solve(n: Int, a: List<Int>) {
    val m = counter_value_in_indexA_in(a)
//    tr(n, a, m)
    for (x in m.keys) {
        if (m[x]!!.size == 1) {
            pr(m[x]!!.get(0) + 1)
            return
        }
    }
}

fun counter_value_in_indexA_in(a: List<Int>): HashMap<Int, ArrayList<Int>> {
    val m: HashMap<Int, ArrayList<Int>> = HashMap()
    val n = a.size;
    for (i in 0 until n) {
        var x = a[i]
        if (!m.containsKey(x)) m.put(x, arrayListOf())
        m.get(x)!!.add(i)
    }
    return m
}

val pw = PrintWriter(System.out)
fun main() {
    var t = ni();
    repeat(t) {
        var n = ni();
        var a = nai();
        solve(n, a)
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
private fun tr(vararg x: Any) = System.out.println(Arrays.deepToString(x))
