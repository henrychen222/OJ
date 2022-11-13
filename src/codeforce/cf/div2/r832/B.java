/**
 * 11/04/22 afternoon
 * https://codeforces.com/contest/1747/problem/B
 */
package codeforce.cf.div2.r832;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    /*
     BANBANBAN -> BNNBAABAN -> BNNBNABAA
     */
    // Accepted
    void solve(int n) {
        char[] s = "BAN".repeat(n).toCharArray();
        TreeSet<Integer> A = new TreeSet<>(), N = new TreeSet<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 'A') {
                A.add(i + 1);
            } else if (s[i] == 'N') {
                N.add(i + 1);
            }
        }
        List<int[]> res = new ArrayList<>();
        while (A.first() < N.last()) {
            int fa = A.pollFirst(), ln = N.pollLast();
            A.add(ln);
            N.add(fa);
            res.add(new int[]{fa, ln});
        }
        pr(res.size());
        for (int[] e : res) pr(e[0] + " " + e[1]);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            solve(n);
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