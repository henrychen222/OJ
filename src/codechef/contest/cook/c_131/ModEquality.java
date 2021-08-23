/**
 * 07/28/21 morning
 * https://www.codechef.com/COOK131C/problems/MODEQUAL
 */

package codechef.contest.cook.c_131;

import java.util.*;
import java.io.*;

class ModEquality {

    static PrintWriter pw;

    // Accepted
    // reference: https://www.codechef.com/viewsolution/49146492
    void solve(int n, int[] a) { // greedy: mod to min value compare with n
        Arrays.sort(a);
        // tr(2147483647 - 2000000000);
        // tr(a);
        boolean ok = true;
        int res1 = 0;
        for (int i = 1; i < n; i++) {
            // tr(a[i], a[0]);
            if (a[i] == a[0]) continue;
            if (1L * a[i] > 1L * a[0] * 2) { // can mod
                res1++;
            } else {
                ok = false; // cannot mod
                break;
            }
        }
        if (ok) {
            pr(res1);
            return;
        }
        pr(n);
    }

    // don't know
    void solve1(int n, int[] a) {
//        tr(5 % 1, 5 % 2, 5 % 3, 5 % 4, 5 % 5);
//        tr(6 % 1, 6 % 2, 6 % 3, 6 % 4, 6 % 5, 6 % 6);
//        tr(7 % 1, 7 % 2, 7 % 3, 7 % 4, 7 % 5, 7 % 6, 7 % 7);
//        tr(8 % 1, 8 % 2, 8 % 3, 8 % 4, 8 % 5, 8 % 6, 8 % 7, 8 % 8);
//        tr(9 % 1, 9 % 2, 9 % 3, 9 % 4, 9 % 5, 9 % 6, 9 % 7, 9 % 8, 9 % 9);
//        tr(10 % 1, 10 % 2, 10 % 3, 10 % 4, 10 % 5, 10 % 6, 10 % 7, 10 % 8, 10 % 9, 10 % 10);
        tr(a);
        Map<Integer, Integer> m = new HashMap();
        // int minModShare = Integer.MAX_VALUE;
        for (int x : a) {
            if (m.containsKey(x)) continue;
            int tmp = maxMod(x);
            m.put(x, tmp);
            // minModShare = Math.min(minModShare, tmp);
        }
        // tr(m);
        int res = n;
        int res1 = 0, res2 = 0, res3 = 0;
        for (int x : a) {
            if (x != 0) res1++;
            if (x != 1) res2++;
            // if (x != minModShare) res3++;
        }
        res = Math.min(res, Math.min(res1, res2));
        pr(res);
    }

    int maxMod(int x) {
        return x % 2 == 0 ? x / 2 - 1 : (x - 1) / 2;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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
        new ModEquality().run();
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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