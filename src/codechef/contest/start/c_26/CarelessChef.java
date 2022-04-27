/**
 * 02/16/22 morning
 * https://www.codechef.com/START26C/problems/LOSTSEQ
 */
package codechef.contest.start.c_26;

import java.util.*;
import java.io.*;

class CarelessChef {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] b) {
        int odd = 0, even = 0;
        for (int x : b) {
            if (x % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        // tr(odd, even);
        if (odd % 2 == 0 && even % 2 == 0) {
            pr("YES");
        } else {
            pr("NO");
        }
    }

    // WA
    void solve1(int n, int[] b) {
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            long sum = (long) b[i] + b[2 * n - i - 1];
            // tr(b[i], b[2 * n - i - 1]);
            if (sum % 2 != 0) {
                pr("NO");
                return;
            }
        }
        pr("YES");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] b = fs.readArray(2 * n);
            solve(n, b);
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
        new CarelessChef().run();
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
