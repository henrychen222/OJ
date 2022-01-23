/**
 * 11/22/21 afternoon
 * https://codeforces.com/contest/1612/problem/B
 */
package codeforce.ecf.r117;

import java.util.*;
import java.io.*;

public class B {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1612/submission/136547292
    void solve(int n, int A, int B) {
        int middle = n / 2;
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
        // tr(A, B, middle);
        Set<Integer> se = new HashSet<>();
        // find >= a
        se.add(A);
        a.add(A);
        for (int i = B + 1; i <= n && a.size() < middle; i++) {
            if (se.contains(i)) continue;
            se.add(i);
            a.add(i);
        }
        // tr("a", a);
        for (int i = A + 1; i < B && a.size() < middle; i++) {
            if (se.contains(i)) continue;
            se.add(i);
            a.add(i);
        }
        // tr("a", a);
        for (int i = 1; i <= n; i++) {
            if (!se.contains(i)) b.add(i);
        }
        // tr(a, b);
        if (a.size() != middle || b.size() != middle) {
            pr(-1);
            return;
        }
        boolean ok = test(a, b, A, B);
        if (ok) {
            a.addAll(b);
            output(a);
        } else {
            pr(-1);
        }
    }

    void output(List<Integer> l) {
        for (int x : l) {
            pw.print(x + " ");
        }
        pr("");
    }

    boolean test(List<Integer> small, List<Integer> large, int min, int max) {
        int res = Integer.MAX_VALUE;
        for (int x : small) res = Math.min(x, res);
        if (res != min) return false;
        res = Integer.MIN_VALUE;
        for (int x : large) res = Math.max(x, res);
        if (res != max) return false;
        return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), a = fs.nextInt(), b = fs.nextInt();
            solve(n, a, b);
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

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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
