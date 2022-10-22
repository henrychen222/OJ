/**
 * 05/24/22 noon
 * https://codeforces.com/problemset/problem/522/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B522 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/522/158322255
    void solve(int n, int[][] pixel) {
        long totW = 0;
        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            totW += pixel[i][0];
            if (!m.containsKey(pixel[i][1])) m.put(pixel[i][1], new ArrayList<>());
            m.get(pixel[i][1]).add(i);
        }
        // tr(m);
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            long restW = totW - pixel[i][0];
            for (int h : m.keySet()) {
                List<Integer> ih = m.get(h);
                if (ih.size() >= 2 || ih.get(0) != i) { // max h
                    res[i] = restW * h;
                    break;
                }
            }
        }
        outputA(res);
    }

    void outputA(long[] a) {
        for (long e : a) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] pixel = new int[n][];
        for (int i = 0; i < n; i++) pixel[i] = fs.readArray(2);
        solve(n, pixel);
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
        new B522().run();
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