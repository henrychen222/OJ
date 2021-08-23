/**
 * 07/28/21 morning
 * https://www.codechef.com/COOK131C/problems/CHFPLN
 */

package codechef.contest.cook.c_131;

import java.util.*;
import java.io.*;

// Accepted
class ChefInfinitePlane {

    static PrintWriter pw;

    /*
     4
     1 3  2 2  3 1
     5
     1 4  2 3  3 2  4 1
     7
     1 6  2 5  3 4  4 3  5 2  6 1
     */
    void solve(int n, int[] a) {
        // tr(n, a);
        // tr(calEven(4), calEven(100));
        int[] cnt = new int[100005];
        for (int e : a) cnt[e]++;
        // tr(cnt);
        long res = 0;
        for (int i = 0; i < 100005; i++) {
            if (cnt[i] == 0) continue;
            int maxDivide = i - 1;
            if (maxDivide >= cnt[i]) {
                res += cnt[i];
            } else {
                res += maxDivide;
            }
        }
        pr(res);
    }

//    int calEven(int x) {
//        return (x / 2 - 1) * 2 + 1;
//    }
//
//    int calOdd(int x) {
//        return x - 1;
//    }

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
        new ChefInfinitePlane().run();
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