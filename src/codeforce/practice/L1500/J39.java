/**
 * 06/13/25 night
 * https://codeforces.com/problemset/problem/39/J
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class J39 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/39/324354807
    // reference: https://codeforces.com/blog/entry/786
    void solve(String s, String t) {
        String[] a = {s, t};
        String lcp = LCP(a), lcs = LCS(a);
//        tr(lcp, lcs);
        int n = s.length(), l = lcp.length(), r = lcs.length();
        if (l + 1 < n - r) {
            pr(0);
            return;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = Math.max(n - r, 1); i <= Math.min(l + 1, n); i++) res.add(i);
        pr(res.size());
        outputL(res);
    }

    // https://www.geeksforgeeks.org/dsa/longest-common-prefix-using-sorting/
    String LCP(String[] a) { // longest common prefix
        Arrays.sort(a);
        String first = a[0], last = a[a.length - 1];
        int minLen = Math.min(first.length(), last.length());
        int i = 0;
        while (i < minLen && first.charAt(i) == last.charAt(i)) i++;
        return first.substring(0, i);
    }

    // https://rosettacode.org/wiki/Longest_common_suffix
    String LCS(String[] a) { // longest common suffix
        int min = Integer.MAX_VALUE;
        for (String s : a) min = Math.min(min, s.length());
        for (int i = 1; i <= min; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[0].charAt(a[0].length() - i) != a[j].charAt(a[j].length() - i)) {
                    return a[0].substring(a[0].length() - i + 1);
                }
            }
        }
        return a[0].substring(a[0].length() - min);
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        String s = fs.next(), t = fs.next();
        solve(s, t);
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
        new J39().run();
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
