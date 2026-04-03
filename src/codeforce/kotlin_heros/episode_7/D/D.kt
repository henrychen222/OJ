/**
 * 06/29/21 morning
 * https://codeforces.com/contest/1533/problem/D
 */

import java.util.*
import kotlin.math.abs

// TLE
fun solve(n: Int, m: Int, A: ArrayList<String>, q: Int, B: ArrayList<String>) {
    // pr("$n $m $A $q $B")
    for (i in 0 until q) {
        var s = B[i]
        var cnt = 0
        for (t in A) {
            if (ok(s, t)) cnt++
        }
        pr(cnt)
    }
}

fun ok(s: String, t: String): Boolean {
    var mt = counter(t)
    var ms = counter(s)
    // pr("$s $mt $t $ms")
    var diff = 0
    var res = true
    for (k in ms.keys) {
        var occ = ms[k];
        if (!mt.containsKey(k)) {
            diff += occ!!
        } else {
            diff += abs(occ!! - mt[k]!!)
        }
        if (diff > 1) {
            res = false
            break
        }
    }
    if (!isSubsequence(s, t)) {
        res = false;
    }
    // pr(res)
    return res
}

fun isSubsequence(s: String, t: String): Boolean {
    var sn = s.length
    var tn = t.length
    var i = 0
    var j = 0
    while (i < sn && j < tn) {
        if (s[i] == t[j]) {
            i++
            j++
        } else {
            i++
        }
    }
    return j == tn
}

fun counter(s: String): HashMap<Char, Int> {
    val m: HashMap<Char, Int> = HashMap()
    for (c in s) {
        m[c] = m.getOrDefault(c, 0) + 1
    }
    return m
}

fun main() {
    var tmp = nai()
    var n = tmp[0]
    var m = tmp[1]
    val A: ArrayList<String> = ArrayList()
    val B: ArrayList<String> = ArrayList()
    for (i in 0 until n) A.add(line())
    var q = ni()
    for (i in 0 until q) B.add(line())

    solve(n, m, A, q, B)
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