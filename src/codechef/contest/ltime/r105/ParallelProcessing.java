/**
 * 03/01/22 evening
 * https://www.codechef.com/LTIME105B/problems/PLPROCESS
 */
package codechef.contest.ltime.r105;

import java.util.*;
import java.io.*;

class ParallelProcessing {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/59376076
    // Accepted --- https://www.codechef.com/viewsolution/59376082
    void solve(int n, int[] a) {
        long sum = 0;
        for (int x : a) sum += x;
        // Arrays.sort(a); // issue https://www.codechef.com/viewsolution/59375988
        long l = 0, res = Long.MAX_VALUE;
        for (int x : a) {
            l += x;
            long r = sum - l;
            res = Math.min(res, Math.max(l, r));
        }
        pr(res);
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
        new ParallelProcessing().run();
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
