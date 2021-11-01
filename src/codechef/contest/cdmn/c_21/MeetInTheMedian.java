/**
 * 09/02/21 morning
 * https://www.codechef.com/CDMN21C/problems/SUBMEDIA
 */
package codechef.contest.cdmn.c_21;

import java.util.*;
import java.io.*;

class MeetInTheMedian {

    static PrintWriter pw;

    // don't know in contest
    // reference: https://www.codechef.com/viewsolution/50490353
    // Accepted --- 1.82sec https://www.codechef.com/viewsolution/50526214
    void solve(int n, int k, int[] a) {
        // tr(n, k, a);
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++) pos[i] = i;
        // tr(pos);
        Arrays.sort(pos, (x, y) -> a[y] - a[x]);
        pr(a[pos[k / 2]]);
        // tr(pos);
        Arrays.sort(pos, 0, k);
        // tr(pos);
        for (int i = 0; i < k; i++) pw.print(a[pos[i]] + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, k, a);
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
        new MeetInTheMedian().run();
        pw.close();
    }

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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