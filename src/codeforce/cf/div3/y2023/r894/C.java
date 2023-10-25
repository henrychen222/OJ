/**
 * 08/24/23 morning
 * https://codeforces.com/contest/1862/problem/C
 */
package codeforce.cf.div3.y2023.r894;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- ecnerwala cuiaoxiang
    void solve(int n, int[] a) {
        if (a[0] != n) {
            pr("NO");
            return;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[a[i] - 1]++;
        for (int i = n - 1; i - 1 >= 0; i--) res[i - 1] += res[i];
        // tr(res);
        pr(Arrays.equals(res, a) ? "YES" : "NO");
    }

    ////////////////////////////////////////////////////////////////////
    // WA
    void solve1(int n, int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>(), cnt = counter(a);
        a = removeDuplicatedSorted(a);
        a = reverseA(a);
        int h = n;
        // tr(a, h);
        for (int i = 1; i < a.length; i++) {
            int d = a[i - 1] - a[i], ct = cnt.get(a[i - 1]);
            // tr(a[i - 1], a[i], "diff", d, m, "height", h);
            m.merge(h, ct, Integer::sum);
            h -= d;
        }
        m.merge(h, cnt.get(a[a.length - 1]), Integer::sum);
        // tr(a, m, h);
        pr(compareTreeMap(m, cnt) ? "YES" : "NO");
    }

    boolean compareTreeMap(TreeMap<Integer, Integer> a, TreeMap<Integer, Integer> b) {
        if (a.size() != b.size()) return false;
        for (int k : a.keySet()) {
            if (!b.containsKey(k)) return false;
            if (a.get(k) != b.get(k)) return false;
        }
        return true;
    }

    TreeMap<Integer, Integer> counter(int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : a) m.merge(x, 1, Integer::sum);
        return m;
    }

    int[] removeDuplicatedSorted(int[] a) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x : a) ts.add(x);
        int[] res = new int[ts.size()];
        int p = 0;
        for (int x : ts) res[p++] = x;
        return res;
    }

    int[] reverseA(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = a[n - i - 1];
        return b;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
        }
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
        new C().run();
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