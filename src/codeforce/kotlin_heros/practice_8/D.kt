/**
 * 10/05/21 evening
 * https://codeforces.com/contest/1570/problem/D
 */
package codeforce.kotlin_heros.practice_8

import java.util.*
import java.io.*
import kotlin.collections.HashSet

/**
 * 1099 -> 11 -> 19 -> 2 -> 9 -> 1
 *
 * 10
 * 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19
 */
// Accepted
fun solve(N: Long) {
    val se: HashSet<Long> = HashSet()
    var ss = N.toString()
    var cur = (ss.substring(0, ss.length - 1) + '9').toLong()
    for (x in N..cur) se.add(x)
    while (cur != 9L) {
        var s = parse(cur + 1)
        cur = (s.substring(0, s.length - 1) + '9').toLong()
        for (x in s.toLong()..cur) se.add(x)
    }
    for (x in 1L..9L) {
        se.add(x)
    }
    // pr(se)
    pr(se.size)
}

//fun solve1(N: Int) {
//    var res = 0L
//    var ss = N.toString()
//    var cur = (ss.substring(0, ss.length - 1) + '9').toInt()
//    res += cur - N
//    // tr("start $cur res $res")
//    // for (i in 0..10) {
//    while (cur != 9) {
//        var s = parse(cur + 1)
//        // tr("next $s")
//        cur = (s.substring(0, s.length - 1) + '9').toInt()
//        var last = s[s.length - 1] - '0'
//        res += 9 - last + 1
//        // tr("cur $cur res $res")
//    }
//    pr(res + 2)
//}

fun parse(x: Long): String {
    var s = x.toString()
    var n = s.length
    var idx = -1
    for (i in n - 1 downTo 0) {
        if (s[i] != '0') {
            idx = i
            break
        }
    }
    return s.substring(0, idx + 1)
}

val dpw = PrintWriter(System.out)
fun main() {
    var n = nl()
    solve(n)
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
private fun prt(e: Any) = dpw.print(e)
private fun pr(e: Any) = dpw.println(e)
private fun tr(e: Any) = println(e)