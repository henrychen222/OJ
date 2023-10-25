/**
 * 03/31/23 night
 * http://poj.org/problem?id=3917
 */
package poj.page30.p3917;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- http://poj.org/showsource?solution_id=24069751
    void solve(char[] a, char[] b) {
        int n = a.length, winA = 0, winB = 0;
        for (int i = 0; i < n; i++) {
            if (win(a[i], b[i])) winA++;
            if (win(b[i], a[i])) winB++;
        }
        pr("P1: " + winA);
        pr("P2: " + winB);
    }

    boolean win(char x, char y) {
        return (x == 'R' && y == 'S') || (x == 'P' && y == 'R') || (x == 'S' && y == 'P');
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        while (true) {
            char[] a = fs.next().toCharArray(), b = fs.next().toCharArray();
            if (Arrays.equals(a, new char[]{'E'})) break;
            solve(a, b);
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