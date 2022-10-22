/**
 * 06/08/22 morning
 * https://www.codechef.com/START42C/problems/MAXIMISEBITS
 */
package codechef.contest.start.c_42;

import java.util.*;
import java.io.*;

class MaximiseSetBits {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/66435628
    // reference: https://discuss.codechef.com/t/maximisebits-editorial/101464
    void solve(int n, int k) {
        long res = 0;
        while (k > 0) {
            long cur = Math.min(k, n);
            if (cur % 2 != k % 2) cur--;
            res += cur;
            k -= cur;
            k /= 2;
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), k = fs.nextInt();
            solve(n, k);
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
        new MaximiseSetBits().run();
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
