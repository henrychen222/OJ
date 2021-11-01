/**
 * 10/31/21 night
 * https://codeforces.com/contest/120/problem/C
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class C120 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/120/submission/133891744
    private void run() {
        read_write_file(); // keep this for input output problem
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        int[] a = fs.readArray(n);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        for (int x : a) pq.add(new int[]{x, 0});
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            // tr("cur", cur);
            if (cur[0] < k || cur[1] == 3) {
                cnt += cur[0];
            } else {
                cur[0] -= k;
                cur[1]++;
                pq.add(cur);
            }
        }
        pr(cnt);
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
            pw = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT)));
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws IOException {
        new C120().run();
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
