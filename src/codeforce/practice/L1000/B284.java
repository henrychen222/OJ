/**
 * 11/05/21 evening
 * https://codeforces.com/problemset/problem/284/B
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class B284 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/284/134446925
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        char[] a = fs.next().toCharArray();
        Set<Integer> I = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == 'I') I.add(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != 'F') {
                if (allOtherOk(a, I, i)) res++;
            }
        }
        pr(res);
    }

    boolean allOtherOk(char[] a, Set<Integer> s, int i) {
        for (int idx : s) {
            if (idx == i) continue;
            if (a[idx] == 'A' || a[idx] == 'F') continue;
            return false;
        }
        return true;
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
        new B284().run();
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
