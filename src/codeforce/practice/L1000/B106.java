/**
 * 11/05/21 morning
 * https://codeforces.com/problemset/problem/106/B
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class B106 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/106/134380924
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] g = new int[n][];
        for (int i = 0; i < n; i++) g[i] = fs.readArray(4);
        // tr(g);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[3] - y[3]);
        for (int i = 0; i < n; i++) {
            int speed = g[i][0], ram = g[i][1], hdd = g[i][2], cost = g[i][3];
            boolean ignore = false;
            for (int[] compare : g) {
                int cs = compare[0], cr = compare[1], ch = compare[2];
                if (speed < cs && ram < cr && hdd < ch) {
                    ignore = true;
                    break;
                }
            }
            if (!ignore) pq.add(new int[]{speed, ram, hdd, cost, i + 1});
        }
        pr(pq.poll()[4]);
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
        new B106().run();
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