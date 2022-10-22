/**
 * 07/06/22 night
 * https://codeforces.com/problemset/problem/5/B
 */
package codeforce.practice.L1200;

import java.util.*;
import java.io.*;

public class B5 {
    static PrintWriter pw;

    void solve(List<String> a) {
        int max = 0;
        for (String e : a) max = Math.max(max, e.length());
        max += 2;
        String first_last = "*".repeat(max);
        pr(first_last);
        int f = 0;
        for (String e : a) {
            int use = max - 2 - e.length(), h = use / 2;
            String less = " ".repeat(h), more = " ".repeat(h + 1);
            // tr(e, h, max, less.length(), more.length());
            String s;
            if (use % 2 == 0) {
                s = "*" + less + e + less + "*";
            } else {
                if (f == 0) {
                    s = "*" + less + e + more + "*";
                } else {
                    s = "*" + more + e + less + "*";
                }
                f ^= 1;
            }
            pr(s);
        }
        pr(first_last);
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        List<String> a = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            String s = fs.nextLine();
            if (s == null) continue;
            a.add(s);
        }
        solve(a);
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
        new B5().run();
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

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}