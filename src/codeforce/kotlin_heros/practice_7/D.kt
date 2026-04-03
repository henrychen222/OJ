/**
 * 06/26/21 night
 * https://codeforces.com/contest/1532/problem/D
 */

package codeforce.kotlin_heros.practice_7

import java.util.*

// Accepted
fun solve(n: Int, a: List<Int>) {
    var f = IntArray(101) { i -> 0 }
    for (e in a) {
        f[e]++;
    }
    // tr(f);
    val list: ArrayList<Int> = ArrayList()
    for (i in 0..100) {
        var occ = f[i];
        if (occ == 0) continue
        if (occ % 2 == 1) {
            list.add(i);
        }
    }
    // pr(list);
    var res = 0;
    for (i in 0 until list.size step 2) {
        res += list[i + 1] - list[i];
    }
    pr(res);
}

fun main() {
    var n = ni()
    var a = nai();
    solve(n, a);
}

private fun line() = readLine()!!
private fun ni() = line().toInt()
private fun nl() = line().toLong()
private fun nd() = line().toDouble()
private fun nas() = line().split(" ")
private fun nai() = nas().map { it.toInt() }
private fun nal() = nas().map { it.toLong() }
private fun nad() = nas().map { it.toDouble() }
private fun pr(e: Any) = println(e)
private fun tr(e: IntArray) = println(Arrays.toString(e))
private fun tr(e: LongArray) = println(Arrays.toString(e))