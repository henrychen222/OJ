// 06/29/21 afternoon

import java.util.*

fun dfs(idx: Int, k: Int, s: String): Int {
    if (!s.contains('1')) return 0
    var nextIdx = (idx + k - 1) % s.length
    var nextS = s.substring(0, nextIdx) + s.substring(nextIdx + 1)
    return 1 + dfs(nextIdx, k, nextS)
}

fun main() {
    var t = ni()
    while (t-- > 0) {
        var tmp = nai()
        var n = tmp[0]
        var k = tmp[1]
        var s = line()
        pr(dfs(-k + 1, k, s))
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
private fun prt(e: Any) = print(e)
private fun pr(e: Any) = println(e)
private fun tr(e: IntArray) = println(Arrays.toString(e))
private fun tr(e: LongArray) = println(Arrays.toString(e))
private fun tr(e: DoubleArray) = println(Arrays.toString(e))
private fun tr(e: BooleanArray) = println(Arrays.toString(e))
private fun tr(e: CharArray) = println(Arrays.toString(e))
private fun tr(e: Array<String>) = println(Arrays.toString(e))