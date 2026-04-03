/**
 * 02/22/22 afternoon
 * https://codeforces.com/contest/1645/problem/E
 */
package codeforce.kotlin_heros.practice_9

import java.io.*
import java.util.*

// Accepted --- 03:03pm
// reference: https://www.geeksforgeeks.org/represent-n-as-the-sum-of-exactly-k-powers-of-two-set-2/
fun solve(n: Int, k: Int) {
    var sum = k.toLong()
    var a = IntArray(k) { 1 }
    for (i in k - 1 downTo 0) {
        while (sum + a[i] <= n) {
            sum += a[i]
            a[i] *= 2
        }
    }
    if (sum != n.toLong()) {
        pr("NO")
        return
    }
    pr("YES")
    outputA(a)
}

fun outputA(a: IntArray) {
    for (e in a) epw.print("$e ")
    pr("")
}

val epw = PrintWriter(System.out)
fun main() {
    var a = nai()
    solve(a[0], a[1])
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
private fun pr(e: Any) = epw.println(e)
private fun tr(vararg x: Any) = System.out.println(Arrays.deepToString(x))
