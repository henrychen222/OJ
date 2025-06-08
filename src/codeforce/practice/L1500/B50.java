/**
 * 01/13/25 afternoon
 * https://codeforces.com/problemset/problem/50/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B50 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/50/300889694
    void solve(char[] s) {
        var m = counter_value_in_indexA_in(s);
        long res = 0;
        for (char c : m.keySet()) {
            var a = m.get(c);
            res += (long) a.size() * a.size();
        }
        pr(res);
    }

    Map<Character, ArrayList<Integer>> counter_value_in_indexA_in(char[] s) {
        Map<Character, ArrayList<Integer>> m = new HashMap<>();
        for (int i = 0; i < s.length; i++) m.computeIfAbsent(s[i], x -> new ArrayList<>()).add(i);
        return m;
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        char[] s = fs.next().toCharArray();
        solve(s);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new B50().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignored) {
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
