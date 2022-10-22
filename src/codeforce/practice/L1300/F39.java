/**
 * 10/21/22 night
 * https://codeforces.com/problemset/problem/39/F
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class F39 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/39/177418384
    void solve(int n, int m, int k, int[] frogs, int[] mosquitoes) {
        int[][] d = new int[m][];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int smash = 0;
            for (int x : mosquitoes) {
                if (x % frogs[i] == 0) smash++;
            }
            d[i] = new int[]{smash, i + 1};
            min = Math.min(min, smash);
        }
        Arrays.sort(d, (x, y) -> x[0] - y[0]);
        List<Integer> res = new ArrayList<>();
        for (int[] e : d) {
            if (e[0] == min) {
                res.add(e[1]);
            } else {
                break;
            }
        }
        pr(res.size());
        outputL(res);
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt(), k = fs.nextInt();
        int[] frogs = fs.readArray(m), mosquitoes = fs.readArray(k);
        solve(n, m, k, frogs, mosquitoes);
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
        new F39().run();
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