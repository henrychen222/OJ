/**
 * 07/27/23 morning
 * https://codeforces.com/contest/1849/problem/A
 */
package codeforce.ecf.y2023.r152;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    // Accepted
    void solve(int[] a) {
        int cnt = 0;
        while (a[0] > 0 && (a[1] > 0 || a[2] > 0)) {
            a[0]--;
            if (a[1] >= a[2]) {
                a[1]--;
            } else {
                a[2]--;
            }
            cnt++;
        }
        // tr(a);
        if (a[0] == 0) {
            pr(cnt * 2 - 1);
        } else {
            pr(cnt * 2 + 1);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(3);
            solve(a);
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
