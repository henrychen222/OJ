/**
 * 10/31/21 night
 * https://codeforces.com/problemset/problem/120/A
 *
 * be careful this problem must keep read_write_file()
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class A120 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/120/133886336
    private void run() {
        read_write_file(); // keep this for input output problem
        FastScanner fs = new FastScanner();
        String door = fs.next();
        String rail = fs.next();
        if (door.equals("front")) {
            if (rail.equals("1")) {
                System.out.println("L");
            } else {
                System.out.println("R");
            }
        } else {
            if (rail.equals("1")) {
                System.out.println("R");
            } else {
                System.out.println("L");
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
        new A120().run();
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}