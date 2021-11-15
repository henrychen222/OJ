/**
 * 11/11/21 morning
 * https://codeforces.com/problemset/problem/893/B
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

// Accepted --- https://codeforces.com/problemset/submission/893/135003401
public class B893 {

    static PrintWriter pw;

    /*
         1            1       (2 ^ 0)
         110          6       (2 ^ 2 + 2 ^ 1)
         11100        28      (2 ^ 4 + 2 ^ 2)
         1111000      120     (2 ^ 6 + 2 ^ 3)
         111110000    496     (2 ^ 8 + 2 ^ 4)
     */
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();
        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
        for (int k = 1; ; k++) {
            int one = k, zero = k - 1;
            int r = zero, l = r + one - 1; // 2 ^ l + 2 ^ (l + 1) + .... + 2 ^ r;
            int a1 = (int) Math.pow(2, r), n = one;
            int sum = GeometricSequence(a1, n, 2);
            // tr("one", one, "zero", zero, "l", l, "r", r, "sum", sum);
            if (sum >= N) {
                if (sum == N) ts.add(sum);
                break;
            }
            ts.add(sum);
        }
        // tr(ts);
        for (int res : ts) {
            if (N % res == 0) { // shit here? why   reference: cuiaoxiang
                pr(res);
                return;
            }
        }
    }

    int GeometricSequence(int a1, int n, int q) {
        return (int) (a1 * (1 - Math.pow(q, n)) / (1 - q));
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new B893().run();
        pw.close();
    }

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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
