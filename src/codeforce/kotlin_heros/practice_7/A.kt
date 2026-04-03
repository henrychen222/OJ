/**
 * 06/26/21 night
 * https://codeforces.com/contest/1532/problem/A
 */

package codeforce.kotlin_heros.practice_7

// Accepted
fun solve() {
    var a = nai();
    pr(a.get(0) + a.get(1));
}

fun main() {
    var t = ni();
    while (t-- > 0) {
        solve();
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