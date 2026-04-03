package codeforce.kotlin_heros

import java.util.*
import java.io.*

fun solve(n: Int, a: List<Int>) {

}

val pw = PrintWriter(System.out)
fun main() {
    var t = ni()
    repeat(t) {
        var n = ni()
        var a = nai()
        solve(n, a)
    }
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
private fun tr(vararg x: Any) = System.out.println(Arrays.deepToString(x))