/**
 * 06/29/21 morning
 * https://codeforces.com/contest/1532/problem/F
 */

package codeforce.kotlin_heros.practice_7

import java.util.*

// don't know
fun solve(n: Int, a: Array<String>, tot: Int) {
    pr("$n ${Arrays.toString(a)}")
    var origin = a.clone();
    // tr(origin)
    a.sortByDescending { it.length }
    tr(a)
    var half = tot / 2;
    var len = a[0].length
    for (s in a) {
        if (s.length != len) break;
        pr("meet ${s}")
        var pre = CharArray(tot) { i -> ' ' }
        var suf = CharArray(tot) { i -> ' ' }
        var pcnt = 0
        var scnt = 0
        for (i in 0 until n) {
            if (isPrefix(a[i], s)) {
                pcnt++
                pre[i] = 'P'
            }
            if (isSuffix(a[i], s)) {
                scnt++
                suf[i] = 'S'
            }
        }
        pr("$half $pcnt $scnt")
        if (pcnt == half) {
            var res = ""
            pr("prefix")
            tr(pre)
            for (e in pre) {
                if (e == 'P') {
                    res += e
                } else {
                    res += 'S'
                }
            }
            return pr(res)
        }
        if (scnt == half) {
            pr("suffix")
            tr(suf)
            var res = ""
            for (e in suf) {
                if (e == 'S') {
                    res += e
                } else {
                    res += 'P'
                }
            }
            return pr(res)
        }
    }
}

fun isPrefix(t: String, s: String): Boolean {
    return s.startsWith(t);
}

fun isSuffix(t: String, s: String): Boolean {
    return s.endsWith(t);
}

fun main() {
    var n = ni()
    var tot = 2 * n - 2;
    var ps = Array(tot) { i -> "" }
    for (i in 0 until tot) {
        var s = line()
        ps[i] = s
    }
    solve(n, ps, tot)
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