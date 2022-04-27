/**
 * 02/18/22 evening
 * https://www.hackerrank.com/challenges/kaprekar-numbers/problem
 */
package hackerrank.easy.s30;

import java.util.*;
import java.io.*;

/*
  1
  99999
  expect:
  1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999
 */
public class Modified_Kaprekar_Numbers {
    static PrintWriter pw;

    // Accepted --- https://www.hackerrank.com/challenges/kaprekar-numbers/submissions/code/256999085
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int p = fs.nextInt(), q = fs.nextInt();
        List<Integer> res = new ArrayList<>();
        if (p == 1) res.add(1);
        for (int i = p; i <= q; i++) {
            if (ok(i)) res.add(i);
        }
        if (res.size() == 0) {
            pr("INVALID RANGE");
            return;
        }
        outputL(res);
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
    }

    boolean ok(int x) {
        int len = (x + "").length();
        long t = (long) x * x;
        String s = t + "";
        int n = s.length();
        for (int i = 1; i < n; i++) {
            String l = s.substring(0, i);
            String r = s.substring(i);
            if (r.length() == len) {
                // tr(l, r, Long.parseLong(l) + Long.parseLong(r) == x);
                if (Long.parseLong(l) + Long.parseLong(r) == x) return true;
            }
        }
        return false;
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
        new Modified_Kaprekar_Numbers().run();
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
