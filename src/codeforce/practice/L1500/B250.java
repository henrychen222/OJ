/**
 * 05/04/26 morning
 * https://codeforces.com/problemset/problem/250/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B250 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/250/373533191
    void solve(String ss) {
        String[] a = ss.split(":", -1); // no trailing end
        int n = a.length;
//        tr("a", a, n);
        Deque<String> res = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String s = a[i];
            if (s.isEmpty()) {
                if (i - 1 >= 0 && !a[i - 1].isEmpty() && i + 1 < n && !a[i + 1].isEmpty()) { // find :: (inside)
                    int miss = 8 - (n - 1);
                    while (miss-- > 0) res.add("0000");
                }
            } else {
                if (s.length() < 4) {
                    s = "0".repeat(4 - s.length()) + s;
                }
                res.add(s);
            }
        }
//        tr(res, res.size());
        if (res.size() < 8) {
            int miss = 8 - res.size();
            if (a[n - 1].isEmpty()) { // recover :: in the end
                for (int cnt = 0; cnt < miss; cnt++) res.add("0000");
            } else if (a[0].isEmpty()) { // recover :: in the front
                for (int cnt = 0; cnt < miss; cnt++) res.addFirst("0000");
            }
        }
        pr(String.join(":", res));
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        for (int i = 0; i < n; i++) solve(fs.next());
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
        new B250().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) try {
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