/**
 * 05/01/22 morning
 * https://www.codechef.com/COOK141C/problems/DOUBLEDDIST
 */
package codechef.contest.cook.c_141;

import java.util.*;
import java.io.*;

class DoubledDistances {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] a) {
        Arrays.sort(a);
        // tr("a", a);
        int[] d = new int[n - 1];
        for (int i = 1; i < n; i++) d[i - 1] = a[i] - a[i - 1];
        // tr("d", d);
        for (int i = 1; i < n - 1; i++) {
            if (d[i - 1] * 2 == d[i] || d[i] * 2 == d[i - 1]) continue;
            pr("No");
            return;
        }
        pr("Yes");
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
        new DoubledDistances().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}