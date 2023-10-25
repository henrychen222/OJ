/**
 * 01/15/23 afternoon
 * https://codeforces.com/problemset/problem/6/E
 */
package codeforce.practice.L1900;

import java.util.*;
import java.io.*;

public class E6_3 {
    static PrintWriter pw;

    // Accepted --- use TreeMap https://codeforces.com/contest/6/submission/189379745
    void solve(int n, int k, int[] h) {
        int max = 1;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        List<String> res = new ArrayList<>();
        addOneOrManyMap(m, h[0]);
        int r = 0;
        for (int i = 0; i < n; ) {
            while (r < n) {
                r++;
                if (r >= n) break;
                addOneOrManyMap(m, h[r]);
                if (m.lastKey() - m.firstKey() > k) break;
            }
            if (max < r - i) {
                max = r - i;
                res.clear();
                res.add((i + 1) + " " + r);
            } else if (max == r - i) {
                res.add((i + 1) + " " + r);
            }
            max = Math.max(max, r - i);
            removeOneOrManyMap(m, h[i++]);
            while (m.size() > 0 && m.lastKey() - m.firstKey() > k) removeOneOrManyMap(m, h[i++]);
        }
        pr(max + " " + res.size());
        for (String e : res) pr(e);
    }

    <T> void addOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0];
        m.put(x, m.getOrDefault(x, 0) + cnt);
    }

    <T> void removeOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0], occ = m.get(x);
        if (occ > cnt) {
            m.put(x, occ - cnt);
        } else {
            m.remove(x);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        int[] h = fs.readArray(n);
        solve(n, k, h);
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
        new E6_3().run();
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