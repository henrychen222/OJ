/**
 * 04/11/26 night
 * https://codeforces.com/problemset/problem/114/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B114 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/114/370761675
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        String[] people = new String[n];
        for (int i = 0; i < n; i++) people[i] = fs.next();
        List<List<String>> all = getAllSubsequences(people);
        all.sort((x, y) -> Integer.compare(y.size(), x.size()));
//        tr(all);
        Set<String> conflict = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String x = fs.next(), y = fs.next();
            conflict.add(x + " " + y);
            conflict.add(y + " " + x);
        }
        for (var e : all) {
            boolean ok = true;
            outer:
            for (int i = 0; i < e.size(); i++) {
                for (int j = i + 1; j < e.size(); j++) {
                    if (conflict.contains(e.get(i) + " " + e.get(j))) {
                        ok = false;
                        break outer;
                    }
                }
            }
            if (ok) {
                pr(e.size());
                Collections.sort(e); // lexicographical
                for (String s : e) pr(s);
                return;
            }
        }
    }

    List<List<String>> getAllSubsequences(String[] a) {
        List res = new ArrayList();
        int n = a.length;
        for (int i = 0; i < 1 << n; i++) {
            List<String> l = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    l.add(a[j]);
                }
            }
            res.add(l);
        }
        return res;
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
        new B114().run();
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
