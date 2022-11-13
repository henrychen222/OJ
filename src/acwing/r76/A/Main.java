/**
 * 11/05/22 morning
 * https://www.acwing.com/problem/content/4716/
 */
package acwing.r76.A;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s = fs.next(), t = fs.next();
        pr(reverse(s).equals(t) ? "YES" : "NO");
    }

    String reverse(String s) {
        int n = s.length();
        String res = "";
        for (int i = n - 1; i >= 0; i--) res += s.charAt(i);
        return res;
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
        new Main().run();
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