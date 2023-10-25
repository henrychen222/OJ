/**
 * 01/18/23 morning
 * https://www.codechef.com/START74C/problems/MININV
 */
package codechef.contest.start.y2023.c_74;

import java.util.*;
import java.io.*;

class MinimalInversions {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/86110356
    /*
     reference:
     https://discuss.codechef.com/t/mininv-editorial/104921
     https://www.codechef.com/viewsolution/85973299
     */
    void solve(int n, int[] a) {
        int[] before = new int[n + 2], after = new int[n + 2];
        for (int x : a) before[x]++;
        long cur = 0, res = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur -= after[a[i]];
            after[a[i] + 1]++;
            before[a[i]]--;
            cur += before[a[i] + 1];
            res = Math.max(res, cur);
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
        new MinimalInversions().run();
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
