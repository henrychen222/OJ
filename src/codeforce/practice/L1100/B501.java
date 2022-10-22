/**
 * 05/24/22 noon
 * https://codeforces.com/problemset/problem/501/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B501 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/501/158318722
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int q = fs.nextInt();
        Map<String, String> m = new HashMap<>();
        while (q-- > 0) {
            String s = fs.next(), t = fs.next();
            m.put(s, t);
        }
        while (true) {
            boolean find = false;
            for (String s : m.keySet()) {
                String t = m.get(s);
                if (m.containsKey(t)) {
                    find = true;
                    m.put(s, m.get(t));
                    m.remove(t);
                    break;
                }
            }
            if (!find) break;
        }
        pr(m.size());
        outputM(m);
    }

    void outputM(Map<String, String> m) {
        for (String k : m.keySet()) pr(k + " " + m.get(k));
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
        new B501().run();
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