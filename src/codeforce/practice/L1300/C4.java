/**
 * 08/28/22 evening
 * https://codeforces.com/problemset/problem/4/C
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class C4 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/4/170015985
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = fs.next();
            if (m.containsKey(s)) {
                int occ = m.get(s);
                occ++;
                m.put(s, occ);
                pr(s + occ);
            } else {
                m.put(s, 0);
                pr("OK");
            }
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
        new C4().run();
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