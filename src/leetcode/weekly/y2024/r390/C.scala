/**
 * 03/27/24 evening
 */

import scala.collection._

object C {

  // Accepted --- 1514ms
  def mostFrequentIDs(a: Array[Int], b: Array[Int]): Array[Long] = {
    val pq = mutable.PriorityQueue[Array[Long]]()(Ordering.by(x => x(1)))
    val n = a.length
    val f = Array.fill(a.max + 1)(0L)
    val res = Array.fill(n)(0L)
    // println(f.mkString(" "))
    for (i <- 0 until n) {
      val x = a(i)
      val occ = b(i).toLong
      f(x) += occ
      pq += Array(x.toLong, f(x))
      while (pq.nonEmpty && pq.head(1) != f(pq.head(0).toInt)) pq.dequeue
      // println(pq.size, pq.head.mkString(" "))
      res(i) = if (pq.isEmpty) 0 else pq.head(1)
    }
    res
  }

  def main(args: Array[String]): Unit = {
    val a = Array(2, 3, 2, 1)
    val b = Array(3, 2, -3, 1)
    println(mostFrequentIDs(a, b).mkString(" "))

    val a2 = Array(5, 5, 3)
    val b2 = Array(2, -2, 1)
    println(mostFrequentIDs(a2, b2).mkString(" "))
  }
}