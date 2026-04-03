/**
 * 06/26/21 night
 * https://codeforces.com/contest/1532/problem/C
 */

package codeforce.kotlin_heros.practice_7

import java.util.*

// Accepted
fun solve(n: Int, k: Int) {
    // pr("$n $k")
    if (k >= n) {
        var res = ""
        for (i in 0 until n) {
            var c = (97 + i).toChar()
            res += c
        }
        return pr(res)
    }
    var freq = n / k;
    var f = IntArray(k) { i -> freq }
    // tr(f);
    var res = "";
    for (i in f.size - 1 downTo 0) {
        // pr(i);
        var c = (97 + i).toChar();
        var s = c.toString().repeat(f[i]);
        res += s;
    }
    // pr(res);
    var restL = n - res.length;
    var lastc = res[res.length - 1];
    // pr("$restL $lastc")
    while (restL-- > 0) res += lastc
    pr(res)
//    var c = (96 + k).toChar()
//    var s = c.toString().repeat(k);
//    pr(s);
//    var i = 0
//    while(s.length + k < n) {
//        var down = down(c, i);
//        s += down.toString().repeat(k);
//        i++;
//    }
//    pr(s);
}

fun down(c: Char, i: Int): Char {
    return (c.toInt() - i).toChar();
}

fun main() {
    var t = ni();
    while (t-- > 0) {
        var a = nai();
        solve(a[0], a[1]);
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
private fun tr(e: IntArray) = println(Arrays.toString(e))
private fun tr(e: LongArray) = println(Arrays.toString(e))