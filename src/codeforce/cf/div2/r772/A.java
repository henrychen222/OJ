/**
 * 02/20/22 moring
 * https://codeforces.com/contest/1635/problem/0
 */
package codeforce.cf.div2.r772;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    /*
     [6, 6] -> [0, 6]
     [3, 5, 6] -> [3, 5, 4]
     */
    // WA
    void solve1(int n, int[] a) {
        test();
        long sum = 0, one = 0, remove = 0;
        List<Integer> odd = new ArrayList<>();
        for (int x : a) {
            if (x == 1) one++;
            if (x != 1 && x % 2 != 0) odd.add(x);
            sum += x;
        }
        Collections.sort(odd);
        for (int i = odd.size() - 1; i >= 0 && one > 0; i--, one--) {
            remove += odd.get(i);
        }
        pr(sum - remove);
    }

    // Pretests passed
    void solve(int n, int[] a) {
        // test();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum |= a[i];
        }
        pr(sum);
    }

    void test() {
        tr(3 | 0, 3 | 1, 3 | 2, 3 | 4, 3 | 5, 3 | 6, 3 | 7, 3 | 8, 3 | 9, 3 | 10, 3 | 11, 3 | 12);
        tr(4 | 0, 4 | 1, 4 | 2, 4 | 4, 4 | 5, 4 | 6, 4 | 7, 4 | 8, 4 | 9);
        tr(1 | 2, 1 | 3, 1 | 4, 1 | 5, 1 | 6, 1 | 7, 1 | 8, 1 | 9, 1 | 10, 1 | 11, 1 | 12, 1 | 13);

        tr(3 | 3, 15 | 16, 6 | 6, 8 | 6);
        tr(2 | 3, 14 | 16, 6 | 6, 5 | 6);
        tr(2 | 3, 2 | 16, 6 | 6, 3 | 6);
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


