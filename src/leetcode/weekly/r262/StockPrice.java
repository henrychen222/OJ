/**
 * 10/09/21 evening
 * https://leetcode.com/contest/weekly-contest-262/problems/stock-price-fluctuation/
 */
package leetcode.weekly.r262;

import java.util.*;
import java.io.*;

// Accepted --- 182ms  by add that line in CompareTo
class StockPrice {
    static PrintWriter pw;

    TreeSet<Node> se;
    TreeMap<Integer, Integer> m;

    public StockPrice() {
        se = new TreeSet<>();
        m = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (m.containsKey(timestamp)) {
            int prePrice = m.get(timestamp);
            Node n = new Node(timestamp, prePrice);
            se.remove(n);
            se.add(new Node(timestamp, price));
        } else {
            se.add(new Node(timestamp, price));
        }
        m.put(timestamp, price);
    }

    public int current() {
        return m.lastEntry().getValue();
    }

    public int maximum() {
        debug();
        return se.last().price;
    }

    public int minimum() {
        debug();
        return se.first().price;
    }

    private void debug () {
        for (Node n: se) {
            pw.println("debug" + " " + n.timestamp + " " + n.price);
        }
    }

    class Node implements Comparable<Node> {
        int timestamp, price;

        Node(int timestamp, int price) {
            this.timestamp = timestamp;
            this.price = price;
        }

        @Override
        public int compareTo(Node y) {
            if (price == y.price) return Integer.compare(timestamp, y.timestamp); // fuck, forget this line
            return Integer.compare(price, y.price);
        }
    }

    public void run() {
//        StockPrice stockPrice = new StockPrice();
//        stockPrice.update(1, 10);
//        stockPrice.update(2, 5);
//        pr(stockPrice.current());     // 5
//        pr(stockPrice.maximum());     // 10
//        stockPrice.update(1, 3);
//        pr(stockPrice.maximum());     // 5
//        stockPrice.update(4, 2);
//        pr(stockPrice.minimum());     // 2

//        StockPrice stockPrice = new StockPrice();
//        stockPrice.update(1, 10);
//        stockPrice.update(2, 5);
//        stockPrice.update(3, 15);
//        pr(stockPrice.current());
//        pr(stockPrice.maximum());
//        stockPrice.update(3, 8);
//        pr(stockPrice.maximum());
//        stockPrice.update(1, 3);
//        pr(stockPrice.current());
//        pr(stockPrice.maximum());
//        stockPrice.update(4, 2);
//        pr(stockPrice.minimum());

        // uwi gives
        StockPrice stockPrice2 = new StockPrice();
        stockPrice2.update(3, 4);
        pr(stockPrice2.maximum()); // 4
        stockPrice2.update(5, 4);
        pr(stockPrice2.maximum()); // 4
        stockPrice2.update(5, 2);
        pr(stockPrice2.maximum()); // 4
    }

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new StockPrice().run();
        pw.close();
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}


