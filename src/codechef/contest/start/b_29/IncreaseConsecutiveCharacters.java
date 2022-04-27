/**
 * 03/09/22 afternoon
 * https://www.codechef.com/START29B/problems/CCD
 */
package codechef.contest.start.b_29;

import java.util.*;
import java.io.*;

// Accepted --- https://www.codechef.com/viewsolution/60043994
/*
   reference:
   https://discuss.codechef.com/t/ccd-editorial/99846
   https://www.codechef.com/viewsolution/60001026
 */
class IncreaseConsecutiveCharacters {
    static PrintWriter pw;
    int[] cnt;

    void solve(int n, char[] a, char[] b) {
        for (int i = 1; i <= n; i++) {
            int diff = (b[i - 1] - a[i - 1] + 26) % 26;
            cnt[i] = cnt[i - 1];
            if (i % 2 == 0) {
                cnt[i] += diff;
            } else {
                cnt[i] -= diff;
            }
        }
        // tr("cnt", cnt);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), q = fs.nextInt();
            char[] a = fs.next().toCharArray();
            char[] b = fs.next().toCharArray();
            cnt = new int[n + 1];
            solve(n, a, b);
            while (q-- > 0) {
                int l = fs.nextInt(), r = fs.nextInt();
                int rem = (cnt[r] - cnt[l - 1]) % 26;
                // tr("rem", rem);
                pr(rem == 0 ? "Yes" : "No");
            }
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
        new IncreaseConsecutiveCharacters().run();
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
