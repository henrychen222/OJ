/**
 * 06/26/23 evening
 * https://codeforces.com/problemset/problem/334/B
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class B334 {
    static PrintWriter pw;

    void solve(int[][] g) {
       for(int i = 0; i < 8; i++) {
           for(int j = i+1; j < 8; j++) {
               for(int k = j+1; k < 8; k++) {
                   if (g[i][0] < g[j][0] && g[j][0] < g[k][0]) {
                       for(int a = 0; a<8;a++) {

                       }
                   }
               }
           }
       }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[][] g = new int[8][];
        for (int i = 0; i < 8; i++) g[i] = fs.readArray(2);
        solve(g);
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
        new B334().run();
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