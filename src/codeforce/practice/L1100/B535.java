/**
 * 05/24/22 noon
 * https://codeforces.com/problemset/problem/535/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B535 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/535/158324061
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        TreeSet<Integer> ts = buildLuckyNumber();
        int i = 1;
        for (int x : ts) {
            if (x == n) {
                pr(i);
                return;
            }
            i++;
        }
    }

    TreeSet<Integer> buildLuckyNumber() {
        TreeSet<Integer> res = new TreeSet<>();
        Deque<Character> cur = new ArrayDeque<>();
        dfs(cur, res);
        // tr(res);
        return res;
    }

    void dfs(Deque<Character> cur, TreeSet<Integer> res) {
        if (cur.size() > 9) return;
        // tr("cur", cur);
        for (char i = '0'; i <= '9'; i++) {
            cur.add(i);
            if (ok(cur)) {
                res.add(appendNumber(cur));
                dfs(cur, res);
            }
            cur.pollLast();
        }
    }

    boolean ok(Deque<Character> q) {
        if (q.size() > 9) return false;
        for (char c : q) {
            if (c != '4' && c != '7') return false;
        }
        return true;
    }

    int appendNumber(Deque<Character> q) {
        String s = "";
        for (char c : q) s += c;
        return Integer.parseInt(s);
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
        new B535().run();
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