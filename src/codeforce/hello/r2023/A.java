/**
 * 01/03/22 morning
 * https://codeforces.com/contest/1779/problem/A
 */
package codeforce.hello.r2023;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    // Accepted
    // reference: Tlatoani
    void solve(int n, char[] s) {
        Set<Character> se = new HashSet<>();
        for (char c : s) se.add(c);
        if (se.size() == 1) {
            pr(-1);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (s[i] == 'R') {
                pr(i);
                return;
            }
        }
    }

    void solve1(int n, char[] s) {
        int[] f = new int[n];
        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'R') {
                f[i] = i + a;
                a++;
            } else {
                f[i] = b;
                b++;
            }
        }
        tr(f);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char[] s = fs.next().toCharArray();
            solve(n, s);
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
        new A().run();
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