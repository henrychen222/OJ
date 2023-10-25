/**
 * 09/11/23 evening
 * https://codeforces.com/contest/1867/problem/B
 */
package codeforce.cf.div2.y2023.r897;

import java.util.*;
import java.io.*;

// Pretests passed
public class B {
    static PrintWriter pw;

    /*
     100100011
     000100010

     100000001
     */
    void solve(int n, char[] s) {
        char[] res = new char[n + 1];
        Arrays.fill(res, '0');
        int diffPair = 0, samePair = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s[i] != s[n - 1 - i]) {
                diffPair++;
            } else {
                samePair++;
            }
        }
//        tr(diffPair, samePair);
        int min = diffPair, max;
        if (n % 2 == 0) {
            max = min + 2 * samePair;
            for (int i = min; i <= max; i += 2) res[i] = '1';
        } else {
            max = min + 2 * samePair + 1;
            for (int i = min; i <= max; i++) res[i] = '1';
        }
//        tr(min, max);
//        tr(res);
        pr(new String(res));
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
        new B().run();
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