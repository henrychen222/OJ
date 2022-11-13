/**
 * 11/05/22 morning
 * https://www.acwing.com/problem/content/4718/
 */
package acwing.r76.C;

import java.util.*;
import java.io.*;

/*
 5
 <>>>
 */
class Main {
    static PrintWriter pw;

    // Accepted
    // reference: https://www.acwing.com/solution/content/147416/
    void solve(int n, char[] s) {
        int[] a = new int[n];
        Arrays.fill(a, 1);
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '>') {
            } else if (s[i] == '<') {
                a[i + 1] = a[i] + 1;
            } else {
                a[i + 1] = a[i];
            }
        }
        for (int i = n - 2; i >= 0; --i) {
            if (s[i] == '>') {
                a[i] = Math.max(a[i], a[i + 1] + 1);
            } else if (s[i] == '<') {
            } else {
                a[i] = a[i + 1];
            }
        }
        outputA(a);
    }

    // WA
    void solve1(int n, char[] s) {
        int[] a = new int[n];
        a[0] = 1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '>') {
                a[i + 1] = a[i] - 1;
            } else if (s[i] == '<') {
                a[i + 1] = a[i] + 1;
            } else {
                a[i + 1] = a[i];
            }
        }
        int min = Arrays.stream(a).min().getAsInt();
        if (min < 1) {
            int add = 1 - min;
            for (int i = 0; i < n; i++) a[i] += add;
        }
        outputA(a);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        char[] s = fs.next().toCharArray();
        solve(n, s);
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
        new Main().run();
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