// 06/29/21 night

import java.util.*
import java.io.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

// Accepted 1247ms https://codeforces.com/contest/1533/submission/120922840
// Accepted 576ms use PrintWriter https://codeforces.com/contest/1533/submission/120923248
fun go(n: Int, m: Int, A: ArrayList<String>, q: Int, B: ArrayList<String>) {
    // pr("$n $m $A $q $B")
    var ma = HashMap<String, Int>()
    // for (t in A) ma.merge(t, 1, Int::plus)
    for (t in A) ma.put(t, ma.getOrDefault(t, 0) + 1) // Accepted --- 530ms https://codeforces.com/contest/1533/submission/120924194
    // pr(ma)
    for (s in B) {
        // pr("s $s")
        var se = HashSet<String>() // save each substring by removing one char
        for (i in 0..m) {
            var tmp = s.substring(0, i) + s.substring(i + 1)
            // pr(tmp)
            se.add(tmp)
        }
        // pr(se)
        var res = 0
        for (u in se) res += ma.getOrDefault(u, 0) // add all possible plus on char from A
        pr(res)
    }
}

val pw = PrintWriter(System.out)
fun main() {
    var tmp = nai()
    var n = tmp[0]
    var m = tmp[1]
    val A: ArrayList<String> = ArrayList()
    val B: ArrayList<String> = ArrayList()
    for (i in 0 until n) A.add(line())
    var q = ni()
    for (i in 0 until q) B.add(line())
    go(n, m, A, q, B)
    pw.close()
}

private fun line() = readLine()!!
private fun ni() = line().toInt()
private fun nl() = line().toLong()
private fun nd() = line().toDouble()
private fun nas() = line().split(" ")
private fun nai() = nas().map { it.toInt() }
private fun nal() = nas().map { it.toLong() }
private fun nad() = nas().map { it.toDouble() }
private fun prt(e: Any) = pw.print(e)
private fun pr(e: Any) = pw.println(e)
private fun tr(e: IntArray) = println(Arrays.toString(e))
private fun tr(e: LongArray) = println(Arrays.toString(e))
private fun tr(e: DoubleArray) = println(Arrays.toString(e))
private fun tr(e: BooleanArray) = println(Arrays.toString(e))
private fun tr(e: CharArray) = println(Arrays.toString(e))
private fun tr(e: Array<String>) = println(Arrays.toString(e))