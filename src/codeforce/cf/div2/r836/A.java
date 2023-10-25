/**
 * 11/25/22 morning
 * https://codeforces.com/contest/1758/problem/0
 */
package codeforce.cf.div2.r836;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    // Pretests passed
    void solve(char[] s) {
        int n = s.length;
        char[] res = new char[n];
        Map<Character, Integer> m = counter(s);
        int l = 0, r = n - 1;
        for (char c : m.keySet()) {
            int occ = m.get(c), h = occ / 2;
            for (int i = 0; i < h; i++) res[l++] = c;
            for (int i = 0; i < h; i++) res[r--] = c;
        }
        pr(new String(res));
    }

    Map<Character, Integer> counter(char[] a) {
        Map<Character, Integer> m = new HashMap<>();
        for (char x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            char[] s = fs.next().repeat(2).toCharArray();
            solve(s);
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}