// 09/19/21 evening
package atcoder.arc.r126.A;

import java.util.*;
import java.io.*;

class Main2 {

    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/arc126/submissions/26002227 81ms
    /**
     *  reference
     *  https://atcoder.jp/contests/arc126/submissions/25984171
     *  https://atcoder.jp/contests/arc126/submissions/25984086
     */
    void solve(long n2, long n3, long n4) {
        long res = 0;
        long n6 = n3 / 2;
        long used = Math.min(n6, n4); // 3 3 4
        n6 -= used;
        n4 -= used;
        res += used;

        used = Math.min(n2 / 2, n6);  // 2 2 3 3
        n2 -= 2 * used;
        n6 -= used;
        res += used;

        used = Math.min(n2, (n4 * 4 + n2 * 2) / 10); // 2 2 2 2 2
        res += used;
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long N2 = fs.nextLong();
            long N3 = fs.nextLong();
            long N4 = fs.nextLong();
            solve(N2, N3, N4);
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
        new Main2().run();
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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