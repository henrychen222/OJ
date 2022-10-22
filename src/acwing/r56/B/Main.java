/**
 * 06/18/22 morning
 * https://www.acwing.com/problem/content/4486/
 */
package acwing.r56.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int k, int[] a) {
        TreeMap<Integer, Integer> m = counter(a);
        int[] u = removeDuplicatedSorted(a);
        // tr(m, u);
        for (int i = 1; i < u.length; i++) {
            if (u[i] - u[i - 1] <= k) {
                m.remove(u[i - 1]);
            }
        }
        // tr(m);
        long res = 0;
        for (int occ : m.values()) res += occ;
        pr(res);
    }

    int[] removeDuplicatedSorted(int[] a) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x : a) ts.add(x);
        int[] res = new int[ts.size()];
        int p = 0;
        for (int x : ts) res[p++] = x;
        return res;
    }

    TreeMap<Integer, Integer> counter(int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, k, a);
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
        new Main().run();
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