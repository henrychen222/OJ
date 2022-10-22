/**
 * 06/22/22 morning
 * https://www.codechef.com/START44C/problems/ATAT
 */
package codechef.contest.start.c_44;

import java.util.*;
import java.io.*;

class AtLeastAtMost {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/67398153
    // reference: https://www.youtube.com/watch?v=m85lhJd4dKc
    void solve(int n, int[] a) {
        long[] min = new long[n + 1], L = new long[n + 1], R = new long[n + 1];
        for (int x : a) {
            min[0]++;
            min[x]--;
            L[0] += n - x + 1;
            L[x] -= n - x + 1;
            R[n - 1] += n - x;
            R[x] -= n - x;
        }
        for (int i = 1; i <= n; i++) {
            min[i] += min[i - 1];
            L[i] += L[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) R[i] += R[i + 1];
        for (int i = 0; i < n; i++) {
            long res = L[i] + R[i];
            pr(min[i] + " " + res);
        }
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
        new AtLeastAtMost().run();
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
