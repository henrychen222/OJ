/**
 * 07/10/26 morning
 * https://codeforces.com/problemset/problem/278/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B278 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/278/381973730
    // reference: https://codeforces.com/blog/entry/6815
    void solve(String[] a) {
        Set<Character> se = new HashSet<>();
        for (String s : a) {
            for (int i = 0; i < s.length(); i++) se.add(s.charAt(i));
        }
        // check length of 1
        for (char i = 'a'; i <= 'z'; i++) {
            if (!se.contains(i)) {
                pr(i);
                return;
            }
        }
        // check length of 2
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                String cur = "" + i + j;
                boolean ok = true;
                for (String s : a) {
                    if (s.contains(cur)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    pr(cur);
                    return;
                }
            }
        }
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) a[i] = fs.next();
        solve(a);
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
        new B278().run();
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