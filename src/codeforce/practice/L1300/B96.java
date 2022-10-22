/**
 * 09/06/22 night
 * https://codeforces.com/problemset/problem/96/B
 *
 * similar problem:
 * https://codeforces.com/problemset/problem/535/B
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class B96 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/96/171187474
    void solve(int n) {
        TreeSet<Long> ts = buildSuperLuckyNumber();
        // tr(ts);
        for (long x : ts) {
            if (x >= n) {
                pr(x);
                return;
            }
        }
    }

    TreeSet<Long> buildSuperLuckyNumber() {
        TreeSet<Long> res = new TreeSet<>();
        Deque<Character> cur = new ArrayDeque<>();
        dfs(cur, res);
        return res;
    }

    void dfs(Deque<Character> cur, TreeSet<Long> res) {
        if (cur.size() > 11) return; // max 7777744444
        for (char i = '0'; i <= '9'; i++) {
            cur.add(i);
            if (ok(cur)) {
                if (isEqual(cur)) res.add(appendNumber(cur));
                dfs(cur, res);
            }
            cur.pollLast();
        }
    }

    boolean ok(Deque<Character> q) {
        if (q.size() > 11) return false;
        for (char c : q) {
            if (c != '4' && c != '7') return false;
        }
        return true;
    }

    long appendNumber(Deque<Character> q) {
        String s = "";
        for (char c : q) s += c;
        return Long.parseLong(s);
    }

    boolean isEqual(Deque<Character> cur) {
        int four = 0, seven = 0;
        for (int x : cur) {
            if (x == '4') {
                four++;
            } else {
                seven++;
            }
        }
        return four == seven;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        solve(n);
    }

    private final String INPUT = "input.txt";
    private final String OUTPUT = "output.txt";

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            instream = new FileInputStream(INPUT);
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new B96().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}