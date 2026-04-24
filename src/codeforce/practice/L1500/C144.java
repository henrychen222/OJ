/**
 * 04/10/26 morning
 * https://codeforces.com/problemset/problem/144/C
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class C144 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/144/370578349
    void solve(char[] s, char[] p) {
        int n = s.length, m = p.length;
        if (n < m) {
            pr(0);
            return;
        }
        int[] fp = new int[26];
        for (char c : p) fp[c - 'a']++;
        Deque<Character> q = new ArrayDeque<>(); // handle [l, r] with p length
        int[] f = new int[26];
        for (int i = 0; i < m; i++) { // initial
            q.add(s[i]);
            if (s[i] != '?') {
                f[s[i] - 'a']++;
            }
        }
        int res = 0;
        for (int i = m; i < n; i++) {
            // tr(isGood(f, fp), q, p, f, fp);
            if (isGood(f, fp)) res++;
            q.add(s[i]);
            char left = q.removeFirst();
            if (s[i] != '?') {
                f[s[i] - 'a']++;
            }
            if (left != '?') {
                f[left - 'a']--;
            }
        }
        // tr(isGood(f, fp), q, p, f, fp);
        if (isGood(f, fp)) res++; // last
        pr(res);
    }

    boolean isGood(int[] f, int[] fp) { // each character in f <= fp, missed can be replaced with "?"
        for (int i = 0; i < 26; i++) {
            if (f[i] > fp[i]) return false;
        }
        return true;
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        char[] s = fs.next().toCharArray(), p = fs.next().toCharArray();
        solve(s, p);
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
        new C144().run();
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