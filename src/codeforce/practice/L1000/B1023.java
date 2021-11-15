/**
 * 11/11/21 morning
 * https://codeforces.com/problemset/problem/1023/B
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class B1023 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/1023/134991081
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        long n = fs.nextLong(), k = fs.nextLong();
        long dis = -1;
        if (n >= k) {
            dis = k;
            pr(dis % 2 == 0 ? dis / 2 - 1 : dis / 2);
        } else {
            long x = k - n;
            if (x > n) {
                pr(0);
                return;
            }
            dis = Math.abs(x - n) + 1;
            // tr(x, n, dis);
            pr(dis / 2);
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new B1023().run();
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
