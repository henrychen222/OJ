/**
 * 01/03/22 morning
 * https://codeforces.com/contest/1779/problem/C
 */
package codeforce.hello.r2023;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted
    // reference: jiangly Tlatoani
    void solve(int n, int m, int[] a) {
        int[] A = new int[m - 1], B = Arrays.copyOfRange(a, m, n);
        int p = 0;
        for (int i = m - 1; i > 0; i--) A[p++] = -a[i];
        // tr(A, B);
        int res = work(A) + work(B);
        pr(res);
    }

    int work(int[] a) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        int res = 0;
        long cur = 0;
        for (int x : a) {
            cur += x;
            pq.add(-x);
            while (cur < 0) {
                res++;
                cur += 2 * pq.poll();
            }
        }
        return res;
    }


    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, m, a);
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
        new C().run();
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