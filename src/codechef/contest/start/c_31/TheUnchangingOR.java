/**
 * 03/23/22 morning
 * https://www.codechef.com/START31C/problems/UNCHANGEDOR
 */
package codechef.contest.start.c_31;

import java.util.*;
import java.io.*;

class TheUnchangingOR {
    static PrintWriter pw;

    // Accepted
    void solve(int n) {
        long res = 0, tot = 0, v = 0;
        Map<Long, Long> m = new HashMap<>();
        for (int i = 0; ; i++) {
            long occ = 1L << i;
            v += occ;
            tot += occ;
            // tr("occ", occ, "tot", tot, "v", v);
            if (tot <= n) {
                addOneOrManyMap(m, v, occ);
                if (tot == n) break;
            } else {
                long need = n - occ + 1;
                addOneOrManyMap(m, v, need);
                break;
            }
        }
        // tr(m);
        for (long occ: m.values()) res += occ - 1;
        pr(res);
    }

    <T> void addOneOrManyMap(Map<T, Long> m, T x, long... args) {
        long cnt = args.length == 0 ? 1 : args[0];
        m.put(x, m.getOrDefault(x, 0L) + cnt);
    }

    void test() {
        long cur = 0;
        Map<Long, Integer> m = new HashMap<>();
        for (int i = 1; i <= 31; i++) {
            cur |= i;
            tr(cur);
            // m.put(cur, m.getOrDefault(cur, 0) + 1);
            m.merge(cur, 1, Integer::sum);
        }
        tr(m);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        // test();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            solve(n);
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
        new TheUnchangingOR().run();
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
