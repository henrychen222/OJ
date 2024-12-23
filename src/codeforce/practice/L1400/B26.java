/**
 * 12/23/24 afternoon (Germain)
 * https://codeforces.com/problemset/problem/26/B
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class B26 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/26/298100606
    void solve(char[] s) {
        int l = 0, r = 0;
        for (char c : s) {
            if (c == ')') {
                if (l > 0) {
                    r++;
                    l--;
                }
            } else {
                l++;
            }
        }
        pr(r * 2);
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
        new B26().run();
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
