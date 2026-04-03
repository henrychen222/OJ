/**
 * 06/29/21 morning
 * https://codeforces.com/contest/1533/problem/C
 */

import java.util.*

fun solve(n: Int, k: Int, s: String) {
    // pr("$n $k $s")
    val like: HashSet<Int> = HashSet()
    val a: ArrayList<Int> = ArrayList()
    for (i in 0 until n) {
        a.add(i + 1)
        if (s[i] == '1') {
            like.add(i + 1);
        }
    }
    // pr("$like $a ${a[0]}")
    var start = 0
    a.removeAt(0)
    if (like.contains(a[0])) {
        like.remove(a[0])
    }
    var eat = 1
    // pr("$like $a")
    var m = a.size
    while (like.size > 0) {
        var stop = start + k - 1
        // pr("$start $stop ${m-1}")
        if (stop > m - 1) {
            var rest = k - (m - 1 - start + 1)
            stop = rest - 1;
        }
        if (like.contains(a[stop])) {
            like.remove(a[stop])
        }
        // pr("remove ${a[stop]} ${a} ${like}")
        start = stop + 1;
        a.removeAt(stop)
        start--
        m--
        if(like.size == 1) return pr(eat + 1)
        eat++
    }
    pr(eat)
}

fun main() {
    var t = ni()
    while (t-- > 0) {
        var tmp = nai()
        var n = tmp[0]
        var k = tmp[1]
        var s = line()
        solve(n, k, s)
    }
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
private fun tr(e: DoubleArray) = println(Arrays.toString(e))
private fun tr(e: BooleanArray) = println(Arrays.toString(e))
private fun tr(e: CharArray) = println(Arrays.toString(e))
private fun tr(e: Array<String>) = println(Arrays.toString(e))