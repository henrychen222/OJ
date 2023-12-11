/**
 * 11/27/23 evening
 * https://codeforces.com/problemset/problem/45/I
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class I45 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/45/234653583
    void solve(int[] a) {
        if (Arrays.stream(a).allMatch(x -> x == 0) || a.length == 1) { // 全0 或者只有1个
            outputA(a);
            return;
        }
        a = Arrays.stream(a).filter(x -> x != 0).toArray();
        int n = a.length;
        List<int[]> neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                neg.add(new int[]{i, Math.abs(a[i])});
            }
        }
        if (neg.size() % 2 == 0) {
            outputA(a);
        } else { // 负数里面拿掉绝对值最小的
            Collections.sort(neg, (x, y) -> Integer.compare(x[1], y[1]));
            // tr(neg);
            int toRemoveIdx = neg.get(0)[0];
            boolean hasAnswer = false;
            for (int i = 0; i < n; i++) {
                if (i != toRemoveIdx) {
                    hasAnswer = true;
                    pw.print(a[i] + " ");
                }
            }
            if (!hasAnswer) pr(0);
        }
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(a);
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
        new I45().run();
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
