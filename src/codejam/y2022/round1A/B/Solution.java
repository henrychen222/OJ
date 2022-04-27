/**
 * 04/08/22 evening
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000877ba5/0000000000aa8fc1
 */
package codejam.y2022.round1A.B;

import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter pw;
    FastScanner fs;

    // Accepted  04/26/22 evening
    // reference: tourist
    void solve(int n) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) a.add((1 << Math.min(29, i)) + Math.max(i - 29, 0));
        outputL(a);
        for (int i = 0; i < n; i++) a.add(fs.nextInt());
        Collections.sort(a, Collections.reverseOrder());
        // Collections.sort(a);
        int d = 0;
        List<Integer> b = new ArrayList<>();
        for (int x : a) {
            if (d >= 0) {
                b.add(x);
                d -= x;
            } else {
                d += x;
            }
        }
        outputL(b);
    }

    void outputL(List<Integer> l) {
        for (int e : l) {
            pw.print(e + " ");
            pw.flush();
        }
        pr("");
        pw.flush();
    }

    /////////////////////////////////////////////////////////////////
    // don't know
    void solve1(int n) {
        int[] a = new int[n], b = new int[n];
        int max = 2 * n;
        for (int v = 1, i = 0; v < max; v += 2, i++) a[i] = v;
        for (int v = 2, i = 0; v <= max; v += 2, i++) b[i] = v;
        outputA(a);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    boolean test(int[] a, int[] b) {
        long sumA = 0, sumB = 0;
        for (int x : a) sumA += x;
        for (int x : b) sumB += x;
        return sumA == sumA;
    }

    private void run() {
        // read_write_file(); // comment this before submission
        fs = new FastScanner();
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
        new Solution().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}