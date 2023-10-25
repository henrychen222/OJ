/**
 * 08/24/23 morning
 * https://codeforces.com/contest/1862/problem/B
 */
package codeforce.cf.div3.y2023.r894;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] b) {
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (b[i - 1] > b[i]) {
                a.add(b[i - 1]);
                a.add(b[i]);
            } else {
                a.add(b[i - 1]);
            }
        }
        if (a.size() < 2 * n) a.add(b[n - 1]);
        // tr(a, test(a), Arrays.equals(b, test(a)));
        pr(a.size());
        outputL(a);
    }

    int[] test(List<Integer> a) {
        List<Integer> b = new ArrayList<>();
        b.add(a.get(0));
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i - 1) <= a.get(i)) {
                // tr(a[i-1], a[i]);
                b.add(a.get(i));
            }
        }
        int[] res = new int[b.size()];
        int p = 0;
        for (int i = 0; i < b.size(); i++) res[p++] = b.get(i);
        return res;
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] b = fs.readArray(n);
            solve(n, b);
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