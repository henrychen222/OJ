/**
 * 10/17/22 evening
 * https://codeforces.com/problemset/problem/56/B
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class B56 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/56/176819902
    void solve(int n, int[] a) {
        if (n == 1) {
            pr(0 + " " + 0);
            return;
        }
        String s = "";
        char c = a[1] > a[0] ? 'I' : 'D';
        s += c;
        List<Integer> change = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            c = a[i] > a[i - 1] ? 'I' : 'D';
            char pre = s.charAt(s.length() - 1);
            if (pre != c) {
                s += c;
                change.add(i);
            }
        }
        // tr(s, change);
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i + 1;
        int[] b = new int[n];
        int l = -1, r = -1;
        if (s.equals("IDI") || s.equals("DID")) {
            l = change.get(0);
            r = change.get(1);
            for (int i = 0; i < l - 1; i++) b[i] = a[i];
            for (int i = l - 1, j = r - 1; i < r; i++, j--) b[i] = a[j];
            for (int i = r; i < n; i++) b[i] = a[i];
            pr(Arrays.equals(p, b) ? (l + " " + r) : (0 + " " + 0));
        } else if (s.equals("ID")) {
            l = change.get(0);
            for (int i = 0; i < l - 1; i++) b[i] = a[i];
            for (int i = l - 1, j = n - 1; i < n; i++, j--) b[i] = a[j];
            pr(Arrays.equals(p, b) ? (l + " " + n) : (0 + " " + 0));
        } else if (s.equals("DI")) {
            l = change.get(0);
            for (int i = 0, j = l - 1; i < l - 1; i++, j--) b[i] = a[j];
            for (int i = l - 1; i < n; i++) b[i] = a[i];
            pr(1 + " " + change.get(0));
        } else if (s.equals("D")) {
            pr(1 + " " + n);
        } else {
            pr(0 + " " + 0);
        }
    }

    Data cutMaxConsecutiveWithIndex_de(int[] a) {
        List<int[]> d = new ArrayList<>();
        List<int[]> ia = new ArrayList<>();
        int start = 0, n = a.length;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i + 1] > a[i]) {
                d.add(Arrays.copyOfRange(a, start, i + 1));
                ia.add(new int[]{start, i});
                start = i + 1;
            }
        }
        d.add(Arrays.copyOfRange(a, start, n));
        ia.add(new int[]{start, n - 1});
        return new Data(d, ia);
    }

    Data cutMaxConsecutiveWithIndex_inc(int[] a) {
        List<int[]> d = new ArrayList<>();
        List<int[]> ia = new ArrayList<>();
        int start = 0, n = a.length;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i + 1] < a[i]) {
                d.add(Arrays.copyOfRange(a, start, i + 1));
                ia.add(new int[]{start, i});
                start = i + 1;
            }
        }
        d.add(Arrays.copyOfRange(a, start, n));
        ia.add(new int[]{start, n - 1});
        return new Data(d, ia);
    }

    class Data {
        List<int[]> d;
        List<int[]> ia;

        Data(List<int[]> data, List<int[]> indexA) {
            d = data;
            ia = indexA;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, a);
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
        new B56().run();
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