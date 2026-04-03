/**
 * 06/26/21 night
 * https://codeforces.com/contest/1532/problem/B
 */

package codeforce.kotlin_heros.practice_7

// Accepted
fun solve(a: Long, b: Long, k: Long) {
    // pr(" $a $b $k");
    if (k % 2 == 0L) {
        pr((a - b) * (k / 2));
    } else {
        pr((a - b) * (k - 1) / 2 + a);
    }
}

fun main() {
    var t = ni();
    while (t-- > 0) {
        var a = nal();
        solve(a[0], a[1], a[2]);
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
private fun pr(e: Any) = println(e)