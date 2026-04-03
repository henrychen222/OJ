/**
 * 06/28/21 morning
 * https://codeforces.com/contest/1532/problem/E
 */

package codeforce.kotlin_heros.practice_7

import java.util.*

// Accepted
fun go(n: Int, a: List<Int>) {
    var sum = 0L
    val list: ArrayList<Int> = ArrayList()
    val m: HashMap<Long, Int> = HashMap()
    for (i in 0 until n) {
        var e = a[i].toLong()
        sum += e
        m.put(e, m.getOrDefault(e, 0) + 1)
    }
    // pr(m);
    for (i in 0 until n) { // fuck issue, should not convert each to int. should use long in map
        var cur = sum - a[i]
        if (cur % 2 == 1L) continue
        var each = cur / 2L;
        // pr("trace $i $cur $each")
        if (!m.containsKey(each)) continue
        var occ = m[each]
        if (occ == 1 && a[i].toLong() == each) continue
        var actual = 0L;
        for (k in m.keys) {
            var occ = m[k]
            if (k == a[i].toLong()) {
                actual += k * (occ!! - 1L);
            } else {
                actual += k * occ!!
            }
        }
        // pr(actual)
        if (actual == cur) list.add(i + 1)
    }
    // pr(list)
    pr(list.size)
    for (e in list) prt("$e ");
}

fun main() {
    var n = ni()
    var a = nai();
    go(n, a);
}

private fun line() = readLine()!!
private fun ni() = line().toInt()
private fun nl() = line().toLong()
private fun nd() = line().toDouble()
private fun nas() = line().split(" ")
private fun nai() = nas().map { it.toInt() }
private fun nal() = nas().map { it.toLong() }
private fun nad() = nas().map { it.toDouble() }
private fun prt(e: Any) = print(e)
private fun pr(e: Any) = println(e)
private fun tr(e: IntArray) = println(Arrays.toString(e))
private fun tr(e: LongArray) = println(Arrays.toString(e))