/**
 * 04/13/23 evening
 * https://codeforces.com/problemset/problem/797/B
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class B797 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/797/202003065
    void solve(int n, int[] a) {
        long sum = 0;
        List<Integer> neg = new ArrayList<>(), pos = new ArrayList<>();
        List<Long> res = new ArrayList<>();
        for (int x : a) {
            if (x > 0) {
                sum += x;
                pos.add(x);
            } else if (x < 0) {
                neg.add(x);
            }
        }
        if (sum % 2 != 0) {
            pr(sum);
            return;
        }
        Collections.sort(pos);
        for (int x : pos) {
            if (x % 2 != 0) {
                res.add(sum - x);
                break;
            }
        }
        Collections.sort(neg, Collections.reverseOrder());
//        tr(res, neg);
        for (int x : neg) {
            if (x % 2 != 0) {
                res.add(sum + x);
                break;
            }
        }
//        tr(res);
        pr(Collections.max(res));
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, a);
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
        new B797().run();
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