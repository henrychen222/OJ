/**
 * 06/29/21 morning
 * https://codeforces.com/contest/1533/problem/A
 */

import java.util.*
import kotlin.math.max

// Accepted
fun solve(n: Int, k: Int, a: ArrayList<List<Int>>) {
    // pr("$n $k $a")
    var res = 0
    for (e in a) {
        var start = e[0];
        var end = e[1];
        if (k < start || k > end) continue
        res = max(res, end - k + 1);
    }
    pr(res)
}

fun main() {
    var t = ni()
    while (t-- > 0) {
        var tmp = nai();
        var n = tmp[0];
        var k = tmp[1];
        var list: ArrayList<List<Int>> = ArrayList()
        for (i in 0 until n) {
            var lr = nai()
            list.add(lr);
        }
        solve(n, k, list);
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