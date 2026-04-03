/**
 * 06/12/25 night
 * https://codeforces.com/problemset/problem/31/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B31 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/31/324226958
    void solve(char[] s) {
        List<String> d = new ArrayList<>();
        StringBuilder sb = new StringBuilder(), res = new StringBuilder();
        for (char c : s) { // cut by @
            if (c == '@') {
                d.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        d.add(sb.toString());
//        tr(d);
        if (d.size() <= 1 || d.getFirst().isEmpty() || d.getLast().isEmpty()) {
            pr("No solution");
            return;
        }
        for (int i = 1; i < d.size() - 1; i++) {
            if (d.get(i).length() < 2) {
                pr("No solution");
                return;
            }
        }
        res.append(d.get(0));
        for (int i = 1; i < d.size() - 1; i++) {
            res.append("@");
            res.append(d.get(i).charAt(0));
            res.append(",");
            res.append(d.get(i).substring(1));
        }
//        tr(res);
        res.append("@");
        res.append(d.getLast());
        pr(res);
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
        new B31().run();
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
