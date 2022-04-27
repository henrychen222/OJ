/**
 * 03/06/22 night
 * https://codeforces.com/problemset/problem/47/B
 */
package codeforce.practice.L1200;

import java.util.*;
import java.io.*;

public class B47 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/47/submission/148674915
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s1 = fs.next();
        String s2 = fs.next();
        String s3 = fs.next();
        Map<String, Character> m1 = op(s1), m2 = op(s2), m3 = op(s3);
        // tr(m1, m2, m3);
        Map<String, Character> merge = new HashMap<>();
        for (String k : m1.keySet()) {
            char c = m1.get(k);
            if ((m2.containsKey(k) && m2.get(k) != c) || (m3.containsKey(k) && m3.get(k) != c)) {
                pr("Impossible");
                return;
            }
            merge.put(k, c);
        }
        for (String k : m2.keySet()) {
            char c = m2.get(k);
            if ((m1.containsKey(k) && m1.get(k) != c) || (m3.containsKey(k) && m3.get(k) != c)) {
                pr("Impossible");
                return;
            }
            merge.put(k, c);
        }
        for (String k : m3.keySet()) {
            char c = m3.get(k);
            if ((m1.containsKey(k) && m1.get(k) != c) || (m2.containsKey(k) && m2.get(k) != c)) {
                pr("Impossible");
                return;
            }
            merge.put(k, c);
        }
        // tr(merge);
        if (merge.size() == 1) {
            pr("Impossible");
        } else if (merge.size() == 2) {
            Character AB = null, AC = null, BC = null;
            if (merge.containsKey("AB")) AB = merge.get("AB");
            if (merge.containsKey("AC")) AC = merge.get("AC");
            if (merge.containsKey("BC")) BC = merge.get("BC");
            if (AB != null && AC != null) { // continue here
                if (AB == 'A') {
                    if (AC == 'C') { // A > B   C > A
                        pr("BAC");
                    } else {  // A > B   A > C
                        pr("Impossible");
                    }
                } else {
                    if (AC == 'C') { // A < B   A < C
                        pr("Impossible");
                    } else {  // A < B   C < A
                        pr("CAB");
                    }
                }
            } else if (AB != null && BC != null) {
                if (AB == 'A') {
                    if (BC == 'B') { // A > B   B > C
                        pr("CBA");
                    } else {  // A > B  C > B
                        pr("Impossible");
                    }
                } else {
                    if (BC == 'B') { // B > A  B > C
                        pr("Impossible");
                    } else {  // B > A   C > B
                        pr("ABC");
                    }
                }
            } else if (AC != null && BC != null) {
                if (AC == 'A') {
                    if (BC == 'B') { // A > C   B > C
                        pr("Impossible");
                    } else {  // A > C  C > B
                        pr("BCA");
                    }
                } else {
                    if (BC == 'B') { // C > A  B > C
                        pr("ACB");
                    } else {  // C > A   C > B
                        pr("Impossible");
                    }
                }
            }
        } else if (merge.size() == 3) {
            Character AB = merge.get("AB"), AC = merge.get("AC"), BC = merge.get("BC");
            if (AB == 'A') {
                if (AC == 'A') {
                    if (BC == 'B') { // A > B   A > C   B > C
                        pr("CBA");
                    } else { // A > B   A > C   C > B
                        pr("BCA");
                    }
                } else {
                    if (BC == 'B') { // A > B   C > A   B > C
                        pr("Impossible");
                    } else { // A > B   C > A  C > B
                        pr("BAC");
                    }
                }
            } else {
                if (AC == 'A') {
                    if (BC == 'B') { // B > A   A > C   B > C
                        pr("CAB");
                    } else { // B > A   A > C   C > B
                        pr("Impossible");
                    }
                } else {
                    if (BC == 'B') { // B > A   C > A   B > C
                        pr("ACB");
                    } else { // B > A   C > A  C > B
                        pr("ABC");
                    }
                }
            }
        }
    }

    Map<String, Character> op(String s) {
        char[] a = s.toCharArray();
        Map<String, Character> m = new HashMap<>();
        if (a[0] == 'A' && a[2] == 'B') {
            if (a[1] == '<') {
                m.put("AB", 'B');
            } else {
                m.put("AB", 'A');
            }
        }
        if (a[0] == 'B' && a[2] == 'A') {
            if (a[1] == '<') {
                m.put("AB", 'A');
            } else {
                m.put("AB", 'B');
            }
        }
        if (a[0] == 'A' && a[2] == 'C') {
            if (a[1] == '<') {
                m.put("AC", 'C');
            } else {
                m.put("AC", 'A');
            }
        }
        if (a[0] == 'C' && a[2] == 'A') {
            if (a[1] == '<') {
                m.put("AC", 'A');
            } else {
                m.put("AC", 'C');
            }
        }
        if (a[0] == 'B' && a[2] == 'C') {
            if (a[1] == '<') {
                m.put("BC", 'C');
            } else {
                m.put("BC", 'B');
            }
        }
        if (a[0] == 'C' && a[2] == 'B') {
            if (a[1] == '<') {
                m.put("BC", 'B');
            } else {
                m.put("BC", 'C');
            }
        }
        return m;
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
        new B47().run();
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}