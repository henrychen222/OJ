/**
 * 03/08/22 morning
 * https://www.acwing.com/problem/content/4312/
 */
package acwing.r41.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted ---- https://www.acwing.com/problem/content/submission/code_detail/11694705/
    // post --- https://www.acwing.com/solution/content/98330/
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), x0 = fs.nextInt(), y0 = fs.nextInt();
        Set<Double> se = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int[] a = fs.readArray(2);
            double k;
            if (a[0] == x0) { // not exist
                k = Double.POSITIVE_INFINITY;
            } else {
                k = (double) (a[1] - y0) / (a[0] - x0);
                if (k == -0.0) k = 0.0; // java double distinguish 0.0 and -0.0
            }
            // tr("k", k);
            se.add(k);
        }
        // tr(se.size(), se);
        pr(se.size());
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
