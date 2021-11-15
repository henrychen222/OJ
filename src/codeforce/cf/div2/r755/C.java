/**
 * 11/13/21 night
 * https://codeforces.com/contest/1589/problem/0
 */
package codeforce.cf.div2.r755;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1589/submission/135403138
    // first version is close
    void solve(int n, int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            int diff = b[i] - a[i];
            if (diff >= 2 || diff < 0) { // forget to consider b[i] should always large than a[i] (diff >= 0)
                pr("NO");
                return;
            }
        }
        pr("YES");
    }

    // WA
    void solve3(int n, int[] a, int[] b) {
        int[][] possible = new int[n][];
        for (int i = 0; i < n; i++) possible[i] = new int[]{a[i], a[i] + 1};
        Set<Integer> se = new HashSet<>();
        for (int x : b) {
            boolean find = false;
            for (int i = 0; i < n; i++) {
                int[] e = possible[i];
                if (x == e[0] && !se.contains(i)) {
                    se.add(i);
                    find = true;
                    break;
                } else if (x == e[1] && !se.contains(i)) {
                    se.add(i);
                    find = true;
                    break;
                }
            }
            // tr(x, find, se, possible);
            if (!find) {
                pr("NO");
                return;
            }
        }
        pr("YES");
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // Pretests passed --- WA on System test 24
    void solve2(int n, int[] a, int[] b) {
        int[][] possible = new int[n][];
        for (int i = 0; i < n; i++) possible[i] = new int[]{a[i], a[i] + 1};
        for (int x : b) {
            boolean find = false;
            for (int[] e : possible) {
                if (x == e[0] || x == e[1]) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                pr("NO");
                return;
            }
        }
        pr("YES");
    }

    // Pretests passed --- Hacked
    void solve1(int n, int[] a, int[] b) {
        // tr(n, a, b);
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            if (Math.abs(a[i] - b[i]) >= 2) {
                pr("NO");
                return;
            }
        }
        pr("YES");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n), b = fs.readArray(n);
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
        new C().run();
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


//    TreeMap<Integer, Integer> ma = new TreeMap<>();
//    TreeMap<Integer, Integer> mb = new TreeMap<>();
//        for (int i = 0; i < n; i++) {
//        ma.put(a[i], ma.getOrDefault(a[i], 0) + 1);
//        mb.put(b[i], mb.getOrDefault(b[i], 0) + 1);
//        }
//        tr(ma);
//        tr(mb);
//        long same = 0;
//        for (int xa : ma.keySet()) {
//        int aocc = ma.get(xa);
//        if (mb.containsKey(xa)) {
//        int bocc = mb.get(xa);
//        same += Math.abs(Math.min(aocc, bocc));
//        }
//        }
//        long diff = n - same;
//        tr("same", same, "diff", diff, "maxAdd", n);
//        pr(diff <= n ? "YES" : "NO");