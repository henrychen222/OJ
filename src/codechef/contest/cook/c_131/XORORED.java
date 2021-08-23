/**
 * 07/28/21 morning
 * https://www.codechef.com/COOK131C/problems/XORORED
 */

package codechef.contest.cook.c_131;

import java.util.*;
import java.io.*;

class XORORED {

    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] a) {
        // tr(a);
        int min = Integer.MAX_VALUE, max = 0;
        for (int e : a) {
            min = Math.min(min, e);
            max = Math.max(max, e);
        }
//       for (int x = min; x <= max; x++) {
//           // tr(x);
//           long tmp = cal(a, x);
//           // pr(tmp);
//           res = Math.min(res, tmp);
//       }
        long res1 = cal(a, min);
        long res2 = cal(a, max);
        if (res1 < res2) {
            pr(min + " " + res1);
        } else {
            pr(max + " " + res2);
        }
    }

    long cal(int[] a, int x) {
        long res = 0;
        for (int e : a) {
            res |= (e ^ x);
        }
        return res;
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
        new XORORED().run();
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