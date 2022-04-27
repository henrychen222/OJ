/**
 * 02/11/22 moring
 * https://codeforces.com/problemset/problem/427/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B43 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/43/145950394
    void solve(String s1, String s2) {
        Map<Character, Integer> m1 = op(s1), m2 = op(s2);
//        tr(m1);
//        tr(m2);
        for (char c: m2.keySet()) {
            if (!m1.containsKey(c)) {
                pr("NO");
                return;
            }
            int occ1 = m1.get(c), occ2 = m2.get(c);
            if (occ1 < occ2) {
                pr("NO");
                return;
            }
        }
        pr("YES");
    }

    Map<Character, Integer> op(String s) {
        String[] a = s.split(" ");
        Map<Character, Integer> m = new HashMap<>();
        for (String e : a) {
            for (int i = 0; i < e.length(); i++) {
                char c = e.charAt(i);
                m.put(c, m.getOrDefault(c, 0) + 1);
            }
        }
        return m;
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s1 = fs.readLine();
        String s2 = fs.readLine();
        solve(s1, s2);
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
        new B43().run();
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

        String readLine() throws IOException {
            return br.readLine();
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

