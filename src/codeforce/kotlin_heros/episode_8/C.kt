/**
 * 10/07/21 morning  10/08/21 morning complete
 * https://codeforces.com/contest/1570/problem/C
 */

package codeforce.kotlin_heros.episode_8

import java.util.*
import java.io.*
import kotlin.math.min
import kotlin.math.max

//fun operate1(s: String, t: String, mark: Int): Int {
//    var n = min(s.length, t.length)
//    var cnt1 = 0
//    var res0 = 1
//    if (mark == 1) {
//        for (i in 0 until n) {
//            if (s[i] != t[i]) break
//            cnt1++
//        }
//        return cnt1
//    } else {
//        for (i in 0 until n) {
//            if (s[i] != t[i]) {
//                res0 = i+1
//            }
//        }
//        return res0
//    }
//}

fun operate(s: String, t: String): Int {
    var match = 0;
    var i = 0
    while (match < s.length && match < t.length && s[i] == t[i]) {
        match++
        i++
    }
    return match
}

// Accepted --- https://codeforces.com/contest/1571/submission/131153078
// reference SecondThread
val cpw = PrintWriter(System.out)
fun main() {
    var t = ni();
    repeat(t) {
        var n = ni()
//        var zero = 0
//        var one = 0
        var min = -1
        var max = Int.MAX_VALUE
        repeat(n) {
            var tmp = nas()
            var s = tmp[0].reversed()
            var t = tmp[1].reversed()
            var mark = tmp[2].toInt()
//            if (mark == 0) {
//                zero++
//                var tmp = operate(s, t, mark)
//                // tr("0 $tmp")
//                min = min(min, tmp)
//            }
//            if (mark == 1) {
//                var tmp = operate(s, t, mark)
//                // tr("1 $tmp")
//                max = max(max, tmp)
//                one++
//            }
            var res = operate(s, t)
            if (mark == 0) {
                min = max(min, res)
            }
            if (mark == 1) {
                max = min(max, res)
            }
        }
        // tr(min, max)
        pr(max(0, max - min))
        for (x in min + 1..max) prt("$x ")
        pr("")
    }
    cpw.close()
}

private fun line() = readLine()!!
private fun ni() = line().toInt()
private fun nl() = line().toLong()
private fun nd() = line().toDouble()
private fun nas() = line().split(" ")
private fun nai() = nas().map { it.toInt() }
private fun nal() = nas().map { it.toLong() }
private fun nad() = nas().map { it.toDouble() }
private fun prt(e: Any) = cpw.print(e)
private fun pr(e: Any) = cpw.println(e)
private fun tr1(e: Any) = println(e)
private fun tr(vararg x: Any) = System.out.println(Arrays.deepToString(x))