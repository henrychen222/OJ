/**
 * 06/29/23 morning 08/31/23 evening completed
 * https://codeforces.com/contest/1845/problem/0
 */
package codeforce.ecf.y2023.r151;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1845/submission/221261049
    // reference: https://codeforces.com/blog/entry/117791
    void solve(int n, int k, int x) {
        int[] res;
        if (x != 1) {
            res = new int[n];
            Arrays.fill(res, 1);
        } else if (k == 1 || (k == 2 && n % 2 != 0)) {
            pr("NO");
            return;
        } else {
            res = new int[n / 2];
            Arrays.fill(res, 2);
            if (n % 2 != 0) res[0] = 3;
        }
        pr("YES");
        pr(res.length);
        outputA(res);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    ////////////////////////////////////////////////////////////////
    void solve1(int n, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (k == 1 && x == 1) {
            pr("NO");
            return;
        }
        int down = x == 1 ? 2 : 1;
        while (n > 0) {
            n -= down;
            res.add(down);
        }
        // tr(n, res);
        if (n == 0) {
            pr("YES");
            pr(res.size());
            outputL(res);
        } else {
            pr("NO");
        }
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
            int[] a = fs.readArray(3);
            solve(a[0], a[1], a[2]);
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
