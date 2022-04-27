/**
 * 04/01/22 evening
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000876ff1/0000000000a46471
 */
package codejam.y2022.Qualification.C;

import java.util.*;
import java.io.*;

// Accepted
public class Solution {
    static PrintWriter pw;

    /*
    4 5 6 7 8 9

    1 2 3 4 5 6  1 + (6-1) = 6
    2 3 4 5 6 7  2 + (6-1) = 7
    4 5 6 7 8 9  4 + (6-1) = 9

    ans: 6
    */
    void solve(int n, int[] a) {
        Map<Integer, Integer> m = counter(a);
        int[] u = removeDuplicatedSorted(a);
        int min = u[0];
        if (n < min) {
            pr(n);
            return;
        }
        int cur = 0;
        // tr(u, m);
        for (int i = 0; i < u.length; i++) {
            int occ = m.get(u[i]);
            int up = cur + occ;
            // tr("cur", cur, "occ", occ, "up", up);
            if (up >= u[i]) {
                cur = u[i];
            } else {
                cur = up;
            }
        }
        pr(cur);
    }

    int[] removeDuplicatedSorted(int[] a) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x : a) ts.add(x);
        int[] res = new int[ts.size()];
        int p = 0;
        for (int x : ts) res[p++] = x;
        return res;
    }

    Map<Integer, Integer> counter(int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
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
        new Solution().run();
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}