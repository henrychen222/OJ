/**
 * 11/05/22 morning
 * https://www.acwing.com/problem/content/4717/
 */
package acwing.r76.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    void solve(char[] s) {
        Map<Character, Integer> m = counter(s);
        long res = 0;
        for (char c : s) res += m.get(c);
        pr(res);
    }

    Map<Character, Integer> counter(char[] a) {
        Map<Character, Integer> m = new HashMap<>();
        for (char x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        char[] s = fs.next().toCharArray();
        solve(s);
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