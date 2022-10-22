/**
 * 06/22/22 morning
 * https://www.codechef.com/START44C/problems/ABCXOR
 */
package codechef.contest.start.c_44;

import java.util.*;
import java.io.*;

class TripleXOR {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/67391099
    // reference: https://www.youtube.com/watch?v=gEoPGFBfIBA
    void solve(int n, int k) {
        long res = 1;
        for (int i = 0; i < n; i++) res *= 4;
        res -= ((1L << n) - 1) * 3L;
        pr(res - 1);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            solve(a[0], a[1]);
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
        new TripleXOR().run();
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
