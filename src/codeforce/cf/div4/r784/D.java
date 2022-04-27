/**
 * 04/21/22 afternoon
 * https://codeforces.com/contest/1669/problem/D
 */
package codeforce.cf.div4.r784;

import java.util.*;
import java.io.*;

public class D {
    static PrintWriter pw;

    /*
     BRBR -> BRR BBR
     BRRB -> BRB

     RBRB -> RRB  RBB
     RBBR -> RBR
     */
    // Accepted --- https://codeforces.com/contest/1669/submission/154448983
    void solve(int n, String s) {
//        if (n == 1) {
//            pr("NO");
//            return;
//        }
        char[] a = s.toCharArray();
        List<char[]> d = cutMaxConsecutive(a);
        // debugArrayInList(d);
        if (d.size() == 1) {
            if (d.get(0)[0] == 'W') {
                pr("YES");
            } else {
                pr("NO");
            }
            return;
        }
        for (int i = 0; i < d.size(); i++) {
            char[] e = d.get(i);
            if (e[0] != 'W') {
                if (i == 0) {
                    if (d.get(i + 1)[0] == 'W') { // W...
                        pr("NO");
                        return;
                    }
                } else if (i == d.size() - 1) { // ...W
                    if (d.get(i - 1)[0] == 'W') {
                        pr("NO");
                        return;
                    }
                } else { // W...W
                    if (d.get(i - 1)[0] == 'W' && d.get(i + 1)[0] == 'W') {
                        pr("NO");
                        return;
                    }
                }
            }
        }
        pr("YES");
    }

    List<char[]> cutMaxConsecutive(char[] a) {
        List<char[]> d = new ArrayList<>();
        int start = 0, n = a.length;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i + 1] != a[i]) {
                d.add(Arrays.copyOfRange(a, start, i + 1));
                start = i + 1;
            }
        }
        d.add(Arrays.copyOfRange(a, start, n));
        return d;
    }

    void debugArrayInList(List<char[]> l) {
        char[][] res = new char[l.size()][];
        for (int i = 0; i < l.size(); i++) res[i] = l.get(i);
        tr("out", res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            solve(n, s);
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
        new D().run();
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