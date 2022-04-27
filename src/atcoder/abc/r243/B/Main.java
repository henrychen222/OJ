/**
 * 03/12/22 morning
 * https://atcoder.jp/contests/abc243/tasks/abc243_b
 */
package atcoder.abc.r243.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n  =fs.nextInt();
        int[] a =fs.readArray(n), b = fs.readArray(n);
        int res1 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) res1++;
        }
        pr(res1);
        Map<Integer, Integer> ma = op(a), mb = op(b);
        int res2 = 0;
        for (int x: ma.keySet()) {
            int idx = ma.get(x);
            if (mb.containsKey(x) && idx != mb.get(x)) res2++;
        }
        pr(res2);
    }

    Map<Integer, Integer> op (int[]a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) m.put(a[i], i);
        return m;
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